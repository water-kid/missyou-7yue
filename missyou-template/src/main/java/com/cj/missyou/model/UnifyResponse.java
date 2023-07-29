package com.cj.missyou.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Date 2023/7/29 20:44
 * @Author cc
 */
@Getter
@AllArgsConstructor
public class UnifyResponse {
    /**
     * 请求的提示码
     */
    private Integer code;
    /**
     * 请求返回的信息
     */
    private String message;
    /**
     * 请求的路径
     */
    private String url;
}
