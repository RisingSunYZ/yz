package com.yz.exception;

public class AppException extends RuntimeException{

    public AppException(String message) {
        super("自定义异常....");
    }

}
