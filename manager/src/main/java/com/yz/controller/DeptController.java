package com.yz.controller;

import com.yz.exception.AppException;
import com.yz.model.Department;
import com.yz.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    IDepartmentService departmentService;

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @PostMapping("/add")
    public String add(Department department, HttpServletRequest request){
        try{
            departmentService.add(department);
            List<Department> departments = departmentService.getAll();
            if(!CollectionUtils.isEmpty(departments)){
                request.getSession().setAttribute("departments",departments);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DeptController-add"+e);
        }
        return "redirect:/main";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id, HttpServletRequest request){
        try{
            if(!StringUtils.isEmpty(id)){
                this.departmentService.del(id);
                List<Department> departments = departmentService.getAll();
                request.getSession().setAttribute("departments",departments);
            }else{
                throw new AppException("id 获取失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error("DeptController-del"+e);
        }
        return "redirect:/main";
    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, HttpServletRequest request){
        try{
            if(!StringUtils.isEmpty(id)){
                Department department = this.departmentService.get(id);
                request.getSession().setAttribute("department",department);
                return "update";
            }else{
                throw new AppException("id 获取失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error("DeptController-toUpdate"+e);
        }
        return "update";
    }


    @PostMapping("/update")
    public String update(Department department, HttpServletRequest request){
        try{
            departmentService.update(department);
            List<Department> departments = departmentService.getAll();
            if(!CollectionUtils.isEmpty(departments)){
                request.getSession().setAttribute("departments",departments);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("DeptController-update"+e);
        }
        return "redirect:/main";
    }

}
