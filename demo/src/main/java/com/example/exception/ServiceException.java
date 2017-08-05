package com.example.exception;

/**
 * Created by hhb on 2017/8/
 * 自定义service异常
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}
