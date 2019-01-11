package com.yz.service.impl;

import com.yz.dao.IUserDao;
import com.yz.exception.AppException;
import com.yz.model.User;
import com.yz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean isLogin(User user) throws AppException {
        return userDao == null? false :userDao.getUser(user) == null?false:true;
    }
}
