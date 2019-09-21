package com.bobo.jwt.bean;

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
    private JSONObject jsonObject;

    public ResultJson(){}

    public ResultJson(int code, String msg, JSONObject jsonObject) {
        this.code = code;
        this.msg = msg;
        this.jsonObject = jsonObject;
    }

    public static ResultJson resultJsonForLogin(String msg, JSONObject jsonObject){
        return new ResultJson(200,msg,jsonObject);
    }
}
