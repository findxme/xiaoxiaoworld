package com.xmx.ssm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class PageLimit {
    /**
     *
     * @param code 解析接口状态
     * @param msg 解析提示文本
     * @param count 解析数据长度
     * @param data 解析数据
     * @return
     */
    public static JSONObject layuiJson(int code, String msg, long count, List data){
        JSONObject json = new JSONObject();
        json.put("code",code);//解析接口状态
        json.put("msg",msg);//解析提示文本
        json.put("count",code);//解析数据长度
        json.put("data",data);//解析数据
        return json;
    }
}
