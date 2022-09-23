package com.demobeans;

public class Registration {
private int empId;
private String empName;
private String empmail;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpmail() {
	return empmail;
}
public void setEmpmail(String empmail) {
	this.empmail = empmail;
}
public Registration(int empId, String empName, String empmail) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empmail = empmail;
}
public Registration() {
	super();
	// TODO Auto-generated constructor stub
}
//@Override
public String toString() {
	return "Registration [empId=" + empId + ", empName=" + empName + ", empmail=" + empmail + "]";
}

}
