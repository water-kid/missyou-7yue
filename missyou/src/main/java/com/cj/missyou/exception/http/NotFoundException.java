package com.cj.missyou.exception.http;

/**
 * 没有找到资源
 */
public class NotFoundException extends HttpException {

    public NotFoundException(int code) {
        this.httpStatusCode = 404;
        this.code = code;
    }
}
