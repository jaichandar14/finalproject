package com.niit.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.DAO.EmpDao;
import com.niit.Backend.model.Employee;
@Service
@Component("empService")
@Transactional
public class EmpServiceClass implements EmpService {
	@Autowired
	private EmpDao empdao;

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return empdao.getEmployeeList();
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empdao.getEmployee(id);
	}

	@Override
	public boolean addEmployee(Employee employeedetails) {
		// TODO Auto-generated method stub
		empdao.addEmployee(employeedetails);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employeedetails) {
		// TODO Auto-generated method stub
		empdao.updateEmployee(employeedetails);
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empdao.deleteEmployee(id);
		return true;
	}

	@Override
	public Employee FindBYid(int id) {
		// TODO Auto-generated method stub
		return empdao.FindBYid(id);
		 
	}

	

}
