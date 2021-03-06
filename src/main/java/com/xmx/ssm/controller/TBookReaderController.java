package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.entity.messageInfo.StatusInfo;
import com.xmx.ssm.service.*;
import com.xmx.ssm.util.PageLimit;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/tBookReader")
public class TBookReaderController {

    @Autowired
    private TBooksTypeService tBooksTypeService;

    @Autowired
    private TBookReaderService tBookReaderService;

    @Autowired
    private TBooksService tBooksService;

    @Autowired
    private TReadersService tReadersService;

    @Autowired
    private TAdminService tAdminService;

    @RequestMapping("/bookInfoPage")
    public String bookInfo(){
        return "book_reader/bookInfo";
    }

    @RequestMapping("/bookBorrowReturnInfo")
    public String bookBorrowReturnInfo(){
        return "book_reader/worksheetInfo";
    }

//    JSONObject json = new JSONObject();

    /**
     * 借阅信息分页查询
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/books")
    @ResponseBody
    public JSONObject getBookInfo(@Param("keyWord")String keyWord,@Param("startDate")String startDate,@Param("endDate")String endDate,int page,int limit){
        List<Map<String,Object>> list =  tBookReaderService.pagingInfo(keyWord,startDate,endDate,page,limit);
        System.out.println("key:"+keyWord);
        System.out.println("startDate:"+startDate);
        System.out.println("endDate:"+endDate);
        for(Map<String,Object> map:list){
            System.out.println(map.get("b_return_date"));
            if(map.get("b_return_date")==null||"".equals(map.get("b_return_date"))){
                map.put("b_return_date","-");
            }
        }
        return PageLimit.layuiJson(0,"",tBookReaderService.countInfos(),list);
    }

    @RequestMapping("/notReturnBook")
    @ResponseBody
    public JSONObject getNotReturnBook(@Param("startDate")String startDate,
                                       @Param("endDate")String endDate,
                                       @Param("keyWord")String keyWord,
                                       int page,
                                       int limit){
        System.out.println("startDate:"+startDate);
        List<Map<String,Object>> list =  tBookReaderService.queryNotReturnInfo(startDate,endDate,keyWord,page,limit);
        long size = tBookReaderService.findReadersBorrowingQuantity();
        System.out.println(list);
        return PageLimit.layuiJson(0,"",size,list);
    }


    @RequestMapping("borrowBook")
    @ResponseBody
    public StatusInfo borrowBook(@Param("bookNo")String bookNo,
                                 @Param("readerNo")String readerNo,
                                 @Param("adminNo")String adminNo){
        TBook tBook = tBooksService.selectByPrimaryKey(bookNo);
        TReader tReader = tReadersService.findReaderByNo(readerNo);
        TAdmin tAdmin = tAdminService.findAdminByNo(adminNo);
        int result = tBookReaderService.borrowBook(tBook,tReader,tAdmin);
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setMessage("借书成功");
        if(result==0){
            statusInfo.setStatus(500);
            statusInfo.setMessage("借书失败");
        }
        if(result==-1){
            statusInfo.setStatus(404);
            statusInfo.setMessage("用户只能借5本书");
        }
        if(result==-2){
            statusInfo.setStatus(555);
            statusInfo.setMessage("本书，你已借过");
        }
        if(result==-3){
            statusInfo.setStatus(501);
            statusInfo.setMessage("书已借完");
        }
        if(result==-4){
            statusInfo.setStatus(502);
            statusInfo.setMessage("查无此人");
        }
        return statusInfo;
    }

    @RequestMapping("returnBook")
    @ResponseBody
    public StatusInfo returnBook(@Param("bookNo")String bookNo,
                                 @Param("readerNo")String readerNo,
                                 @Param("adminNo")String adminNo){



        TBook tBook = tBooksService.selectByPrimaryKey(bookNo);
        TReader tReader = tReadersService.findReaderByNo(readerNo);
        TAdmin tAdmin = tAdminService.findAdminByNo(adminNo);

        int result = tBookReaderService.returnBook(tBook,tReader,tAdmin);
        StatusInfo statusInfo = new StatusInfo();
        if(result==-2){
            statusInfo.setStatus(404);
            statusInfo.setMessage("未借该书");
        }else if(result==-1){
            statusInfo.setStatus(555);
            statusInfo.setMessage("暂定");
        }else if(result== 0){
            statusInfo.setStatus(500);
            statusInfo.setMessage("还书出错");
        }else{
            statusInfo.setMessage("还书成功");
        }
        return statusInfo;
    }


    @RequestMapping("/borrowingInfo")
    public String borRetInfo(){
        return "book_reader/returnOrRenew";
    }

    @ResponseBody
    @RequestMapping("/selectDay")
    public JSONObject selectDay(int page, int limit) {
        int currIndex = (page - 1) * limit;
        List<Map<String, Object>> books = tBookReaderService.selectDay(currIndex,limit);

        JSONObject json = PageLimit.layuiJson(0, "", tBookReaderService.countBydayQuantity(), books);
        return json;
    }


    @RequestMapping("/renewBook")
    @ResponseBody
    public StatusInfo renewBook(@Param("bookNo")String bookNo,
                                @Param("readerNo")String readerNo){
        TBook tBook = tBooksService.selectByPrimaryKey(bookNo);
        TReader tReader = tReadersService.findReaderByNo(readerNo);
        StatusInfo statusInfo = new StatusInfo();
        int result = tBookReaderService.renewBook(tBook,tReader);
        if(result==-1){
            statusInfo.setStatus(403);
            statusInfo.setMessage("续借次数已用完");
        }else if(result==0){
            statusInfo.setStatus(404);
            statusInfo.setMessage("没借过");
        }else if(result==1){
            statusInfo.setMessage("续借成功");
        }
        return statusInfo;
    }

    @RequestMapping("/dropBox")
    @ResponseBody
    public List<Map<String,Object>> dropBox(){
        List<Map<String,Object>> tBookTypes = tBooksTypeService.selectBooksType();
        return tBookTypes;
    }
}

