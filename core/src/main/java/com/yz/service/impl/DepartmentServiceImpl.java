package com.yz.service.impl;

import com.yz.dao.IDeptDao;
import com.yz.exception.AppException;
import com.yz.model.Department;
import com.yz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDeptDao deptDao;

    @Override
    public List<Department> getAll() throws AppException {
        return deptDao==null?null:deptDao.getDepartments();
    }

    @Override
    public void add(Department department) throws AppException {
        deptDao.save(department);
    }

    @Override
    public void del(Integer id) throws AppException {
        deptDao.delete(id);
    }

    @Override
    public Department get(Integer id) throws AppException {
        return deptDao==null?null:deptDao.getDepartment(id);
    }

    @Override
    public void update(Department department) throws AppException {
        deptDao.update(department);
    }
}
