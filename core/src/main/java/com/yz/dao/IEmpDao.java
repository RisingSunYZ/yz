package com.yz.dao;

import com.yz.model.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IEmpDao {

    @Select("select * from emp")
    public List<Employee> getEmployes();


    @Select("select * from emp where id = #{id}")
    public Employee getEmploye(Integer id);


    @Insert("insert into emp(emp_name,emp_email,dept_id) values(#{empName},#{empEmail},#{deptId})")
    public void save(Employee emp);

    @Update("update emp set emp_name = #{empName},emp_email = #{empEmail},dept_id =#{deptId}")
    public void update(Employee emp);

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

}
