package com.crm.ProductModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_ProductModuleTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/commondata.property.txt");
		Properties property=new Properties();
		property.load(fileinputstream);
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		String url=property.getProperty("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.name("productname")).sendKeys("vtigerCRM");
		driver.findElement(By.xpath("//img[@title='Open Calendar...']")).click();
		

		WebElement productcategory = driver.findElement(By.xpath("//select[@name='productcategory']"));
		Select s=new Select(productcategory);
		s.selectByValue("Software");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		Set<String> childwin = driver.getWindowHandles();
		for(String win:childwin) {
			driver.switchTo().window(win);
		}
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("JoshyThomas");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.xpath("//a[text()=\"JoshyThomas\"]")).click();
		
		Set<String> parentwin = driver.getWindowHandles();
		for(String win:parentwin) {
			driver.switchTo().window(win);
		}
		
		WebElement upload = driver.findElement(By.xpath("//input[@id='my_file_element']"));
		upload.sendKeys("C:\\\\Users\\\\RJ\\\\Desktop\\ddt and jdbc.png");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.close();
		
		
	}

}
