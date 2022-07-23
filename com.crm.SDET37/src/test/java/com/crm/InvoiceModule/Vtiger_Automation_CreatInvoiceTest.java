package com.crm.InvoiceModule;

import java.awt.Desktop.Action;
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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_CreatInvoiceTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//load property file
		FileInputStream fileinputstream=new FileInputStream("./src/test/resources/commondata.property.txt");
		Properties property=new Properties();
		property.load(fileinputstream);
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		String url=property.getProperty("url");
		//load excel file
		FileInputStream testdata=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(testdata);
		//load nessasary data from excel sheet
		String subject=workbook.getSheet("invoice").getRow(1).getCell(0).getStringCellValue();
		String billingadd=workbook.getSheet("invoice").getRow(1).getCell(1).getStringCellValue();
		String shippingadd=workbook.getSheet("invoice").getRow(1).getCell(2).getStringCellValue();
		String orgname=workbook.getSheet("invoice").getRow(1).getCell(3).getStringCellValue();
		String salesorder=workbook.getSheet("invoice").getRow(1).getCell(4).getStringCellValue();
		String product_name=workbook.getSheet("invoice").getRow(1).getCell(5).getStringCellValue();

		//initialize webdrivermanager
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//go to vtiger login in
		driver.get(url);
		//enter login credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//mouse hover to more tab in home page
		WebElement target = driver.findElement(By.xpath("//a[text()='More']"));
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
		//click on invoice module in more
		driver.findElement(By.xpath("//a[@name='Invoice']")).click();
		//click on creat new invoice
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		String parent = driver.getWindowHandle();
		//enter subject
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> salesorderwindow = driver.getWindowHandles();
		for(String window:salesorderwindow) {
		driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//a[text()='"+salesorder+"']")).click();
		Set<String> parentwindow = driver.getWindowHandles();
		for(String window:parentwindow) {
			driver.switchTo().window(window);
		}
		
		//select organization
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[3]")).click();
		Set<String> organisationwindow = driver.getWindowHandles();
		for(String window:organisationwindow) {
			driver.switchTo().window(window);
		}
		
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));	
		Actions signout=new Actions(driver);
		signout.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();











	}

}
