package JDBC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtiger_Automation_creatVender {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		WebElement more = driver.findElement(By.xpath("//a[text()=\"More\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[@name=\"Vendors\"]")).click();
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys("JoshyThomas");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("joshythomas@gmail.com");
		WebElement glaccount = driver.findElement(By.xpath("//select[@name='glacct']"));
		Select s=new Select(glaccount);
		s.selectByValue("300-Sales-Software");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("sells original softwares");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
				
	}

}
