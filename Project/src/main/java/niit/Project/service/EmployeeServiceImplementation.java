package niit.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import niit.Project.dao.Employee;
import niit.Project.model.EmployeeDetails;

@Service
@Repository("empService")
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private Employee empDAO;

	public List<EmployeeDetails> getEmployeeDetailsList() {
		// TODO Auto-generated method stub
		return empDAO.getEmployeeDetailsList();
	}


	public EmployeeDetails getEmployeeDetails(int empId) {
		// TODO Auto-generated method stub
		return empDAO.getEmployeeDetails(empId);
	}

	public boolean addEmployeeDetails(EmployeeDetails emp) {
		// TODO Auto-generated method stub
		System.out.println("in add");
		empDAO.addEmployeeDetails(emp);
		return true;
	}
	public boolean updateEmployeeDetails(EmployeeDetails emp) {
		// TODO Auto-generated method stub
		empDAO.updateEmployeeDetails(emp);
		return true;
	}


	public boolean deleteEmployeeDetails(int empId) {
		// TODO Auto-generated method stub
		System.out.println("service deleteEmployeeDetails");
		System.out.println(empId);
		empDAO.deleteEmployeeDetails(empId);
		return true;
	}

	public EmployeeDetails findById(int empId) {
		// TODO Auto-generated method stub
		return empDAO.getEmployeeDetails(empId);
	}
}
