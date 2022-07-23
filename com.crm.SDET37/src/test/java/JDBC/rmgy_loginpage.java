package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rmgy_loginpage {
	public static void main(String[]args) throws InterruptedException, SQLException {
		String project_name="TY_PROJECT_009";
		Connection connection = null;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Projects\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Create Project\"]")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(project_name);
//		driver.findElement(By.xpath("//input[@name='teamSize']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("bindhu");
		WebElement statuslist = driver.findElement(By.xpath("//label[text()=\"Project Status \"]/following-sibling::select"));
		
		Select s=new Select(statuslist);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		
		String query="select* from project";
		ResultSet Result = statement.executeQuery(query);
		
		
		while(Result.next()) {
			String allprojects = Result.getString(4);
			if(allprojects.contains(project_name)) {
				System.out.println("project is created in DB");
				break;
			}
		}
	}
	catch(Exception e) {
	e.printStackTrace();	
	}
	finally {
		connection.close();
		  
	}
	driver.close();
	
	
}
}
	
	



