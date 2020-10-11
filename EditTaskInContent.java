package week3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditTaskInContent {

	public static void main(String[] args) throws InterruptedException {
 //Launch Chrome Driver
		
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		
		//To display chrome notifications
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");      
        ChromeDriver driver = new ChromeDriver(ops);
        System.out.println("Browser Launched Successfully");
		
		//Maximize browser
		
		driver.manage().window().maximize();
		
		//Wait for element
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Load Url
		driver.get(" https://login.salesforce.com/?locale=in");
		System.out.println("URL is Successfull");
		
		//Type Username and Password 
		
		driver.findElementById("username").sendKeys("nupela@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp$123");
		System.out.println("Username and Password is typed is typed Successfully");	
		
		//Click on Login button		
		driver.findElementById("Login").click();
		System.out.println("Login is Successfull");
		
		//Click toggle Menu		
		driver.findElementByClassName("slds-icon-waffle_container").click();
		System.out.println("Toggle Icon is clicked Successfully");
		
		//Click on View all		
		driver.findElementByXPath("//button[text()='View All']").click();
		System.out.println("View All option is clicked Successfully");
		
		//Click on Community App		
		driver.findElementByXPath("//p[text()='Content']").click();
		System.out.println("Content App is clicked Successfully");
		
		//Click viewall option from today's task section
		driver.findElementByXPath("(//span[contains(text(),'View All')])[2]").click();
		System.out.println("View all button is clicked from Today's task section");
		
		//Click on Dropdown option
		driver.findElementByXPath("//a[@title='Select List View']").click();
		System.out.println("Dropdown is clicked Successfully");
		
		//Choose Recently viewed option
		driver.findElementByXPath("//span[contains(text(),'Recently Viewed')]").click();
		System.out.println("Open tasks option is selected");
		
		//Type Email in the serach field
		WebElement Search = driver.findElementByXPath("//input[@name='Task-search-input']");
		Search.sendKeys("Email");
		Search.sendKeys(Keys.ENTER);
		System.out.println("Email is typed in the Searchbox");
		
		//click on first result
		Thread.sleep(2000);
	    driver.findElementByXPath("(//div[@class='forceRecordLayout'])[1]").click();
	    
	    //click on action dropdown
	   
	    driver.findElementByXPath("//a[@title='Show 13 more actions']").click();
	    System.out.println("Action Dropdown is clicked");
	    
	  //Click on Delete option(use Java Script executer if normal selenium click doesnt work)
	  Thread.sleep(3000);
	  WebElement delete = driver.findElement(By.xpath("(//div[@class='branding-actions actionMenu']//div[contains(text(),'Edit')])[1]"));      
	  String javascript1 = "arguments[0].click()";      
	  JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;        
	  jsExecutor1.executeScript(javascript1, delete);
	  System.out.println("Edit option is clicked Successfully");	 
	    
	  
	  //Click on Due date calendar icon
	  driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
	  System.out.println("Calendar Icon is clicked");
	  
	
	 //Click on next month button
  	 driver.findElement(By.xpath("//a[@class='navLink nextMonth']")).click();
	 System.out.println("Next button is clicked");
					
	 //Choose date as 24
	 driver.findElement(By.xpath("//span[text()='15']")).click();
	 System.out.println("Date 15 is clicked");
	  
	  
	  //click on the imgae icon of Releated to field 
	  driver.findElementByXPath("//img[@title='Accounts']").click();
	  System.out.println("Related to Image Icon is clicked");
	  
	  //choose option as accounts
	  driver.findElementByXPath("//span[@title='Accounts']").click();
	  System.out.println("Account option is selected");
	  
	  //Click on Search textbox
	  driver.findElementByXPath("//input[@title='Search Accounts']").click();
	  System.out.println("Search Account Text field is clicked");
	  
	  //choose any of the options example credit
	  driver.findElementByXPath("(//div[@title='Credits'])[1]").click();
	  System.out.println("Option is selected as credits");
	  
	  //Click on save button
	  driver.findElementByXPath("(//span[contains(text(),'Save')])[2]").click();
	  System.out.println("Save button is clicked");
	  
	  //Verify the due date releated to field
	  Thread.sleep(3000);
	  String RelatedtoFiedlValue = driver.findElementByXPath("(//a[contains(text(),'Credits')])[2]").getText();
	  System.out.println(RelatedtoFiedlValue);
	  
	//Store message in variable
	 String expect="Credits";

	 // Verify error message
	 Assert.assertEquals(RelatedtoFiedlValue, expect , "Message Doesnt Not Match");
	 System.out.println("Related field is verified");
	}

}
