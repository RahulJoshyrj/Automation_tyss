package com.crm.DocumentsModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_documentModuleTest {

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

		driver.findElement(By.xpath("//a[text()='Documents']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys("Document_001");
		WebElement uploadfile = driver.findElement(By.xpath("//input[@type='file']"));
		 uploadfile.sendKeys("C:\\Users\\RJ\\Desktop\\resume.pdf");
		 
		 driver.switchTo().frame(0);
		 WebElement el = driver.switchTo().activeElement();
		 Actions a=new Actions(driver);
		 a.moveToElement(el).perform();
		 el.sendKeys("file has been uploaded");
		 driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
