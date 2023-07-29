package com.cj.missyou.handler;

import com.cj.missyou.core.LoadExceptionCodeProperties;
import com.cj.missyou.exception.HttpException;
import com.cj.missyou.model.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

/**
 * @Date 2023/7/29 20:44
 * @Author cc
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    LoadExceptionCodeProperties exceptionCodeProperties;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handlerMethodArgumentNotValidException(HttpServletRequest request,MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        Optional<String> errorMsg = allErrors.stream().map(ObjectError::getDefaultMessage).reduce((a, b) -> (a + "," + b));
        return new UnifyResponse(10001, errorMsg.orElse(""), request.getMethod() + " " + request.getRequestURI());
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintViolationException(HttpServletRequest request,ConstraintViolationException e){
        return new UnifyResponse(10001, e.getMessage(), request.getMethod() + " " + request.getRequestURI());
    }


    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request, HttpException e){
        // 根据获取的异常的 httpStatusCode 返回  http状态码
        String method = request.getMethod();
        String uri = request.getRequestURI();

        Integer httpStatusCode = e.getHttpStatusCode();
        HttpStatus httpStatus = HttpStatus.resolve(httpStatusCode);
        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), exceptionCodeProperties.getMessage(e.getCode()), method + " " + uri);
        return new ResponseEntity<UnifyResponse>(unifyResponse, httpStatus);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest request,Exception e){
        String method = request.getMethod();
        String uri = request.getRequestURI();
        System.out.println("e = " + e);
        return new UnifyResponse(10001,"服务器错误",method+" "+uri);
    }

}
