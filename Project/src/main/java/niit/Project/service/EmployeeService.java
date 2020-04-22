package niit.Project.service;

import java.util.List;

import niit.Project.model.EmployeeDetails;

public interface EmployeeService {
	public List<EmployeeDetails> getEmployeeDetailsList();
	public EmployeeDetails getEmployeeDetails(int empId);
	public boolean addEmployeeDetails(EmployeeDetails emp);
	public boolean updateEmployeeDetails(EmployeeDetails emp);
	public boolean deleteEmployeeDetails(int empId);
	
	public EmployeeDetails findById(int empId);
}
