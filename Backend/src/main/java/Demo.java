

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.EmpDao;
import com.niit.Backend.config.DBConfig;

public class Demo {
	 static EmpDao obj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(" intialization");
		   
		   AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		   System.out.println("bean intialization");
		  
		  context.scan("com.niit.backend");
		  System.out.println("sCAN");
		  context.refresh();
		   context.getBean("empDAO");
		   System.out.println("Succefully bean initialized");
	   }
	}


