package EdurekaProj_SeleniumTest;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import	org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;



public class EdurekaTestWebsite {

	WebDriver drv1;
	@BeforeTest
	public void BeforeTestMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\akambale\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
	}
	
	@Test
	public void TestMethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless","--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
		drv1 = new ChromeDriver(options);	
		drv1.get("http://3.139.96.63:8081/");
		drv1.manage().window().maximize();
		drv1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement link1 = drv1.findElement(By.xpath("//*[@id=\"About Us\"]"));
		link1.click();
		WebElement para1 = drv1.findElement(By.xpath("//*[@id=\"PID-ab2-pg\"]"));
		String paraText = para1.getText();
		String checkText = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		
		 Assert.assertEquals(paraText, checkText);
		
		
	}
		
		
	@AfterTest
	public void DriverClose() {
		drv1.close();
	}
	


}
