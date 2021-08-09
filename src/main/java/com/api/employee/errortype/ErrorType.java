package com.api.employee.errortype;

public class ErrorType {

	private String messsge;
	private String code;
	private String error;
	private String classType;
	
	public ErrorType(String messsge, String code, String error, String classType) {
		super();
		this.messsge = messsge;
		this.code = code;
		this.error = error;
		this.classType = classType;
	}
	public ErrorType() {
		super();
	}
	public String getMesssge() {
		return messsge;
	}
	public void setMesssge(String messsge) {
		this.messsge = messsge;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}

}
