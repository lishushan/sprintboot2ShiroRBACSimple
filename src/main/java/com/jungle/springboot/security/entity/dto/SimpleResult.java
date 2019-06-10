package com.jungle.springboot.security.entity.dto;

/**
 * @author : jungle
 * @Title : SimpleResult
 * @Package :
 * @Description: 最基础结果.
 */
public class SimpleResult {

    /**
     * 响应码。
     */
    private String code;

    /**
     * 响应消息。
     */
    private String message;

    public SimpleResult() {

    }

    public SimpleResult(String code) {

        this.code = code;
    }

    public SimpleResult(String code, String message) {

        this.code = code;
        this.message = message;
    }

    /**
     * 获取code。
     * return {@link #code}
     */
    public String getCode() {

        return code;
    }

    /**
     * 设置code。
     *
     * @param code {@link #code}
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * 获取message。
     * return {@link #message}
     */
    public String getMessage() {

        return message;
    }

    /**
     * 设置message。
     *
     * @param message {@link #message}
     */
    public void setMessage(String message) {

        this.message = message;
    }
}
