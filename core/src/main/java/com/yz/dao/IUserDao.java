package com.yz.dao;

import com.yz.exception.AppException;
import com.yz.model.User;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {

    @Select("select * from user where user_name = #{userName} and pass_word = #{passWord}")
    public User getUser(User user) throws AppException;
}
