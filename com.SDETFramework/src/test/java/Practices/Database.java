package Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class Database {

	public static void main(String[] args) throws Throwable {

		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		Statement stat = conn.createStatement();
		String selectQuary="select * from Worker";
		ResultSet result = stat.executeQuery(selectQuary);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
		}
		conn.close();
	}

}





