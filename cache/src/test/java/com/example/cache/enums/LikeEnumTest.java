package com.example.cache.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class LikeEnumTest {

    @Test
    public void test(){
        int code = 1;
        for (LikeEnum likeEnum : LikeEnum.values()){
            if (likeEnum.getCode() == code){
                System.out.println(likeEnum);
                System.out.println(likeEnum.getMsg());
            }
        }



    }

}