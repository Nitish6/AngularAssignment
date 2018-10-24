package com.training.AngularAssignment.iService;

import java.util.List;

import com.training.AngularAssignment.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Employee updateCustomer(Employee employee);
	public void deleteEmployee(Integer employeeId);
}
