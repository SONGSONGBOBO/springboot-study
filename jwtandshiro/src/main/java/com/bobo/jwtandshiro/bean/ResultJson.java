package com.bobo.jwtandshiro.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @ClassName ResultJson
 * @Description TODO result
 * @Author songbo
 * @Date 19-6-6 下午1:21
 **/
@Data
public class ResultJson {

    private int code;
    private String msg;
    private Object jsonObject;

    public ResultJson(){}

    public ResultJson(int code, String msg, Object jsonObject) {
        this.code = code;
        this.msg = msg;
        this.jsonObject = jsonObject;
    }

    public static ResultJson resultJsonForLogin(String msg, Object jsonObject){
        return new ResultJson(200,msg,jsonObject);
    }
}
