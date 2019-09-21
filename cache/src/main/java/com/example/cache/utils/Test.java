package com.example.cache.utils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author songbo
 * @Date 19-8-24 下午7:02
 **/
public class Test {
    public static void main(String[] args) {

        //System.out.println(fun());

        /*String s1="";
        String s2 = null;
        String s3 = null;
        System.out.println(s1=="");
        System.out.println(s2.equals(s3));*/

       /* Integer a1 = 101;
        Integer b1 = 101;
        if (a1 == b1){
            System.out.println("e");
        } else {
            System.out.println("n");
        }

        Integer a2 = -101;
        Integer b2 = -101;
        if (a2 == b2){
            System.out.println("e");
        } else {
            System.out.println("n");
        }*/

       /*for (int i=1; i<3; i++){
           if (i==2){
               if (i==2){
                   if (i==2){
                       System.out.println("1 i==2");
                       continue;
                   }
                   System.out.println("2");
               }
               System.out.println("3");
           }
           System.out.println("i="+i);
       }*/

       //System.out.println(Test.fun1());



    }


    public static int fun1(){
        try {

            return 1;
        } catch (Exception e) {
            return 2;
        }finally {
            return 3;
        }
    }


    public static int fun(){
        int i = 10;
        try {
            i = i/0;
            return --i;
        } catch (Exception e){
            --i;
            return i--;
        } finally {
            --i;
            return i--;
        }
    }
}
