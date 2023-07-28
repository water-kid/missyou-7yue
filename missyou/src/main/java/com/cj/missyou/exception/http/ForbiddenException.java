package com.cj.missyou.exception.http;

/**
 * 没有权限
 * 401： 登录没有身份
 */
public class ForbiddenException extends HttpException{
    public ForbiddenException(int code) {
        this.httpStatusCode = 403;
        this.code = code;
    }
}
