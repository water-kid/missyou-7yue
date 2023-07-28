package com.cj.missyou.exception.http;

/**
 * HttpException 多了两个扩展字段，，   code 和 http状态码
 */
public class HttpException extends RuntimeException{
    /**
     * 自定义状态码
     */
    protected Integer code;
    /**
     * http状态码
     */
    protected Integer httpStatusCode =500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
