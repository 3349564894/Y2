package com.yq.crm.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局处理异常
 * @date 2023/7/5
 * @Author yq
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView unauthorizedExceptionHandler(HttpServletRequest request, UnauthorizedException e){
        ModelAndView modelAndView = new ModelAndView("403"); //设置跳转路径
        modelAndView.addObject("exception",e); //将异常对象传递过去
        modelAndView.addObject("url",request.getRequestURL()); //获得请求的路径
        return modelAndView;
    }
}
