package com.crm.Vtiger_ContactModule;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_ContactModuleTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()=\"Contacts\"])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select sal=new Select(salutation);
		sal.selectByValue("Mr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("joshy");
		
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		Set<String> childwin = driver.getWindowHandles();
		for(String win:childwin) {
			driver.switchTo().window(win);
		
			
		}
		
		driver.findElement(By.name("search_text")).sendKeys("Test Yantra software solutions");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='Test Yantra software solutions']")).click();
		
		Set<String> mainwin = driver.getWindowHandles();
		for(String string:mainwin) {
			driver.switchTo().window(string);		
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
