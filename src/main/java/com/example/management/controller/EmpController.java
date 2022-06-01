package com.example.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.model.Employee;
import com.example.management.repository.EmployeeRepository;
import com.example.management.service.EmployeeService;

// below is the annotation used for connecting to angular project.
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmpController {

	//Autowired annotation is used to creating object and in short this bean will be auto wired with service bean
	@Autowired
	private EmployeeService employeeservice;
	
     
	//Post method used insert data into database
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeservice.saveEmployee(employee);

	}
      //Get method used fetch the data from Endpoint /employee
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee() {
		List<Employee> list = this.employeeservice.getALLEmployees();
		System.out.println(list.size());
		if (list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	//Put method used update data into database from Endpoint /employee/{id} 
	@PutMapping("/employee/{id}")
	public Employee UpdateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		
		return this.employeeservice.updateEmployee(id,employee);

	}
	
	//fetch the data from particular id from given Endpoint
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		
		return this.employeeservice.getEmployeeById(employeeId);
	}
	
	//Delete  method used delete data into database
	@DeleteMapping("/employee/{employeeId}")  
	public void deleteEmployeeById(@PathVariable int employeeId)   
	{  
		this.employeeservice.deleteEmployeeById(employeeId); 
	}  
}
