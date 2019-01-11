package com.yz.controller;

import com.yz.exception.AppException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(AppException.class)
//    public Map<String,String> handleAppException(Exception e){
//        Map<String,String> res = new HashMap<>();
//        res.put("msg",e.getMessage());
//        res.put("time",new Date().toString());
//        return res;
//    }


    @ExceptionHandler(AppException.class)
    public String handleAppException(Exception e, HttpServletRequest request){
        Map<String,String> res = new HashMap<>();
        res.put("msg",e.getMessage());
        res.put("time",new Date().toString());
        request.setAttribute("javax.servlet.error.status_code",500);
        request.setAttribute("res",res);
        return "forward:/error";
    }

}
