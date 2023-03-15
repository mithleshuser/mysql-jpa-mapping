package com.incture.mysqljpamapping.service;

import java.util.List;

import com.incture.mysqljpamapping.Entity.Employee;
import com.incture.mysqljpamapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findByDepartment(String department) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDepartment(department);
	}

}
