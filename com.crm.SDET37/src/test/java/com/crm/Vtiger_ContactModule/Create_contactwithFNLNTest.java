package com.crm.Vtiger_ContactModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_contactwithFNLNTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select s=new Select(salutation);
		s.selectByValue("Mrs.");
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("bindhu");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Joshy");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("bindhujoshy@gmail.com");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(target).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
