package com.bobo.jwtandshiro.utils;


import org.springframework.util.DigestUtils;

/**
 * @ClassName MD5
 * @Description TODO
 * @Author songbo
 * @Date 19-6-11 下午9:36
 **/
public class MD5Util {

    public static String getMd5Simple(String password){
        String md502 = DigestUtils.md5DigestAsHex(password.getBytes());
        return md502;
    }
    public static String getMd5(String password){
        /*
         * 原密码加密一次
         * 获取原密码加密后前8位字符
         * 8位字符+加密后的字符串    再加密一次
         */
        String md501= DigestUtils.md5DigestAsHex(password.getBytes());
        StringBuffer reverseMd5 = new StringBuffer(md501+password);
        String md502 = DigestUtils.md5DigestAsHex(reverseMd5.reverse().toString().getBytes());
        /*String temp =md501.substring(0, 8);
        String md502 =DigestUtils.md5DigestAsHex((temp+md501).getBytes());*/
        return md502;
    }

    public static void main(String[] args) {
        String test = MD5Util.getMd5("123");
        System.out.println(test);
    }

}
