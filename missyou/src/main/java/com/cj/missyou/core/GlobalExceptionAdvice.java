package com.cj.missyou.core;

import com.cj.missyou.configuration.ExceptionCodeConfiguration;
import com.cj.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date 2023/7/27 17:24
 * @Author cc
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    /**
     * 处理已知异常 ：  我们自己抛出的异常
     */
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request,HttpException e){
        /**
         * 已知异常的 httpStatus 状态码不同，  在 exception中
         */
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // ResponseEntity
//        new UnifyResponse(httpException.getCode(),"",)

        ResponseEntity<Object> build = ResponseEntity.ok().build();
        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), codeConfiguration.getMessage(e.getCode()), request.getRequestURI());
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<UnifyResponse> hehe = new ResponseEntity<>(unifyResponse, httpStatus);
        return hehe;
    }

    /**
     * 处理未知异常 ：
     *      未知异常是没有code码的，你都不知道是什么异常，统一为9999
     *       未知异常返回的msg可能设置到机密信息，一般不直接返回
     *       返回未知异常信息，给前端，，没有意义，，前端不需要这个未知异常的信息。。
     *       不需要提供详细的message
     *       有意义的提示信息，，已经在已知异常中返回了
     *
     *      未知异常：  服务端开发者的代码逻辑有问题，， 模糊的，非具体的，， 记录日志：保留这个异常信息
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest request,Exception e){
        String uri = request.getRequestURI();

        String method = request.getMethod();
        // 直接提示错误信息
        System.out.println("e = " + e);
        return new UnifyResponse(9999,"服务器异常",method +"  "+ uri);
    }
}
