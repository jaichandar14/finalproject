package niit.Project.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.Project.model.EmployeeDetails;

@Repository("empDAO")
@Transactional
public class EmployeeImplementation implements Employee {
	
	@Autowired
	private SessionFactory sessionFactory;
    @Override
	public List<EmployeeDetails> getEmployeeDetailsList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from EmployeeDetails").list();
	}
    @Override
	public EmployeeDetails getEmployeeDetails(int empId) {
		// TODO Auto-generated method stub
		return (EmployeeDetails)sessionFactory.getCurrentSession().createQuery("from EmployeDetails where empId="+empId).uniqueResult();
		
	}
    @Override
	public boolean addEmployeeDetails(EmployeeDetails emp) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(emp);
			return true;	
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
    @Override
	public boolean updateEmployeeDetails(EmployeeDetails emp) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(emp);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
    @Override
	public boolean deleteEmployeeDetails(int empId) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("inside dao deleteEmployeeDetails");
			sessionFactory.getCurrentSession().delete(findById(empId));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
    @Override
	public EmployeeDetails findById(int empId) {
		// TODO Auto-generated method stub
		System.out.println(empId);
		return(EmployeeDetails)sessionFactory.getCurrentSession().createQuery("from EmployeeDetails where empId="+empId).uniqueResult();
		
	}

}
