package com.niit.Backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.model.Employee;
@Component("empdao")
@Transactional
public class EmpDaoClass implements EmpDao {

@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where id"+id).uniqueResult();
	}

	@Override
	public boolean addEmployee(Employee employeedetails) {
		// TODO Auto-generated method stub
		try
	     {
	    	System.out.println("in Dao"); 
			sessionFactory.getCurrentSession().save(employeedetails);
	    	 
	    	 return true;
	}
	     catch(Exception e) {
	    	 return false;
	     }


	}

	@Override
	public boolean updateEmployee(Employee employeedetails) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(employeedetails);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("inside dao deleteEmployee");
			sessionFactory.getCurrentSession().delete(FindBYid(id));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Employee FindBYid(int id) {
		// TODO Auto-generated method stub
		return(Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where id="+id).uniqueResult();
	}
	}


