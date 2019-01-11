package com.yz.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yz.api.IYzApi;
import com.yz.exception.AppException;
import com.yz.model.Department;
import com.yz.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class YzApiImpl implements IYzApi{

    Logger logger = LoggerFactory.getLogger(YzApiImpl.class);

    @Autowired
    private IDepartmentService departmentService;
    @Override
    public List<Department> getAllDepartment() {
        List<Department> departmentList = null;
        try{
            departmentList = departmentService.getAll();
            return departmentList;
        }catch (AppException e){
            e.printStackTrace();
            logger.error("YzApiImpl-getAllDepartment"+e);
        }
        return null;
    }
}
