package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToInsertDataIntoDB {

	public static void main(String[] args) throws SQLException {
		//register to DB
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		//connection to mySql
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		//create statement \query
		Statement statement = connection.createStatement();
		String query = "insert into student values('virat','kohli','RMG19','2000-01-21','male','5')";
		//exectute the query
		int result = statement.executeUpdate(query);
		if(result==1) {
			System.out.println("data is created");
			
		}
		else {
			System.out.println("data is not created");
		}
		//close DB connection
		connection.close();
	}

}
