package com.training.AngularAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.AngularAssignment.dao.EmployeeDaoImpl;
import com.training.AngularAssignment.iService.EmployeeService;
import com.training.AngularAssignment.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDao;
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	@Override
	public Employee updateCustomer(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
	
	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

}
