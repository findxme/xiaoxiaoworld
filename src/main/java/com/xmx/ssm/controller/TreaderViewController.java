package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.service.TAdminService;
import com.xmx.ssm.service.TBookReaderService;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.TReadersService;
import com.xmx.ssm.service.impl.TSmtpServiceImpl;
import com.xmx.ssm.util.Email;
import com.xmx.ssm.util.PageLimit;
import com.xmx.ssm.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/readerView")
public class TreaderViewController {

    @Autowired
    private TAdminService tAdminService;

    @Autowired
    private TReadersService tReadersService;

    @Autowired
    public TBooksService tBooksService;

    @Autowired
    public TBookReaderService tBookReaderService;


    @Autowired
    private TSmtpServiceImpl tSmtpService;

    @RequestMapping("/dataStatistics")
    public ModelAndView dataStatistics(ModelAndView modelAndView){
       // System.out.println("请求到了这里");
        long readersQuantity = tReadersService.countByExample();
        long booksQuantity = tBooksService.countByExample();
        long adminQuantity = tAdminService.countByExample();
        System.out.println(readersQuantity);
        /*查询书籍总数*/
        long tbookQuantity = tBooksService.countByBooksTotal();
        /*查询多少书借出去了*/
        long borrowingQuantity = tBookReaderService.findReadersBorrowingQuantity();
        /*未借书籍*/
        long notBorrowingBooks = tbookQuantity - borrowingQuantity;

        JSONObject jsonBooks = new JSONObject();
//        jsonBooks.put("notBorrowingBooks",notBorrowingBooks);
//        jsonBooks.put("borrowingQuantity",borrowingQuantity);
      //  System.out.println("借出书籍" + borrowingQuantity);
       // System.out.println("未借书籍" + notBorrowingBooks);
        Map<String, Object> map = new HashMap<>();
        map.put("adminQuantity", adminQuantity);
        map.put("tbookQuantity", tbookQuantity);
        map.put("readersQuantity", readersQuantity);
        map.put("booksQuantity", booksQuantity);
        map.put("notBorrowingBooks", notBorrowingBooks);
        map.put("borrowingQuantity", borrowingQuantity);
        modelAndView.addObject("map", map);
        System.out.println("测试："+map.get("notBorrowingBooks"));

        modelAndView.addObject("jsonBooks",jsonBooks);
        modelAndView.setViewName("home/readerConsole");
        return modelAndView;
    }
    @RequestMapping("/list")
    public ModelAndView bookList(ModelAndView modelAndView) {

        modelAndView.setViewName("template/reader_book_list");
        return modelAndView;

    }
@RequestMapping("goReaderPassword")
public ModelAndView goReaderPassword(ModelAndView modelAndView) {

    List<Map<String ,Object>> listBooks= tBooksService.findReaderLookBooksAll();
    modelAndView.addObject("listBooks",listBooks);
    modelAndView.setViewName("readerLook/password");
    return modelAndView;
}

    @RequestMapping("/goodslist")
    public ModelAndView goodslist(ModelAndView modelAndView) {

   List<Map<String ,Object>> listBooks= tBooksService.findReaderLookBooksAll();
       long i= tBooksService.countByExample();
        System.out.println("总共有i条数据"+i);

        modelAndView.addObject("listBooks",listBooks);
        modelAndView.addObject("booksByExample",i);
        modelAndView.setViewName("template/goodslist");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/setUser")
    public int setUser(HttpSession session, @RequestParam(value = "email", defaultValue = "") String email, @RequestParam(value = "remarks", defaultValue = "") String remarks) {
        Map<String, Object> smtp = tSmtpService.selectSmtp();


        if (!"".equals(email) || !"".equals(remarks)) {

            TReader tReader = new TReader();
           System.out.println("请求到来这里，传递的参数为"+email);
            System.out.println("该用户为："+session.getAttribute("userName"));
            tReader.setbReaderName(session.getAttribute("userName").toString());
            if (!"".equals(email)) {
                tReader.setbReaderEmail(email);
            }
            if (!"".equals(remarks)) {
                tReader.setbReaderRemarks(remarks);
            }
            System.out.println("最终的传入参数是这个"+tReader.toString());

            String  email2=tReadersService.findReaderOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_reader_email").toString();
            System.err.println("查出的数据："+email2);

            tReadersService.updateByName(tReader);

            Email.sendEmail(email2, "提示", Email.hint("账号信息修改成功"));

        } else {
            return 0;
        }

        return 1;
    }
    @RequestMapping("/readerInfo")
    public ModelAndView info(ModelAndView modelAndView) {
      //  System.out.println("请求到这个地方");
       // modelAndView.addObject("userName", session.getAttribute("userName"));
        modelAndView.setViewName("readerLook/info");
        return modelAndView;
    }

    /**
     * @param session 获取邮箱验证码
     */
    @ResponseBody
    @RequestMapping("/getAuthCode")
    public void getAuthCode(HttpSession session) {
        Map<String, Object> smtp = tSmtpService.selectSmtp();


        String authCode = RandomUtil.generateString(5) + String.valueOf(System.currentTimeMillis()).substring(8);
        System.out.println("readerd修改密码的验证码"+authCode);
        String readerGetAuthCode =tReadersService.findReaderOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_reader_email").toString();
        System.out.println("当前登陆帐户的邮箱"+readerGetAuthCode);
        if (Email.sendEmail(readerGetAuthCode,"验证码", Email.text("修改密码", authCode))) {
            session.setAttribute("authCode", authCode);
            System.err.println(session.getAttribute("authCode"));
        }
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param repassword
     * @param authCode
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/setPassword")
    public int setPassword(@RequestParam(value = "oldPassword", defaultValue = "") String oldPassword, @RequestParam(value = "repassword", defaultValue = "") String repassword, @RequestParam(value = "authCode", defaultValue = "") String authCode, HttpSession session) {
        if (!"".equals(oldPassword) && !"".equals(authCode) && !"".equals(repassword)) {
            try {
                //System.out.println("运行到了try");
                if (session.getAttribute("authCode").equals(authCode)) {
                    if (oldPassword.equals(tReadersService.findReaderOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_reader_password"))) {
                        TReader tReader = new TReader();
                        tReader.setbReaderName(String.valueOf(session.getAttribute("userName")));
                        tReader.setbReaderPassword(repassword);
                        System.out.println("目前他reader里面的信息"+tReader.toString());
                        tReadersService.updateByName(tReader);
                    } else {

                        return 1;//旧密码错误
                    }
                } else {
                    return 2;//验证码错误
                }
            } catch (Exception e) {
                return 3;//异常
            }
        }
        session.setAttribute("authCode", null);
        Email.sendEmail(tReadersService.findReaderOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_reader_email").toString(),"验证码", Email.text("修改密码", authCode));
        return 0;//修改成功
    }


    @ResponseBody
    @RequestMapping("/findOneReaderByBook")
    public JSONObject findOneReaderByBook( HttpSession session,int page, int limit) {
        System.out.println("请求道了这里");
        int currIndex = (page - 1) * limit;
        System.out.println("当前用户为"+String.valueOf(session.getAttribute("userName")));
        List<Map<String, Object>> readerByBookOne = tBookReaderService.findOneReaderByBook(String.valueOf(session.getAttribute("userName")),currIndex,limit);
        System.err.println("查出的参数"+readerByBookOne);
        System.err.println("查出的数据条数"+ tBookReaderService.findOneReaderByBookQuantity(String.valueOf(session.getAttribute("userName"))));
        JSONObject json = PageLimit.layuiJson(0, "", tBookReaderService.findOneReaderByBookQuantity(String.valueOf(session.getAttribute("userName"))), readerByBookOne);
        return json;
    }
}
