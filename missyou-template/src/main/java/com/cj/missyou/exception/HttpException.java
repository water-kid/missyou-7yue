package com.cj.missyou.exception;

import lombok.Getter;

/**
 * @Date 2023/7/29 20:42
 * @Author cc
 */
@Getter
public class HttpException extends Exception{
    protected Integer code;
    protected Integer httpStatusCode;
}
