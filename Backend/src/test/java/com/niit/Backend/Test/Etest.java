package com.niit.Backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.Service.EmpService;
import com.niit.Backend.model.Employee;

public class Etest {
   static EmpService empService;
	
   @BeforeClass
   public static void initialize() {
	   System.out.println(" intialization");
	   
	   AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
	   System.out.println("bean intialization");
	   context.scan("com.niit.backend");
		  System.out.println("sCAN");
		  empService = (EmpService)context.getBean("empService");
			   
	   System.out.println("Succefully bean initialized");
   }
   //@Ignore
   @Test
   public void addEmployeetest() {
	   Employee employeedetails=new Employee();
	System.out.println("in add");
	   employeedetails.setName("jai");
		employeedetails.setEmail("hai2496@gmail.com");
		employeedetails.setPhoneno("9632587410");
		employeedetails.setDob("9632587410");
		employeedetails.setQualifiction("Eng");
		employeedetails.setDepartment("mech");
		System.out.println("before service");
		empService.addEmployee(employeedetails);
   }
   @Ignore
   @Test
   public void listEmployee() {
	   List<Employee>listemployeedetails = empService.getEmployeeList();
	   assertNotNull("problem in listing Employee",empService.getEmployeeList());
	   for (Employee employeedetails:listemployeedetails)
	   {

			System.out.println(employeedetails.getId()+"||"
			+employeedetails.getName()+"||"+employeedetails.getEmail()+"||"
					+employeedetails.getPhoneno()+"||"+employeedetails.getDob()+"||"
			+employeedetails.getQualifiction()+"||"+employeedetails.getDepartment());
		
	   }  
	   }
   @Ignore
	@Test
	public void updateEmployee() {
		Employee employeedetails = empService.getEmployee(2);
		employeedetails.setName("jaijai");
    assertTrue("problem in listing faculty", empService.updateEmployee(employeedetails));
	}

	@Ignore
	@Test
	public void deleteEmployee() {
		int id=101;
		assertTrue("problem in listing faculty",empService.deleteEmployee(id));
	}

}
   


