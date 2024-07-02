package com.teju.microservices.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teju.microservices.hrservice.models.Employee;
import com.teju.microservices.hrservice.models.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResource {
	
	List<Employee> employees = Arrays.asList(
			new Employee("E101","Darshana","Bairagi","Surgery"),
			new Employee("E102","Tejashree","Gawade","Meditech"),
			new Employee("E103","Yamini","Khairnar","Dentistry")
			);

	
	@RequestMapping("/employees")
	public EmployeesList  getEmployees(){
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employees);
		
		return employeesList;
	}
	
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById(@PathVariable("Id") String Id) {
		Employee employeeId = employees.stream()
							  .filter(employee -> Id.equals(employee.getId()))
							  .findAny()
							  .orElse(null);
		return employeeId;
	}

}
























