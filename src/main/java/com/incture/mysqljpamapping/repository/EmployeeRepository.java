package com.incture.mysqljpamapping.repository;

import java.util.List;

import com.incture.mysqljpamapping.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByDepartment(String department);

}
