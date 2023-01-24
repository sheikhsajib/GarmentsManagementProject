package com.garmentsmanagement.GM;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import com.garmentsmanagement.GM.repository.clientRepository.ICOrderRepository;
import com.garmentsmanagement.GM.service.employeeService.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GarmentsManagementApplicationTests {

	@Autowired
    EmployeeService employeeService;

	@Test
	void contextLoads() {
		List<Employees> lists = employeeService.findAllEms();

			System.out.println(lists);


	}
	@Autowired
	ICOrderRepository orderCount;

	@Test
	void countOrder(){
		String orCount = orderCount.findClientAllOrder(1);

		System.out.println(orCount);
	}

	@Test
	void x(){

		System.out.println(employeeService.findStartData("Dept 2-2023-Grade-14-1003"));

//		System.out.println(hrService.findEmpByEmid("Dept 2-2023-Grade-14-1003"));
//		StartAttend at = new StartAttend();

//		hrService.saveAttend(new StartAttend("Dept 2-2023-Grade-14-1003"));
	}

	@Test
	void generateText(){
		System.out.println();

	}

}
