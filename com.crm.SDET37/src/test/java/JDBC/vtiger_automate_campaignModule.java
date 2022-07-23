package JDBC;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtiger_automate_campaignModule {

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
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("TestingEctasy");
		WebElement campaign = driver.findElement(By.xpath("//select[@name='campaigntype']"));
		Select s=new Select(campaign);
		s.selectByValue("Conference");
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> allproduct = driver.getWindowHandles();
		for(String product:allproduct) {
			driver.switchTo().window(product);
		}
		driver.findElement(By.xpath("//a[text()=\"vtigerCRM\"]")).click();
		Set<String> allwin = driver.getWindowHandles();
		for(String win:allwin) {
			driver.switchTo().window(win);
		}
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

		driver.close();
	}

}
