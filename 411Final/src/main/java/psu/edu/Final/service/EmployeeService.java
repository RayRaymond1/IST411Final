package psu.edu.Final.service;

import java.util.List;

import psu.edu.Final.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
	
	Employee updateEmployee(Employee theEmployee);

}
