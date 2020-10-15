package com.smny.dksongweb.interceptor;

import com.smny.dksongweb.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname LoginInterceptor
 * @Description 登陆拦截
 * @Date 2019/8/28 9:19
 * @Created by yuan jing
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("request.getRequestURI()" + request.getRequestURI());
//
//
//        String token = request.getHeader("token");
//        log.info("token is {}", token);
//
//
//        //如果用户token为空
//
//        if (null == token ||  token.equals("")) {
//            log.info("token is null");
//            response.sendError(CodeEnum.CODE_TOKEN.getCode(), CodeEnum.CODE_TOKEN.getMessage());
//            return false;
//        }
//
//
//        if (!redisUtil.hasKey(token)) {
//            response.sendError(CodeEnum.CODE_TOKEN.getCode(), CodeEnum.CODE_TOKEN.getMessage());
//            return false;
//        }

//        log.info("redis  token is {}",redisUtil.get(token));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
