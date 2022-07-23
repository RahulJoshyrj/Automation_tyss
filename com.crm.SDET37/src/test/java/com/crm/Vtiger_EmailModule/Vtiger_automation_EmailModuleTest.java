package com.crm.Vtiger_EmailModule;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_EmailModuleTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Email\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Compose\"]")).click();
		Set<String> childwin = driver.getWindowHandles();
		for(String win:childwin) {
			driver.switchTo().window(win);
		}
		driver.findElement(By.xpath("//input[@id='cc_name']")).sendKeys("thadathiljoshy@gmail.com");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("confirmation mail");
		 driver.switchTo().frame(0);
		 WebElement el = driver.switchTo().activeElement();
		 Actions a=new Actions(driver);
		 a.moveToElement(el).perform();
		 el.sendKeys("confirmation mail");
		 driver.switchTo().parentFrame();
		 
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
			Set<String> secondwin = driver.getWindowHandles();
			for(String win:secondwin) {
				driver.switchTo().window(win);
			}
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("joshy");
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.xpath("//a[text()=\"Rahul joshy\"]")).click();
		
			
			Set<String> allwin = driver.getWindowHandles();
			for(String win:allwin) {
				driver.switchTo().window(win);
			}
			
			
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
			driver.findElement(By.xpath("(//input[@name='Send'])[2]")).click();
		 
		 
		 
		
		
	}

}
