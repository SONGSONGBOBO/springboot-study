package com.bobo.shiro.bean;

import lombok.Data;

/**
 * @ClassName Result
 * @Description TODO
 * @Author songbo
 * @Date 19-5-3 下午7:17
 **/
@Data
public class Result {

    private int code;
    private String msg;

    public Result(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Result ok(){

        return new Result(0,"ok");
    }

    public static Result error(String error){
        return new Result(1,error);
    }

}
