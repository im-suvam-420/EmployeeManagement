package com.api.employee.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String empId;
	private String empName;
	private String empMobileNumber;
	private String empAddress;
	public Employee(Long id, String empId, String empName, String empMobileNumber, String empAddress) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.empMobileNumber = empMobileNumber;
		this.empAddress = empAddress;
	}
	public Employee() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMobileNumber() {
		return empMobileNumber;
	}
	public void setEmpMobileNumber(String empMobileNumber) {
		this.empMobileNumber = empMobileNumber;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

}
