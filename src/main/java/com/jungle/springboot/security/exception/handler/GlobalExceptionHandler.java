package com.jungle.springboot.security.exception.handler;

import com.jungle.springboot.security.entity.dto.SimpleObjectResult;
import com.jungle.springboot.security.exception.BusinessException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jungle
 * @version V1.0
 * @date 2019/6/10
 * 描述：全局异常处理器
 * copyright © 2019- .com
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 日志。
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 全局错误处理.
     *
     * @return Object
     */
    @ExceptionHandler(Exception.class)
    public Object handleException(HttpServletRequest request, Exception e) {

        LOGGER.warn("[全局异常处理][未处理异常][url=>{}]", request.getRequestURL());
        LOGGER.warn("[全局异常处理][未处理异常]错误详情：", e);
        return "/error/500";
    }

    /**
     * 未授权访问错误处理。
     *
     * @param request 请求
     * @param e       授权异常
     *
     * @return Object
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Object handleUnauthorizedException(HttpServletRequest request, UnauthorizedException e) {

        LOGGER.warn("[全局异常处理][未授权访问][url=>{},permission_require_message=>{},aop_method_message=>{}]"
                , request.getRequestURI(),e.getMessage(),e.getCause().getMessage());
        return "/error/403";
    }

    /**
     * 业务异常信息处理.
     *
     * @return Object
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Object handleBusinessException(BusinessException e) {

        return new SimpleObjectResult(e.getCode(), e.getMessage(), e.getData());
    }
}
