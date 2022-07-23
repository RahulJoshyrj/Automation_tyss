package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Rmgyantra_addproject {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		Statement statement = connection.createStatement();
		String query = "insert into project values('TY_project002','Joshy','09/07/2022','SDET_002','created','10')";
		int result = statement.executeUpdate(query);
		
		if(result==1) {
			System.out.println("data created");
		}
		else {
			System.out.println("data not created");
		}
		connection.close();

	}

}
