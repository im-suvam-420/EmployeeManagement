package com.api.employee.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.api.employee.entities.Employee;
import com.api.employee.response.EmployeeResponse;

import net.sf.jasperreports.engine.JRException;

public interface EmployeeService {

	public List<Employee> getEmployee();

	public Employee getEmployeeById(Long id);

	public EmployeeResponse addEmployee(Employee employee);

	public String exportReport(String format) throws FileNotFoundException, JRException;

}
