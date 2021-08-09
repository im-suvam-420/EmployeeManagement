package com.api.employee.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.api.employee.constant.EmployeeConstant;
import com.api.employee.entities.Employee;
import com.api.employee.exception.EmployeeNotFoundException;
import com.api.employee.repository.EmployeeRepository;
import com.api.employee.response.EmployeeResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
		
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee>employeeList=employeeRepository.findById(id);
		if(employeeList.isPresent()) {
			return employeeList.get();
		}else {
			throw new EmployeeNotFoundException("Employee Not Exist "+ id);
		}
	}

	@Override
	public EmployeeResponse addEmployee(Employee employee) {
		EmployeeResponse employeeResponse=new EmployeeResponse();
		Long id=employee.getId();
		if(null==id || null!=getEmployeeById(id)) {
			employeeRepository.save(employee);
		}else {
			throw new EmployeeNotFoundException("Employee Not Exist " + id);
		}
		employeeResponse.setId(employee.getId());
		employeeResponse.setEmpId(employee.getEmpId());
		employeeResponse.setResult(EmployeeConstant.EMPLOYEE_INFO_UPDATED);

		return employeeResponse;
	}


	public String exportReport(String format) throws FileNotFoundException, JRException {
		List<Employee> emplList=getEmployee();
		String path="E://JasperReports//";
		File file=ResourceUtils.getFile("classpath:Employee.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds=new JRBeanCollectionDataSource(emplList);
		Map<String, Object> parameters=new HashMap<String, Object>();
		parameters.put("Employee", "Details");
		
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,ds);

		if(format.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"//emp.html");
		}
		if(format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,path+"//emp.pdf");
		}
		if(format.equalsIgnoreCase("xml")) {
			JasperExportManager.exportReportToXmlFile(jasperPrint,path+"//emp.xml",false);
		}
		
		JRXlsExporter exporter=new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, path);
		exporter.exportReport();
		
		return "path : "+ path;
	}
	
}
