package com.cj.missyou.exception;

/**
 * @Date 2023/7/29 21:14
 * @Author cc
 */
public class ForbiddenException extends HttpException{
    public ForbiddenException(Integer code) {
        this.code = code;
        this.httpStatusCode = 403;
    }
}
