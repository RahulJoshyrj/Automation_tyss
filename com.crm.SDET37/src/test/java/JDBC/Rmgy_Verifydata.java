package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rmgy_Verifydata {
	

	public static void main(String[] args) throws SQLException {
		
		
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		Statement statement = connection.createStatement();
		String query="insert into project values('TY_project_666','damon','12/07/2022','SDET_666','created','10')";
		
		int result = statement.executeUpdate(query);
		if(result==1) {
			System.out.println("data is created");
			
		}
		else {
			System.out.println("data is not created");
		}
		
		
		  
		
		try {
			String projectname="TY_project_666";
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
		
			
			driver.get("http://localhost:8084");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("//a[text()=\"Projects\"]")).click();
//			List<WebElement> table = driver.findElements(By.xpath("//table[@class=\"table table-striped table-hover\"]"));
			if(driver.getPageSource().contains(projectname)) {
				System.out.println("project created");
			}
			else {
				System.out.println("project not created");
			}
//				 
			
			driver.close();
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		finally {
			System.out.println("task complete");
			connection.close();
		}
		
	
		
		
	}
	

}
