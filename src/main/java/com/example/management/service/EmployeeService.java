package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.management.model.Employee;
import com.example.management.repository.EmployeeRepository;

 //@service annotation is having metadata of source code
@Service
public class EmployeeService {

	//	//Autowired annotation is used to creating object and in short this bean will be auto wired with EmployeeRepository bean
	@Autowired
	private EmployeeRepository employeeRepository;
	

	public List<Employee> getALLEmployees() {

		return this.employeeRepository.findAll(); //findAll method used find the all data
	}
	
     
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);//save methode used to save the records in database.
	}
  
	//
	public Employee updateEmployee(int id,Employee employee) {

		if (this.employeeRepository.existsById(id)) {
			this.employeeRepository.save(employee);
			return employee;
		} else {
			
			return employee;
		}
	}

	public Employee getEmployeeById(int employeeId) {

		if (this.employeeRepository.existsById(employeeId)) {//existById ->we can cheack the id, id is exist or not


			return this.employeeRepository.findById(employeeId).orElse(null);//findById ->we can fetch the particular data from database.
		} else {
			return null;
		}
	}

	public void deleteEmployeeById(int employeeId) {

		if (this.employeeRepository.existsById(employeeId)) { //existById ->we can cheack the id, id is exist or not

			this.employeeRepository.deleteById(employeeId); //deletebyId ->we can delete the particular employeeid 
		}
	}
}