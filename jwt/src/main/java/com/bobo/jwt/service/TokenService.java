package com.bobo.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bobo.jwt.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getUserId()))// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getUserPwd()));// 以 password 作为 token 的密钥
        return token;
    }
    public String getTokenForUser(String username, String userpwd) {
        String token="";
        token= JWT.create().withAudience(username)// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(userpwd));// 以 password 作为 token 的密钥
        return token;
    }
}
