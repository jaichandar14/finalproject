package niit.middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import niit.Project.model.EmployeeDetails;
import niit.Project.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/emp")

public class EmpController {
  
	@Autowired
	private EmployeeService empService;

	@GetMapping
	public List<EmployeeDetails> listALLEmployeeDetails()
	{
		List<EmployeeDetails> emp = empService.getEmployeeDetailsList();
		return emp;
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployeeDetails(@RequestBody EmployeeDetails emp)
	{

		if(empService.getEmployeeDetails(emp.getEmpId())==null)
		{
			empService.addEmployeeDetails(emp);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}

@PutMapping

public ResponseEntity<Void> updateEmployeeDetails(@RequestBody EmployeeDetails emp)
{
	if(empService.getEmployeeDetails(emp.getEmpId())!=null)
	{
		empService.updateEmployeeDetails(emp);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
@DeleteMapping
public ResponseEntity<Void> deleteEmployeeDetails(@RequestBody EmployeeDetails emp)
{
	if(empService.getEmployeeDetails(emp.getEmpId())!=null)
	{
		empService.deleteEmployeeDetails(0);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}

@GetMapping("/{EmpId}")
public ResponseEntity<EmployeeDetails> getById(@PathVariable("EmpId") int EmpId)
{
	EmployeeDetails emp = null;
	return new ResponseEntity<EmployeeDetails>(empService.getEmployeeDetails(EmpId),HttpStatus.OK);
}

}
