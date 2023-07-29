package com.cj.missyou.exception;

/**
 * @Date 2023/7/29 21:12
 * @Author cc
 */
public class NotFoundException extends HttpException{
    public NotFoundException(Integer code) {
        this.code = code;
        this.httpStatusCode = 404;
    }
}
