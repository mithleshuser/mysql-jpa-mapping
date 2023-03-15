package com.incture.mysqljpamapping.service;

import com.incture.mysqljpamapping.Entity.Employee;

import java.util.List;


public interface EmployeeService {
	List<Employee> findByDepartment(String department);

}
