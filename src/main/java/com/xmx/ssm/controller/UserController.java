package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TSmtp;
import com.xmx.ssm.service.impl.TAdminServiceImpl;
import com.xmx.ssm.service.impl.TSmtpServiceImpl;
import com.xmx.ssm.util.AES;
import com.xmx.ssm.util.Email;
import com.xmx.ssm.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static com.xmx.ssm.util.AES.aesDecrypt;
import static com.xmx.ssm.util.AES.aesEncrypt;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final String KEY = "qwertyuiqwertyui";

    @Autowired
    private TAdminServiceImpl tAdminService;

    @Autowired
    private TSmtpServiceImpl tSmtpService;

    @RequestMapping("/password")
    public String password() {
        return "admin/password";
    }

    @RequestMapping("/info")
    public ModelAndView info(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("userName", session.getAttribute("userName"));
        modelAndView.setViewName("admin/info");
        return modelAndView;
    }

    @RequestMapping("/email")
    public ModelAndView email(ModelAndView modelAndView) {
        Map<String, Object> smtp = tSmtpService.selectSmtp();
        modelAndView.addObject("email", smtp.get("email"));
        modelAndView.addObject("name", smtp.get("name"));
        try {
            System.err.println(aesDecrypt(smtp.get("password").toString()));
            modelAndView.addObject("password", aesDecrypt(smtp.get("password").toString()));
        }catch (Exception e){
        }
        modelAndView.addObject("smtp", smtp.get("smtp"));
        modelAndView.addObject("prot", smtp.get("prot"));
        modelAndView.setViewName("admin/email");
        return modelAndView;
    }

    @RequestMapping("/file")
    public ModelAndView file(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/file");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/setEmail")
    public int setEmail(String email, String name, String password, String smtp, int prot) {
        TSmtp tSmtp = new TSmtp();
        tSmtp.setEmail(email);
        tSmtp.setName(name);
        tSmtp.setProt(prot);
        tSmtp.setSmtp(smtp);

        try {
            tSmtp.setPassword(aesEncrypt(password, KEY));
        } catch (Exception e) {
            e.printStackTrace();
        }
//

        try {
            if (tSmtpService.updateSmtp(tSmtp) > 0) {
                Email.setiEmail(email);
                Email.setHostName(smtp);
                Email.setName(name);
                Email.setUserName(email);
                Email.setPassword(password);
                Email.setPort(prot);
                return 0;
            }
        } catch (Exception e) {
            return 1;
        }
        return 1;
    }

    @ResponseBody
    @RequestMapping("/setUser")
    public int setUser(HttpSession session, @RequestParam(value = "email", defaultValue = "") String email, @RequestParam(value = "remarks", defaultValue = "") String remarks) {
        if (!"".equals(email) || !"".equals(remarks)) {
            TAdmin tAdmin = new TAdmin();
            tAdmin.setbAdminName(session.getAttribute("userName").toString());
            if (!"".equals(email)) {
                tAdmin.setbAdminEmail(email);
            }
            if (!"".equals(remarks)) {
                tAdmin.setbAdminRemarks(remarks);
            }
            System.err.println(tAdmin.toString());
            tAdminService.updateAdmin(tAdmin);
            Email.sendEmail(tAdminService.findAdminOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_admin_email").toString(), "提示", Email.hint("账号信息修改成功"));
        } else {
            return 0;
        }

        return 1;
    }

    /**
     * @param session 获取邮箱验证码
     */
    @ResponseBody
    @RequestMapping("/getAuthCode")
    public void getAuthCode(HttpSession session) {
        String authCode = RandomUtil.generateString(5) + String.valueOf(System.currentTimeMillis()).substring(8);
        if (Email.sendEmail(tAdminService.findAdminOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_admin_email").toString(), "验证码", Email.text("修改密码", authCode))) {
            session.setAttribute("authCode", authCode);
            System.err.println(session.getAttribute("authCode"));
        }
    }


    @ResponseBody
    @RequestMapping("/registerGetAuthCode")
    public void registerGetAuthCode(HttpServletRequest request, HttpSession session) {
        String email = request.getParameter("email");
        System.out.println("1+++++++++++++++" + email);

        Map<String, Object> smtp = tSmtpService.selectSmtp();
//
        Email.setiEmail(smtp.get("email").toString());
        Email.setHostName(smtp.get("smtp").toString());
        Email.setName(smtp.get("name").toString());
        Email.setUserName(smtp.get("email").toString());
        Email.setPassword(aesDecrypt(smtp.get("password").toString()));
        Email.setPort(Integer.parseInt(smtp.get("prot").toString()));
//
        String registerAuthCode = RandomUtil.generateString(5) + String.valueOf(System.currentTimeMillis()).substring(8);
        System.out.println("123+++++++++" + registerAuthCode);
        if (Email.sendEmail(email, "验证码", Email.text("注册帐户", registerAuthCode))) {
            session.setAttribute("registerAuthCode", registerAuthCode);
            System.err.println(session.getAttribute("registerAuthCode"));
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
                if (session.getAttribute("authCode").equals(authCode)) {
                    if (oldPassword.equals(tAdminService.findAdminOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_admin_password"))) {
                        TAdmin tAdmin = new TAdmin();
                        tAdmin.setbAdminName(String.valueOf(session.getAttribute("userName")));
                        tAdmin.setbAdminPassword(repassword);
                        tAdminService.updateAdmin(tAdmin);
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
        System.err.println(Email.getPassword());
        Email.sendEmail(tAdminService.findAdminOne(String.valueOf(session.getAttribute("userName"))).get(0).get("b_admin_email").toString(), "提示", Email.hint("密码修改成功"));
        return 0;//修改成功
    }

    @RequestMapping("/pswDemo")
    public String pswDemo(){
        return "admin/encryption";
    }
@RequestMapping("encryption")
@ResponseBody
    public String   encryption(String text1){
    AES aes = new AES();
    String encryptionText1= aes.aesEncrypt(text1);
    System.out.println("加密的数据："+encryptionText1);
  /*  System.out.println("加密的数据："+encryptionText1);
    ModelAndView modelAndView =new ModelAndView();
    modelAndView.addObject(encryptionText1);
    modelAndView.setViewName("admin/encryption");*/
    return  encryptionText1;
}

    @RequestMapping("decrypt")
    @ResponseBody
    public String  decrypt(String text2){
        AES aes = new AES();
        String decryptText2= aes.aesDecrypt(text2);
        System.out.println("解密的数据："+decryptText2);
    /*ModelAndView modelAndView =new ModelAndView();
    modelAndView.addObject(encryptionText1);
    modelAndView.setViewName("admin/encryption");*/
        return  decryptText2;

    }
}