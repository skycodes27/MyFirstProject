package service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.EmployeeDAO;
import exception.EmployeeAdminSystemException;
import model.Employee;
import util.ApplicationUtil;

public class EmployeeAdminService {
	public List<Employee> buildEmployeeList(List<String> records) throws EmployeeAdminSystemException, ParseException, IOException  {
		final String COMMADELIMITER = ",";
		
		List<Employee> li = new ArrayList<>();
		double currentSalary = 0.0;
		
		for(String l1 : records)
		{
			String a[] = l1.split(COMMADELIMITER);
			
			Employee e=new Employee();
			e.setEmpId(a[0]);
			e.setEmpName(a[1]);
			e.setDesignation(a[2]);
			e.setEmpType(a[3]);
			
			double sal = Double.parseDouble(a[4]);
			currentSalary = getSalary(a[3],a[2],sal);
			
			
			e.setSalary(currentSalary);
			e.setDob(ApplicationUtil.stringToDateConverter(a[5]));
			
			li.add(e);
		}
		return li;
				
	}
	public boolean hikeSalary(String empType,String designation) throws EmployeeAdminSystemException, IOException, ParseException, ClassNotFoundException, SQLException {
 	
		
		// TYPE YOUR CODE HERE
		List<Employee> li = new ArrayList<>();
		List<String> record = new ArrayList<>();
		ApplicationUtil applicationUtil = new ApplicationUtil();
		record = ApplicationUtil.readFile("C:\\Users\\Akash Kumar Singh\\eclipse-workspace\\EAS\\src\\Inputfeed.txt");
		
		li= buildEmployeeList(record);
		
		if(li==null)
			return false;
		
		EmployeeDAO empDao = new EmployeeDAO();
		boolean add = empDao.addEmployeeDetails(li);
		
		return true;
		 
	}
	public double getSalary(String emptype,String desig, double currentSalary) {
		
		if(emptype=="F"&& desig.equalsIgnoreCase("clerk"))
		{
			currentSalary=1.07*currentSalary;
		}
		else if(emptype=="F" && desig.equalsIgnoreCase("manager"))
		{
			currentSalary = 1.1*currentSalary;
		}
		else if(emptype=="C" && desig.equalsIgnoreCase("clerk"))
		{
			currentSalary = 1.03*currentSalary;
		}
		else if(emptype=="C" && desig.equalsIgnoreCase("manager"))
		{
			currentSalary = 1.05*currentSalary;
		}
		
		
		return currentSalary;
	}

}
