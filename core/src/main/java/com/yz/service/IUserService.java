package com.yz.service;

import com.yz.exception.AppException;
import com.yz.model.User;
import org.springframework.stereotype.Service;


public interface IUserService {

    public boolean isLogin(User user) throws AppException;

}
