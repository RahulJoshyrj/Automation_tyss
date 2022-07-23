package com.crm.AssestsModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Automation_AssetsWithInvoice {

	public static void main(String[] args) throws IOException {
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
				double assetno=workbook.getSheet("assets").getRow(1).getCell(0).getNumericCellValue();
				double serialnumber=workbook.getSheet("assets").getRow(1).getCell(1).getNumericCellValue();
				double shippingTracknumber=workbook.getSheet("assets").getRow(1).getCell(2).getNumericCellValue();
				String productname=workbook.getSheet("assets").getRow(1).getCell(3).getStringCellValue();
				String invoicename=workbook.getSheet("assets").getRow(1).getCell(4).getStringCellValue();
				String customername=workbook.getSheet("assets").getRow(1).getCell(5).getStringCellValue();
				String assetname=workbook.getSheet("assets").getRow(1).getCell(6).getStringCellValue();
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(url);
				//enter login credentials
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				//mouse hover to more tab in home page
				WebElement target = driver.findElement(By.xpath("//a[text()='More']"));
				Actions a=new Actions(driver);
				a.moveToElement(target).perform();
				//click on assets module in more
				driver.findElement(By.xpath("//a[@name='Assets']")).click();
				
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.xpath("//input[@name='asset_no']")).sendKeys(String.valueOf(assetno));
				driver.findElement(By.xpath("//input[@name='serialnumber']")).sendKeys(String.valueOf(serialnumber));
				driver.findElement(By.xpath("//input[@name='shippingtrackingnumber']")).sendKeys(String.valueOf(shippingTracknumber));
				driver.findElement(By.xpath("//input[@name='assetname']")).sendKeys("assetname");
				String parent = driver.getWindowHandle();
				driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
				Set<String> invoicewindow = driver.getWindowHandles();
				for(String window:invoicewindow) {
					driver.switchTo().window(window);
				}
				driver.findElement(By.xpath("//a[text()='"+invoicename+"']")).click();
				driver.switchTo().window(parent);
				
				driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
				Set<String> productwindow = driver.getWindowHandles();
				for(String window:productwindow) {
					driver.switchTo().window(window);
				}
				driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
				driver.switchTo().window(parent);
				
				driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[3]")).click();
				Set<String> customerwindow = driver.getWindowHandles();
				for(String window:customerwindow) {
					driver.switchTo().window(window);
				}
				driver.findElement(By.xpath("//a[text()='"+customername+"']")).click();
				driver.switchTo().window(parent);
				
				driver.findElement(By.xpath("(//img[@src='themes/softed/images/btnL3Calendar.gif'])[3]")).click();
				driver.findElement(By.xpath("//td[text()='22']")).click();
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
	}

}
