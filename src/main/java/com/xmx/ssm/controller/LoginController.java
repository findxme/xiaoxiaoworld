package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TReader;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xmx.ssm.util.AES.aesDecrypt;

@Controller
@RequestMapping("/user")
public class LoginController {

    private static final String KEY = "qwertyuiqwertyui";

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
    public void verifyCode(HttpServletResponse response, HttpSession session) throws IOException, NoSuchAlgorithmException {

        String authCode = RandomUtil.generateString(4);
        //生成图片
        int width = 100;//宽
        int height = 40;//高
        VerifyCodeUtils.outputImage(width, height, response.getOutputStream(), authCode);


        String md5 = VerifyCodeUtils.Md5(authCode.toUpperCase());

        System.err.println("MD5:" + md5);
        //图片验证码MD5
        session.setAttribute("verifyCodeImg", md5);
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.setAttribute("userName", null);
        return "redirect:/user/toLogin";
    }

    @ResponseBody
    @RequestMapping("/isVerifyCode")
    public int isVerifyCode(@RequestParam(value = "verifyCode", defaultValue = "") String verifyCode, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String verifyCodeImg = session.getAttribute("verifyCodeImg").toString();
        String md5 = VerifyCodeUtils.Md5(verifyCode.toUpperCase());

        //图片验证码输入MD5
        System.err.println("session：" + verifyCodeImg + ",输入：" + VerifyCodeUtils.Md5(verifyCode.toUpperCase()));
        if (md5.equals(verifyCodeImg)) {
            return 0;
        }
        return 1;
    }


    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        // return "login";
        return "login";
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


    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login2(@Param("userName") String userName,
                             @Param("password") String password,
                             @Param("userType") String userType,
                             HttpSession session) {
        List<Object> objects = new ArrayList<Object>();


        JSONObject json = null;

        if (userName == null || password == null || "".equals(userName) || "".equals(password)) {

            json = PageLimit.layuiJson(0, "用户或密码不能为空", -1, objects);
            return json;
        }


        if ("reader".equals(userType)) {
            TReader tReader = tReadersService.findReaderByName(userName);
            if (tReader == null) {

                json = PageLimit.layuiJson(0, "不存在该用户", -1, objects);


            } else {
                if (!tReader.getbReaderPassword().equals(password)) {

                    json = PageLimit.layuiJson(0, "用户密码错误", -1, objects);
                } else {

                    session.setAttribute("userName", userName);
                    json = PageLimit.layuiJson(0, tReader.getbReaderNo(), 1, objects);
                }
            }
        } else {
            TAdmin tAdmin = tAdminService.findAdminByName(userName);
            if (tAdmin == null) {

                json = PageLimit.layuiJson(0, "不存在该管理员", -1, objects);
            } else {
                if (tAdmin.getbAdminPassword().equals(password)) {
                    session.setAttribute("adminNo", tAdmin.getbAdminNo());
                    session.setAttribute("userName", userName);
                    json = PageLimit.layuiJson(0, tAdmin.getbAdminNo(), 0, objects);

                } else {

                    json = PageLimit.layuiJson(0, "密码错误", -1, objects);
                }
            }
        }

        return json;
    }

    @RequestMapping("/list")
    public String findBooksAll() {
        return "app/content/list";

    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        //  return "register";
        return "register";
    }

    @RequestMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) {

        //System.out.println("跳转到loginOut");
        CookiesDao.LoginOut(request, response);
//        return "redirect:toLogin";
    }

    @RequestMapping("/toReaderHome")
    public ModelAndView toReaderHome(ModelAndView modelAndView, HttpSession session) {

        Map<String, Object> smtp = tSmtpService.selectSmtp();

        Email.setiEmail(smtp.get("email").toString());
        Email.setHostName(smtp.get("smtp").toString());
        Email.setName(smtp.get("name").toString());
        Email.setUserName(smtp.get("email").toString());
        try {

            Email.setPassword(aesDecrypt(smtp.get("password").toString(), KEY));
            System.err.println(Email.getPassword());
        } catch (Exception e) {
        }

        try {
            Email.setPort(Integer.parseInt(smtp.get("prot").toString()));
        } catch (NumberFormatException e) {
            Email.setPort(Integer.parseInt("587"));
            e.printStackTrace();
        }

        modelAndView.addObject("userNmae", session.getAttribute("userName"));
        modelAndView.setViewName("readerTest");
        return modelAndView;
    }

    @RequestMapping(value = "home")
    public ModelAndView toHome(HttpSession session, ModelAndView modelAndView) {

        //登录成功，获取邮件服务信息

        Map<String, Object> smtp = tSmtpService.selectSmtp();

        Email.setiEmail(smtp.get("email").toString());
        Email.setHostName(smtp.get("smtp").toString());
        Email.setName(smtp.get("name").toString());
        Email.setUserName(smtp.get("email").toString());
        try {
            Email.setPassword(aesDecrypt(smtp.get("password").toString(), KEY));
            System.err.println(Email.getPassword());
        } catch (Exception e) {

            Email.setPort(Integer.parseInt(smtp.get("prot").toString()));

            Email.setPort(Integer.parseInt("587"));
            e.printStackTrace();
        }

        modelAndView.addObject("userNmae", session.getAttribute("userName"));
        modelAndView.addObject("adminNo", session.getAttribute("adminNo"));
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/dataStatistics")
    public ModelAndView DataStatistics(ModelAndView modelAndView) {
        System.out.println("运行到控制台");
        System.err.println("运行到控制台");

        try {
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
        } catch (Exception e) {
            modelAndView.setViewName("/home/404");
            e.printStackTrace();
        }
        return modelAndView;
    }


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
