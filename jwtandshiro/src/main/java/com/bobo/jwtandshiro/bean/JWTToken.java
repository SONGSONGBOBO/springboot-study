package com.bobo.jwtandshiro.bean;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;
/**
 * @ClassName JWTToken
 * @Description TODO
 * @Author songbo
 * @Date 19-6-6 下午8:43
 **/

@Data
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

