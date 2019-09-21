package com.example.cache.enums;

import lombok.Getter;

//already test
@Getter
public enum LikeEnum {
    LIKE(1, "点赞"),
    UNLIKE(0, "取消点赞/未点赞");

    private Integer code;

    private String msg;

    LikeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}


