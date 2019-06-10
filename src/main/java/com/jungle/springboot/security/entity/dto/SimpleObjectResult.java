package com.jungle.springboot.security.entity.dto;

/**
 * @author jungle
 * @version V1.0
 * @date 2018/11/29 16:04
 * @Title: SimpleObjectResult.java
 * @Package com.holmes.titanium.entity.dto
 * @Description: 带Object的响应结果。
 * copyright © 2018- holmes.com
 */
public class SimpleObjectResult extends SimpleResult {

    private Object data;

    public SimpleObjectResult() {

    }

    public SimpleObjectResult(String code, String message, Object data) {

        super(code, message);
        this.data = data;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {

        this.data = data;
    }
}
