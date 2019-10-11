package com.songbo.mybatisplus.controller;

import com.songbo.mybatisplus.dao.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author songbo
 * @Date 19-9-23 下午8:34
 **/
public class Test {

    public static void main(String[] args) {
        String s = "2,4,9,9,4";
        String[] strings = s.split(",");
        System.out.println(strings[0]);
        int len = strings.length;
        int j = len-1;
        for (int i=0; i<len; i++){
            if (Integer.parseInt(strings[j])==9){
                strings[j] = String.valueOf(0);
                j--;
            }else{
                strings[j] = String.valueOf(Integer.parseInt(strings[j])+1);
                break;
            }
        }
        for (int i=0;i<len;i++){
            if (i==len-1){
                System.out.println(strings[i]);
            }else {
                System.out.print(strings[i]+',');
            }

        }

    }
}
