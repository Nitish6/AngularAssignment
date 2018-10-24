package com.training.AngularAssignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.training.AngularAssignment.iDao.EmployeeDao;
import com.training.AngularAssignment.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployee() {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Transactional
	@Override
	public Employee updateEmployee(Employee employee) {
		return entityManager.merge(employee);
	}

	@Transactional
	public void deleteEmployee(Integer employeeId) {
		Employee requiredEmployee = entityManager.find(Employee.class, employeeId);
		entityManager.remove(requiredEmployee);
	}
}
