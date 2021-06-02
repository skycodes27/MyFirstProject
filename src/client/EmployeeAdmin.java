package client;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import exception.EmployeeAdminSystemException;
import service.EmployeeAdminService;

public class EmployeeAdmin {

	public static void main(String[] args) throws ClassNotFoundException, EmployeeAdminSystemException, IOException, ParseException, SQLException {
		// TODO Auto-generated method stub
		
		EmployeeAdminService empService = new EmployeeAdminService();
		
		empService.hikeSalary("F", "clerk");
		

	}

}

