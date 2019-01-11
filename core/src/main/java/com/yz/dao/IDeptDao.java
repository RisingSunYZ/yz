package com.yz.dao;

import com.yz.model.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IDeptDao {

    @Select("select * from dept")
    public List<Department> getDepartments();


    @Select("select * from dept where id = #{id}")
    public Department getDepartment(Integer id);


    @Insert("insert into dept(dept_name) values(#{deptName})")
    public void save(Department dept);

    @Update("update dept set dept_name = #{deptName} where id = #{id}")
    public void update(Department dept);

    @Delete("delete from dept where id = #{id}")
    public void delete(Integer id);

}
