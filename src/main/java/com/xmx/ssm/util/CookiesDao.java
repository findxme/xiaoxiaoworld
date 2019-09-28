package com.xmx.ssm.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CookiesDao {
    public static void LoginIn(String username, HttpServletResponse response){
        Cookie cookie = new Cookie("user",username);
        response.addCookie(cookie);
    }

    public static boolean isLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("user".equals(cookie.getName())){
                if(cookie.getValue()!=null){
                    return true;
                }
            }
        }
        return false;
    }

    public static void LoginOut(HttpServletRequest request, HttpServletResponse response){
        if(isLogin(request)){
            Cookie cookie = new Cookie("user",null);
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }
    }
}
