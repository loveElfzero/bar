package com.mtp.bar.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname InterceptorConfig
 * @Description TODO
 * @Date 2019/8/28 9:21
 * @Created by yuan jing
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
   * @Description: 添加拦截器
   * @Param: 
   * @return: 
   * @Author: YuanJing
   * @Date: 2019/8/28
   */ 
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
               .excludePathPatterns("/doc.html","/webjars/**","/swagger-resources")
               .excludePathPatterns("/user/**","/bartype/**","/bar/all/**","/bar/list","/userPay/*","/orderService/*");

    }
    /**
    * @Description: 添加资源映射
    * @Author: YuanJing
    * @Date: 2019/8/29
    */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     * @Description: 解决跨域
     * @Author: YuanJing
     * @Date: 2019/8/28
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "DELETE","OPTIONS", "PUT")
                .maxAge(3600)
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        List<String> list = new ArrayList<>();
        list.add("*");
        corsConfiguration.setAllowedOrigins(list);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}
