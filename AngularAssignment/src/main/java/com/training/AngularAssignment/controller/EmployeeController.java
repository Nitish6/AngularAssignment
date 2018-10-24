package com.training.AngularAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.AngularAssignment.model.Employee;
import com.training.AngularAssignment.service.EmployeeServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping(value = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		System.out.println("controller called");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");

		return (new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), headers, HttpStatus.OK));
	}

	@PutMapping(value = "/employee")
	public Employee updateCustomer(@RequestBody Employee employee) {
		return employeeService.updateCustomer(employee);
	}

	@DeleteMapping(value = "/employee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Integer employeeId){
		employeeService.deleteEmployee(employeeId);
	}
}
