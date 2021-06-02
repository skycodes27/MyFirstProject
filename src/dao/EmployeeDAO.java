package dao;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import exception.EmployeeAdminSystemException;
import model.Employee;
import util.ApplicationUtil;

public class EmployeeDAO {

	

	public static Connection connection = null;

	public boolean addEmployeeDetails(List<Employee> li) throws EmployeeAdminSystemException, SQLException, ClassNotFoundException, IOException {
		Connection con = null;
		try {
			
			
			DBConnectionManager d=new DBConnectionManager();
			con = d.getConnection();
			
			PreparedStatement myStmt=null;
			
			for (int i = 0; i < li.size(); i++) {
				
				java.sql.Date date = ApplicationUtil.utilToSqlDateConverter(li.get(i).getDob());
				
				//String sql = "INSERT INTO EMPLOYEE VALUES(" +"'"+ li.get(i).getEmpId() +"'"+ "," + "'" + li.get(i).getEmpName() + "'" + "," +"'"+ li.get(i).getDesignation() +"'"+ "," +"'"+ li.get(i).getEmpType() +"'" +"," + li.get(i).getSalary() +"," + li.get(i).getDob() + ")" + "on duplicate key update salary="  + li.get(i).getSalary()  + ";" ;
				myStmt = con.prepareStatement("insert into employee"+
                        "(empnumber,ename,designation,emptype,salary,dateofbirth)"+
                        "values"+
                        "(?,?,?,?,?,?)");

				myStmt.setString(1,li.get(i).getEmpId());
				myStmt.setString(2,li.get(i).getEmpName());
				myStmt.setString(3,li.get(i).getDesignation());
				myStmt.setString(4,li.get(i).getEmpType());
				myStmt.setDouble(5,li.get(i).getSalary());
				myStmt.setDate(6,date);
					

				myStmt.execute();
				
				con.close();
	            return true;
			}
			
            
        } catch(SQLException e) {
            con.rollback();
            throw new EmployeeAdminSystemException();
        }
		catch(Exception e)
		{
			throw new EmployeeAdminSystemException();
		}
        
        return false;
        
        
	}
	
}
