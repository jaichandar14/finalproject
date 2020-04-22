package com.niit.Backend.Service;

import java.util.List;

import com.niit.Backend.model.Employee;

public interface EmpService {
	public List <Employee> getEmployeeList();
	public Employee getEmployee(int id);
	public boolean addEmployee(Employee employeedetails);
	 public boolean updateEmployee (Employee employeedetails);
	 public boolean deleteEmployee (int id);
	 public Employee FindBYid(int id);

}
