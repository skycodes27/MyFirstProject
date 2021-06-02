package dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import exception.EmployeeAdminSystemException;

public class DBConnectionManager {
	
	private static Connection con = null;
	private static DBConnectionManager instance;
	private static Properties props = new Properties();
	public  DBConnectionManager()  throws EmployeeAdminSystemException, IOException, ClassNotFoundException, SQLException
	{
		try
		{
			FileInputStream fis=null;
		
		fis = new FileInputStream("C:\\Users\\Akash Kumar Singh\\eclipse-workspace\\EAS\\src\\database.properties");
		props.load(fis);
		
		// load the Driver Class
		Class.forName(props.getProperty("DB_DRIVER_CLASS"));

		// create the connection now
        con = DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USERNAME"),props.getProperty("DB_PASSWORD"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TYPE YOUR CODE HERE
		
       //return con;
	}
	public static DBConnectionManager getInstance() throws EmployeeAdminSystemException, ClassNotFoundException, IOException, SQLException {
		
		// TYPE YOUR CODE HERE
		try
		{
		if(instance == null)
			instance = new DBConnectionManager();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return instance;
	}
	public Connection getConnection() {
		
		// TYPE YOUR CODE HERE
		try {
			DBConnectionManager dbc = getInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
