package Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelect_Quarry {

	public static void main(String[] args) throws Throwable
	{
		 Driver driverref = new Driver();
		 DriverManager.registerDriver(driverref);
		 
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		 Statement stat = conn.createStatement();
		 String res="insert into Worker (first_name,last_name,address,lead)values('MADDY','MS','KARNATAKA','BANGALORE')";
		 int result = stat.executeUpdate(res);
		// int result = stat.executeUpdate(Quarry);
		 
		 if (result==1) 
		 {
			 System.out.println("user is created");
		 }
		 else
		 {
			 System.out.println("user is not created");
		 }
		 conn.close();
		
	}

}
