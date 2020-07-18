package com.example.redis.config;

/**
 * @ClassName FastJsonRedisSerializer
 * @Description TODO 重写了fastjson，但是反序列化不好用，但是使用gen那个fastjson好用
 * @Author songbo
 * @Date 19-8-15 下午6:04
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Class<T> clazz;

    private final static ParserConfig defaultRedisConfig = new ParserConfig();
    static {
        defaultRedisConfig.setAutoTypeSupport(true);
        //fastjson在2017年3月爆出了在1.2.24以及之前版本存在远程代码执行高危安全漏洞。所以要使用ParserConfig.getGlobalInstance().addAccept("com.");指定序列化白名单。
        defaultRedisConfig.addAccept("com.songbo.myblog.");
    }

    public FastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (null == t) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return (T) JSON.parseObject(str, clazz, defaultRedisConfig );
    }
}

