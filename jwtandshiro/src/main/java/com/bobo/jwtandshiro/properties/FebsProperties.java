package com.bobo.jwtandshiro.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FebsProperties
 * @Description TODO
 * @Author songbo
 * @Date 19-6-6 下午8:32
 **/
@Data
@Configuration
//@ConfigurationProperties(prefix = "febs")
public class FebsProperties {

    private ShiroProperties shiro = new ShiroProperties();

    private boolean openAopLog = true;

}
