package Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NoselectQuarry2 {

	public static void main(String[] args) throws Throwable 
	{
		 Driver driverref = new Driver();
		 DriverManager.registerDriver(driverref);
		 
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		 Statement stat = conn.createStatement();		 
		 String Quarry="insert into Worker (first_name,last_name,address,lead)values('Maddy','MS','Karnataka','Bangalore')";
		 int result = stat.executeUpdate(Quarry);

		 
		 String Quarry1="insert into Worker (first_name,last_name,address,lead)values('SAI','SHIRAD','PUNE','MAHARASTRA')";
		 int result1 = stat.executeUpdate(Quarry1);

		 if(result==1 || result1==2)
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

