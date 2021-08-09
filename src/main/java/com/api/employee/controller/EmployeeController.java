package com.api.employee.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.employee.entities.Employee;
import com.api.employee.response.EmployeeResponse;
import com.api.employee.service.EmployeeService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/emp")
	public List<Employee>getEmployee(){
		return employeeService.getEmployee();
	}

	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")Long id){
		return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	@PostMapping("/emp")
	public ResponseEntity<EmployeeResponse>addEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/export/{format}")
	public String ecxportReport(@PathVariable String format) throws FileNotFoundException, JRException{
		return employeeService.exportReport(format);
	}
}
