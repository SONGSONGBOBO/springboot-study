package com.songbo.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName MybatisPlusConfig
 * @Description TODO
 * @Author songbo
 * @Date 19-9-23 下午12:51
 **/
@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = "com.songbo.mybatisplus.dao.mapper")
public class MybatisPlusConfig {

    /**
      *@Description TODO 分页
      *         如果是联表查询，使用leftjoin查询出的条目是最多的
      *@param
      *@return
    **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }
}
