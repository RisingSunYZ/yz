package com.yz;

import com.yz.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerApplicationTests {

	@Autowired
	private IDepartmentService departmentService;

	@Test
	public void contextLoads() {
		System.out.println(departmentService.getAll());
	}

}

