package com.cj.missyou.core;

/**
 * @Date 2023/7/27 18:12
 * @Author cc
 */
public class UnifyResponse {
    private int code;
    private String message;
    /**
     * 请求路径
     */
    private String request;

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }


    /**
     * 序列化需要获取，，字段是private的
     */
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequest() {
        return request;
    }
}
