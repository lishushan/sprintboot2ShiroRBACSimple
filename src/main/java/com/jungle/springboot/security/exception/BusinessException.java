package com.jungle.springboot.security.exception;

/**
 * @author jungle
 * @version V1.0
 * @date 2019/6/10
 * 描述：业务异常
 * copyright © 2019- .com
 */
public class BusinessException extends RuntimeException {


    public BusinessException() {

    }

    public BusinessException(String code) {

        this.code = code;
    }

    public BusinessException(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public BusinessException(String code, String message, Object data) {

        this.code = code;
        this.message = message;
        this.data = data;
    }

    private String code;

    private Object data;

    private String message;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {

        this.data = data;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
