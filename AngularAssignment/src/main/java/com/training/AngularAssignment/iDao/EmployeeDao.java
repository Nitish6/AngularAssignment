package com.training.AngularAssignment.iDao;

import java.util.List;

import com.training.AngularAssignment.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Integer customerId);
}
