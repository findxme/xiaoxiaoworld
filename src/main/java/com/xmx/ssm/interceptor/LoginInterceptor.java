package com.xmx.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // 执行完毕，返回前拦截
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // 在处理过程中，执行拦截
    }

  /*  @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        // 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
        // 返回false则不执行拦截
        HttpSession session = request.getSession();
        //String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的
        //if(session.getAttribute("LOGIN_USER")!=null || uri.indexOf("system/login")!=-1) {// 说明登录成功 或者 执行登录功能
        if(session.getAttribute("userName")!=null||session.getAttribute("adminNo")!=null) {
            // 登录成功不拦截
            return true;
        }else {
            // 拦截后进入登录页面
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
        }
    }*/
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
//
 /*     String url=request.getRequestURI();
      if(url.indexOf("/user/toLogin")>=0) {
          return true;
      }
      *//*
       * if(url.indexOf("/regist.jsp")>=0) { return true; }
       *//*
      if(url.indexOf("user/toRegister")>=0) {
          return true;
      }
      if(url.indexOf(request.getContextPath()+"/static/layuiAdmin/")>=0) {
          return true;
      }
      if(url.indexOf(request.getContextPath()+"/user/isVerifyCode")>=0) {
          return true;
      }
      if(url.indexOf("user/isVerifyCode")>=0) {
          return true;
      }
      if(url.indexOf("user/registerGetAuthCode")>=0) {
          return true;
      }
//      if(url.indexOf("user/verifyCode")>=0) {
////          return true;
////      }
      if(url.indexOf("user/")>=0) {
          return true;
      }
      HttpSession session=request.getSession();
      User user=(User) session.getAttribute("userName");
//      User user2=(User) session.getAttribute("userName");

      if(user!=null) {
          return true;
      }

//      if(url.indexOf("/tologin.action")>=0) {
//          request.getRequestDispatcher("/index").forward(request, response);
//          return false;
//      }


      //request.setAttribute("msg", "你还没有登录，请先登录");
     // request.getRequestDispatcher("/index.jsp").forward(request, response);*/


      return true;
  }
}