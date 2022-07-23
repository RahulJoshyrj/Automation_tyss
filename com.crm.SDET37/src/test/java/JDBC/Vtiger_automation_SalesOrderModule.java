package JDBC;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_automation_SalesOrderModule {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		WebElement more = driver.findElement(By.xpath("//a[text()=\"More\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[@name='Sales Order']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Flinko");
		

		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		Set<String> oppwin = driver.getWindowHandles();
		for(String window:oppwin) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//a[text()='QspiderBTM']")).click();
		
		Set<String> newwin = driver.getWindowHandles();
		for(String window:newwin) {
			driver.switchTo().window(window);
		}
		
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/btnL3Calendar.gif'])[2]")).click();
		driver.findElement(By.xpath("(//td[text()='15'])")).click();
		
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("Thadathil,MangalaRoad,Kannur,Kerala");
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("Thadathil,MangalaRoad,Kannur,Kerala");
		
		driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
		Set<String> productswin = driver.getWindowHandles();
		for(String window:productswin) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//a[text()='vtigerCRM']")).click();
		Set<String> orgwin = driver.getWindowHandles();
		for(String window:orgwin) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("(//input[@name='qty1'])")).sendKeys("500");
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		driver.close();
	}

}
