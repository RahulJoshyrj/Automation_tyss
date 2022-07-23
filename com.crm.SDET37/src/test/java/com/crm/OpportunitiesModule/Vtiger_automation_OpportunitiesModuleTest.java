package com.crm.OpportunitiesModule;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_OpportunitiesModuleTest {

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
		
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("QspiderBTM");
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		Set<String> childwin = driver.getWindowHandles();
		for(String window:childwin) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//a[text()='Test Yantra software solutions']")).click();
		Set<String> windows = driver.getWindowHandles();
		for(String w:windows) {
			driver.switchTo().window(w);
		}
		WebElement opp = driver.findElement(By.xpath("//select[@name='opportunity_type']"));
		Select s=new Select(opp);
		s.selectByValue("Existing Business");
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
		Set<String> allwin = driver.getWindowHandles();
		for(String win:allwin) {
			driver.switchTo().window(win);
		}
		driver.findElement(By.xpath("//a[text()='TestingEctasy']")).click();
		Set<String> cw = driver.getWindowHandles();
		for(String win:cw) {
			driver.switchTo().window(win);
		}
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/btnL3Calendar.gif'])[2]")).click();
		driver.findElement(By.xpath("//td[text()='15']")).click();
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		

	}

}
