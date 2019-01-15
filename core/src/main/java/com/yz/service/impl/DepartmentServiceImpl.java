package com.yz.service.impl;

import com.yz.dao.IDeptDao;
import com.yz.exception.AppException;
import com.yz.model.Department;
import com.yz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "dept")
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDeptDao deptDao;

    @Cacheable(key = "'yz-depatments'")
    @Override
    public List<Department> getAll() throws AppException {
        System.out.println("getAll...........");
        return deptDao==null?null:deptDao.getDepartments();
    }


    @Caching(put = {
            @CachePut(key = "'yz-'+#department.id")
    },evict = {
            @CacheEvict(key = "'yz-depatments'",beforeInvocation = true)
    })
    @Override
    public Department add(Department department) throws AppException {
        deptDao.save(department);
        return department;
    }

    @Caching(evict = {@CacheEvict(key = "'yz-depatments'",beforeInvocation = true),
            @CacheEvict(keyGenerator = "myKeyGenerator",beforeInvocation = true)}
    )
    @Override
    public void del(Integer id) throws AppException {
        deptDao.delete(id);
    }

    @Cacheable(keyGenerator = "myKeyGenerator")
    @Override
    public Department get(Integer id) throws AppException {
        System.out.println("get...........");
        return deptDao==null?null:deptDao.getDepartment(id);
    }

    @Caching(put = @CachePut(key = "'yz-'+#result.id"),
        evict = @CacheEvict(key = "'yz-depatments'",beforeInvocation = true)
    )
    @Override
    public Department update(Department department) throws AppException {
        deptDao.update(department);
        return department;
    }
}
