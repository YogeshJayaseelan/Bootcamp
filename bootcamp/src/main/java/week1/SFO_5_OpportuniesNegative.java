package week1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Asserts;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO_5_OpportuniesNegative {

	public static void main(String[] args) {
		
		//Launch Chrome Driver
		
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		
		//To display chrome notifications
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");      
        ChromeDriver driver = new ChromeDriver(ops);
		
		
		//Maximize browser
		
		driver.manage().window().maximize();
		
		//Wait for element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Load Url
		driver.get("https://login.salesforce.com");
		
		//Type Username and Password 
		
		driver.findElementById("username").sendKeys("nupela@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp$123");
		
		//Click on Login button		
		driver.findElementById("Login").click();
		
		
		//Click toggle Menu		
		driver.findElementByClassName("slds-icon-waffle_container").click();
		
		//Click on View all		
		driver.findElementByXPath("//button[text()='View All']").click();
		
		//Click on Sale App		
		driver.findElementByXPath("//p[text()='Sales']").click();
		
				
		//Click on Opportunities(use Java Script executer if normal selenium click doesnt work)		
		WebElement opportunity = driver.findElement(By.xpath("(//a[@Title='Opportunities'])"));      
		String javascript = "arguments[0].click()";      
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
		jsExecutor.executeScript(javascript, opportunity);
		
		
		//Click on New button		
		driver.findElementByXPath("//div[text()='New']").click();
		
		
		//Get today date and add 1		
		Date today = new Date();               
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");            
		Calendar c = Calendar.getInstance();  
		// number of days to add   
		c.add(Calendar.DATE, 1);    
		String tomorrow = (String)(formattedDate.format(c.getTime()));
		System.out.println("Tomorrows date is " + tomorrow);
		driver.findElementByXPath("//input[@class=' input']").sendKeys(tomorrow);
	         
	    //Click on Save button		
		driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		
		
		//Verify error message		
		 String actual_msg = driver.findElementByClassName("errorsList").getText();
		 System.out.println(actual_msg);
		    
		//Store message in variable
		 String expect="These required fields must be completed: Opportunity Name, Stage";

		// Verify error message
	    Assert.assertEquals(actual_msg, expect , "Message Doesnt Not Match");
		
			

	}

	

}
