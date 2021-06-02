package util;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import exception.EmployeeAdminSystemException;
import model.Employee;


public class ApplicationUtil {
	public static List<String> readFile(String inputfeed) throws EmployeeAdminSystemException, IOException {
		List <String> empList = new ArrayList <String> ();
		
		// TYPE YOUR CODE HERE
		FileReader fr = new FileReader(new File(inputfeed));
		BufferedReader br = new BufferedReader(fr);
		String l;
		while((l=br.readLine())!=null)
		{
			String[] a=l.split(",");
			String empType=a[3];
			try
			{
				if(checkIfFullTimeEmployee(empType))
				{			
					empList.add(l);
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		br.close();
		return empList;


	}
	public static java.util.Date stringToDateConverter(String stringDate) throws ParseException {
		Date date=new SimpleDateFormat(" yyyy-MM-dd.").parse(stringDate);
		return date;
	}
	
	public static boolean checkIfFullTimeEmployee(String empType)
	{
		// Checks if the month of maturityDate and month of currentDate are same
		// Assumption is all NSCs mature on 30th or 31st of any month
		
		// TYPE YOUR CODE HERE
		if(empType=="F")
			return true;
		
		return false;
	}
	
	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
		java.sql.Date sqlDate = null;
		
		// TYPE YOUR CODE HERE
		sqlDate = new java.sql.Date(utDate.getTime());
		
		return sqlDate;
	}
	
	

}
