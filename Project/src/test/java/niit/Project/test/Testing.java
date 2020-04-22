package niit.Project.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.Project.config.DBconfig;
import niit.Project.model.EmployeeDetails;
import niit.Project.service.EmployeeService;

public class Testing {

	static EmployeeService empService;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("Successfully bean initiated");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("niit.Project");
		context.refresh();
		System.out.println("Bean Initialization");
		empService = (EmployeeService) context.getBean("empService");
		System.out.println("Successfully bean initiated");
	}
	
	@Ignore
	@Test
	public void addEmployeeDetailstest() {
		EmployeeDetails emp=new EmployeeDetails();
		System.out.println("in");
		emp.setEmpId(1);
		emp.setName("jayai");
		emp.setEmail("jaichandar14@gmail.com");
		emp.setPhone("8870203141");
		emp.setDesignation("production");
		emp.setSalary("55000");
		System.out.println("before");
		
		empService.addEmployeeDetails( emp);
		System.out.println("Inside test");
	}
	
	@Ignore
	@Test
	public void listEmployeeDetails() {
		List<EmployeeDetails> listemp=empService.getEmployeeDetailsList();
		assertNotNull("problem in listing faculty:",empService.getEmployeeDetailsList());
		for(EmployeeDetails emp:listemp)
		{
			System.out.println(emp.getEmpId()+"||"+emp.getName()+"||"+emp.getEmail()+"||"+emp.getPhone()+"||"+emp.getDesignation()+"||"+emp.getSalary());
			
		}
	}
	
	//@Ignore
	@Test
	public void updateEmployeeDetails() {
		System.out.println("inside update method");
		EmployeeDetails emp;
		System.out.println(" method");
		emp=empService.getEmployeeDetails(1);
	   System.out.println("after get");
		emp.setName("jaya");
	
		System.out.println("after update method");
		 
		assertTrue("problem in updating faculty:",empService.updateEmployeeDetails(emp));
		
	}
	
	@Ignore
	@Test
	public void deleteEmployeeDetails() {
		//EmployeeDetails emp=empService.getEmployeeDetails(2);
		int empId=2;
		assertTrue("problem in deleting faculty:",empService.deleteEmployeeDetails(empId));
	}

}