package com.crm.Vtiger_OrgasnisationModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Creat_organisaationWithIndustryandTypeTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/commondata.property.txt");
		Properties property=new Properties();
		property.load(fileinputstream);
		String un=property.getProperty("username");
		String pwd=property.getProperty("password");
		String url=property.getProperty("url");
		
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		String orgname=sheet.getRow(3).getCell(0).getStringCellValue();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(industry);
		s.selectByValue("Technology");
		
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("technoelevate@gmail.com");
		
		WebElement type = driver.findElement(By.xpath("(//select[@name='accounttype'])"));
		Select s1=new Select(type);
		s1.selectByValue("Investor");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		Thread.sleep(2000);
		WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(target).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
