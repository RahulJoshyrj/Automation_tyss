package com.crm.Vtiger_OrgasnisationModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_organisationModuleTest {
/**
 * @author RJ
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		//Loading property file
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/commondata.property.txt");
		Properties property=new Properties();
		property.load(fileinputstream);
		//saving property file values in java
		String un=property.getProperty("username");
		String pwd=property.getProperty("password");
		String url=property.getProperty("url");

		//loading excel sheet
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		//fetching nessasary values from excel
		String orgname=sheet.getRow(2).getCell(0).getStringCellValue();
		String website=sheet.getRow(2).getCell(1).getStringCellValue();
		String address=sheet.getRow(2).getCell(2).getStringCellValue();
		String shipadd=sheet.getRow(2).getCell(3).getStringCellValue();

		//loading/opening  chromedriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//enter URL in chrome browser
		driver.get(url);
		//adding implicit wait of 10seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//enter username
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		//enter password
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		//click login
		driver.findElement(By.id("submitButton")).click();
		//click on organization link
		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		//click on create organizations link
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//enter organization name
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		//enter website
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(website);
		//select value for type of industry from drop down
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(industry);
		s.selectByValue("Technology");
		//save the organization
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		//click on contacts link
		driver.findElement(By.xpath("(//a[text()=\"Contacts\"])[1]")).click();
		//click on create contact 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//select value from salutation for contact
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select sal=new Select(salutation);
		s.selectByValue("Mr.");
		//save the contact 
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//close the browser
		driver.close();




	}

}
