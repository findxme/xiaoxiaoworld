package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.entity.messageInfo.StatusInfo;
import com.xmx.ssm.service.TBookReaderService;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.TReadersService;
import com.xmx.ssm.util.PageLimit;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tBookReader")
public class TBookReaderController {

    @Autowired
    private TBookReaderService tBookReaderService;

    @Autowired
    private TBooksService tBooksService;

    @Autowired
    private TReadersService tReadersService;

    @RequestMapping("/bookInfoPage")
    public String bookInfo(){
        return "book_reader/bookInfo";
    }

    @RequestMapping("/bookBorrowReturnInfo")
    public String bookBorrowReturnInfo(){
        return "/WEB-INF/views/book_reader/worksheetInfo.jsp";
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
    public JSONObject getBookInfo(int page,int limit){

//        System.err.println(tBookReaderService.findAll());

        List<Map<String,Object>> list =  tBookReaderService.pagingInfo(page,limit);
//        List<Map<String,Object>> list =  tBookReaderService.findAll();

//        System.err.println(PageLimit.layuiJson(0,"",tBookReaderService.countInfos(),list));
        return PageLimit.layuiJson(0,"",tBookReaderService.countInfos(),list);
    }


    @RequestMapping("borrowBook")
    @ResponseBody
    public StatusInfo borrowBook(@Param("bookNo")String bookNo,
                                 @Param("readerNo")String readerNo){
        TBook tBook = tBooksService.selectByPrimaryKey(bookNo);
        TReader tReader = tReadersService.findReaderByNo(readerNo);
        int result = tBookReaderService.borrowBook(tBook,tReader);
        StatusInfo statusInfo = new StatusInfo();
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
        return statusInfo;
    }

    @RequestMapping("returnBook")
    @ResponseBody
    public StatusInfo returnBook(@Param("bookNo")String bookNo,
                                 @Param("readerNo")String readerNo){
        TBook tBook = tBooksService.selectByPrimaryKey(bookNo);
        TReader tReader = tReadersService.findReaderByNo(readerNo);
        int result = tBookReaderService.returnBook(tBook,tReader);
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
            statusInfo.setMessage("");
        }
        return statusInfo;
    }


    @ResponseBody
    @RequestMapping("/selectDay")
    public JSONObject selectDay(int page, int limit) {
        int currIndex = (page - 1) * limit;
        List<Map<String, Object>> books = tBookReaderService.selectDay(currIndex,limit);

        JSONObject json = PageLimit.layuiJson(0, "", tBookReaderService.countBydayQuantity(), books);
        return json;
    }
}

