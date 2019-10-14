package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpResponse;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.entity.messageInfo.StatusInfo;
import com.xmx.ssm.service.TAdminService;
import com.xmx.ssm.service.TBookReaderService;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.TReadersService;
import com.xmx.ssm.service.impl.TSmtpServiceImpl;
import com.xmx.ssm.util.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


    @Autowired
    private TSmtpServiceImpl tSmtpService;


    @RequestMapping(value = "index")
    public String goHome() {
        return "/home/console";
    }

    @ResponseBody
    @RequestMapping(value = "verifyCode")
    public void verifyCode(HttpServletResponse response, HttpSession session) throws IOException {

        String authCode = RandomUtil.generateString(4);
        //生成图片
        int width = 100;//宽
        int height = 40;//高
        VerifyCodeUtils.outputImage(width, height, response.getOutputStream(), authCode);
        session.setAttribute("verifyCodeImg", authCode);
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.setAttribute("userName", null);
        return "redirect:/user/toLogin";
    }

    @ResponseBody
    @RequestMapping("/isVerifyCode")
    public int isVerifyCode(@RequestParam(value = "verifyCode", defaultValue = "") String verifyCode, HttpSession session) {
        String verifyCodeImg = session.getAttribute("verifyCodeImg").toString().toUpperCase();

        System.err.println(verifyCodeImg + "," + verifyCode.toUpperCase());
        if ((verifyCode.toUpperCase()).equals(verifyCodeImg)) {
            return 0;
        }
        return 1;
    }


    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        // return "login";
        return "login2";
    }

    @ResponseBody
    @RequestMapping("/isExistUser")
    public int isExistUser(String username) {
        List<Map<String, Object>> adminOne = tAdminService.findAdminOne(username);
        if (adminOne.size() == 0) {
            return 0;
        }
        return 1;
    }

    @ResponseBody
    @RequestMapping("/isExistPhone")
    public int isExistPhone(String phone) {
        TAdmin adminByNo = null;
        adminByNo = tAdminService.findAdminByNo(phone);
        if (adminByNo == null) {
            return 0;
        }
        return 1;
    }


    @RequestMapping("/login2")
    @ResponseBody
    public JSONObject login2(@Param("userName") String userName,
                             @Param("password") String password,
                             @Param("userType") String userType,
                             HttpSession session) {
        List<Object> objects = new ArrayList<Object>();


        JSONObject json = null;

        if (userName == null || password == null || "".equals(userName) || "".equals(password)) {
//            statusInfo.setStatus(405);
//            statusInfo.setMessage("用户或密码不能为空");
//            map.put("msg","用户或密码不能为空");
//            map.put("code",1);
            json = PageLimit.layuiJson(0, "用户或密码不能为空", 1, objects);
            return json;
        }


        if ("reader".equals(userType)) {
            TReader tReader = tReadersService.findReaderByName(userName);
            if (tReader == null) {
//                statusInfo.setStatus(404);
//                statusInfo.setMessage("不存在该用户");
                json = PageLimit.layuiJson(0, "不存在该用户", 1, objects);
//                map.put("msg","不存在该用户");
//                map.put("code",1);

            } else {
                if (!tReader.getbReaderPassword().equals(password)) {
//                    statusInfo.setStatus(500);
//                    statusInfo.setMessage("用户密码错误");
                    json = PageLimit.layuiJson(0, "用户密码错误", 1, objects);
                } else {
//                    statusInfo.setMessage(tReader.getbReaderNo());
                    json = PageLimit.layuiJson(0, tReader.getbReaderNo(), 0, objects);
                }
            }
        } else {
            TAdmin tAdmin = tAdminService.findAdminByName(userName);
            if (tAdmin == null) {
//                statusInfo.setStatus(404);
//                statusInfo.setMessage("不存在该管理员");
                json = PageLimit.layuiJson(0, "不存在该管理员", 1, objects);
            } else {
                if (tAdmin.getbAdminPassword().equals(password)) {
                    json = PageLimit.layuiJson(0, tAdmin.getbAdminNo(), 0, objects);
//                    statusInfo.setMessage(tAdmin.getbAdminNo());
                } else {
//                    statusInfo.setStatus(500);
//                    statusInfo.setMessage("密码错误");
                    json = PageLimit.layuiJson(0, "密码错误", 1, objects);
                }
            }
        }

        session.setAttribute("userName", userName);
        return json;
    }


    @RequestMapping(value = "/login")
    @ResponseBody
    public StatusInfo login(@Param("userName") String userName,
                            @Param("password") String password,
                            @Param("userType") String userType,
                            HttpSession session) {
        StatusInfo statusInfo = new StatusInfo();

        System.err.println(userName + "," + password + "," + userType);

        if (userName == null || password == null || "".equals(userName) || "".equals(password)) {
            statusInfo.setStatus(405);
            statusInfo.setMessage("用户或密码不能为空");
            return statusInfo;
        }


        if ("reader".equals(userType)) {
            TReader tReader = tReadersService.findReaderByName(userName);
            if (tReader == null) {
                statusInfo.setStatus(404);
                statusInfo.setMessage("不存在该用户");
            } else {
                if (!tReader.getbReaderPassword().equals(password)) {
                    statusInfo.setStatus(500);
                    statusInfo.setMessage("用户密码错误");
                } else {
                    statusInfo.setMessage(tReader.getbReaderNo());
                }
            }
        } else {
            TAdmin tAdmin = tAdminService.findAdminByName(userName);
            if (tAdmin == null) {
                statusInfo.setStatus(404);
                statusInfo.setMessage("不存在该管理员");
            } else {
                if (tAdmin.getbAdminPassword().equals(password)) {
                    statusInfo.setMessage(tAdmin.getbAdminNo());
                } else {
                    statusInfo.setStatus(500);
                    statusInfo.setMessage("密码错误");
                }
            }
        }
        session.setAttribute("userName", userName);
        return statusInfo;
    }

    @RequestMapping("/list")
    public String findBooksAll() {
        return "app/content/list";

    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        //  return "register";
        return "reg";
    }

    @RequestMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) {

        //System.out.println("跳转到loginOut");
        CookiesDao.LoginOut(request, response);
//        return "redirect:toLogin";
    }

    @RequestMapping(value = "home")
    public String toHome() {

        //登录成功，获取邮件服务信息

        Map<String, Object> smtp = tSmtpService.selectSmtp();

        Email.setiEmail(smtp.get("email").toString());
        Email.setHostName(smtp.get("smtp").toString());
        Email.setName(smtp.get("name").toString());
        Email.setUserName(smtp.get("email").toString());
        Email.setPassword(smtp.get("password").toString());
        Email.setPort(Integer.parseInt(smtp.get("prot").toString()));

        return "test";
    }

    @ResponseBody
    @RequestMapping("/dataStatistics")
    public ModelAndView DataStatistics(ModelAndView modelAndView) {
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
        System.out.println("借出书籍" + borrowingQuantity);
        System.out.println("未借书籍" + notBorrowingBooks);
        Map<String, Object> map = new HashMap<>();
        map.put("adminQuantity", adminQuantity);
        map.put("tbookQuantity", tbookQuantity);
        map.put("readersQuantity", readersQuantity);
        map.put("booksQuantity", booksQuantity);
        map.put("notBorrowingBooks", notBorrowingBooks);
        map.put("borrowingQuantity", borrowingQuantity);
        modelAndView.addObject("map", map);

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


    /**
     * 注册账户
     * <p>
     * //     * @param oldPassword
     * //     * @param repassword
     * //     * @param authCode
     * //     * @param session
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/registerUser")
    public int setRegister_form(String username, String email, String phone, String vercode, String password, String show, HttpSession session) {


        if ((session.getAttribute("registerAuthCode")).equals(vercode)) {
            if (show.equals("1")) {
                TAdmin tAdmin = new TAdmin();
                tAdmin.setbAdminNo(phone);
                tAdmin.setbAdminName(username);
                tAdmin.setbAdminPassword(password);
                tAdmin.setbAdminEmail(email);
                tAdmin.setbAdminType(show);
                // System.out.println("执行"+"");
                tAdminService.insertSelective(tAdmin);
                // return

            } else if (show.equals("2")) {
                TReader tReader = new TReader();
                tReader.setbReaderNo(phone);
                tReader.setbReaderName(username);
                tReader.setbReaderEmail(email);
                tReader.setbReaderPassword(password);
                tReader.setbReaderMobile(phone);
                tReadersService.insertReaderSelective(tReader);


            }

        } else if (session.getAttribute("registerAuthCode") == null) {
            //System.out.println("请获取验证码1");
            return 2;//未获取验证码
        } else {  //System.out.println("验证码错误" + "");
            return 3;//验证码错误

        }

        return 1;//注册成功
    }
}
