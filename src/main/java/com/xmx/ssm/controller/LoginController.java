package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.entity.messageInfo.StatusInfo;
import com.xmx.ssm.service.TAdminService;
import com.xmx.ssm.service.TBookReaderService;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.TReadersService;
import com.xmx.ssm.util.CookiesDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private TAdminService tAdminService;

    @Autowired
    private TReadersService tReadersService;

    @Autowired
    public TBooksService tBooksService;

    @Autowired
    public TBookReaderService tBookReaderService;


    @RequestMapping(value = "index")
    public String goHome(){
        return "/home/console";
    }


    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public StatusInfo login(@Param("userName")String userName,
                            @Param("password")String password,
                            @Param("userType")String userType){
        StatusInfo statusInfo = new StatusInfo();


        if(userName==null||password==null||"".equals(userName)||"".equals(password)){
            statusInfo.setStatus(405);
            statusInfo.setMessage("用户或密码不能为空");
            return statusInfo;
        }



        if("reader".equals(userType)){
            TReader tReader = tReadersService.findReaderByName(userName);
            if(tReader==null){
                statusInfo.setStatus(404);
                statusInfo.setMessage("不存在该用户");
            }else{
                if(!tReader.getbReaderPassword().equals(password)){
                    statusInfo.setStatus(500);
                    statusInfo.setMessage("用户密码错误");
                }else{
                    statusInfo.setMessage(tReader.getbReaderNo());
                }
            }
        }else {
            TAdmin tAdmin = tAdminService.findAdminByName(userName);
            if(tAdmin==null){
                statusInfo.setStatus(404);
                statusInfo.setMessage("不存在该管理员");
            }else{
                if(tAdmin.getbAdminPassword().equals(password)){
                    statusInfo.setMessage(tAdmin.getbAdminNo());
                }else{
                    statusInfo.setStatus(500);
                    statusInfo.setMessage("密码错误");
                }
            }
        }
        return statusInfo;
    }
    @RequestMapping("/list")
    public String findBooksAll(){
        return "app/content/list";

    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/loginOut")
    public void loginOut(HttpServletRequest request,HttpServletResponse response){
        System.out.println("跳转到loginOut");
//        CookiesDao.LoginOut(request,response);
//        return "redirect:toLogin";
    }

    @RequestMapping(value = "home")
    public String toHome(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/dataStatistics")
    public ModelAndView DataStatistics(ModelAndView modelAndView){
       long readersQuantity= tReadersService.countByExample();
       long booksQuantity = tBooksService.countByExample();
       long adminQuantity = tAdminService.countByExample();
        System.out.println(readersQuantity);
        /*查询书籍总数*/
        long tbookQuantity=tBooksService.countByBooksTotal();
        /*查询多少书借出去了*/
        long borrowingQuantity =  tBookReaderService.findReadersBorrowingQuantity();
        /*未借书籍*/
        long notBorrowingBooks =tbookQuantity-borrowingQuantity;

        JSONObject jsonBooks = new JSONObject();
//        jsonBooks.put("notBorrowingBooks",notBorrowingBooks);
//        jsonBooks.put("borrowingQuantity",borrowingQuantity);
        System.out.println("借出书籍"+borrowingQuantity);
        System.out.println("未借书籍"+notBorrowingBooks);
        Map<String, Object> map = new HashMap<>();
        map.put("adminQuantity",adminQuantity);
        map.put("tbookQuantity",tbookQuantity);
        map.put("readersQuantity",readersQuantity);
        map.put("booksQuantity",booksQuantity);
        map.put("notBorrowingBooks",notBorrowingBooks);
        map.put("borrowingQuantity",borrowingQuantity);
        modelAndView.addObject("map",map);

//        modelAndView.addObject("jsonBooks",jsonBooks);
        modelAndView.setViewName("/home/console");
        return modelAndView;
    }

//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    @ResponseBody
//    public StatusInfo register(@RequestParam("userType")String userType,
//                           @RequestParam("username")String username,
//                           @RequestParam("password")String password,
//                           @RequestParam("email")String email,
//                           @RequestParam("mobile")String mobile,
//                           @RequestParam("address")String address,
//                           @RequestParam("city")String city){
////        User user = new User();
////        user.setUserType(userType);
////        user.setUserName(username);
////        user.setPassword(password);
////        user.setEmail(email);
////        user.setMobile(mobile);
////        user.setAddress(address);
////        user.setCity(city);
////        int result = userService.insertUser(user);
////        StatusInfo info = new StatusInfo();
////        if(result==1){
////            info.setMessage("注册成功");
////        }else{
////            info.setStatus(500);
////            info.setMessage("注册失败");
////        }
//        return info;
//    }
}
