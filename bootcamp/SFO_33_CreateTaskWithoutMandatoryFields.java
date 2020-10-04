package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO_33_CreateTaskWithoutMandatoryFields {

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
				
				//Click on Sale App		
				driver.findElementByXPath("//p[text()='Sales']").click();
				System.out.println("Sale App is clicked Successfully");
				
				//Click on Task dropdown icon
				Thread.sleep(4000);
			    driver.findElementByXPath("(//*[@data-key='chevrondown'])[2]").click();
				System.out.println("Task dropdown icon is clicked Successfully");
				
				
				//Click on New Task + Option(use Java Script executer if normal selenium click doesnt work)		
				WebElement NewTask = driver.findElement(By.xpath("//span[contains(text(),'New Task')]"));      
				String javascript = "arguments[0].click()";      
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
				jsExecutor.executeScript(javascript, NewTask);
				//driver.findElementByXPath("//span[contains(text(),'New Task')]").click();
				System.out.println("New Task + Option is selected");
				
				
				//Type in Comment Textbox
				Thread.sleep(3000);
				driver.findElementByXPath("//textarea[@role='textbox']").sendKeys("SALES FORCE Automation Using Selenium");	
				
				
				//Click on Save Button 
				driver.findElementByXPath("//button[@title='Save']").click();
				
				
				//Verify error message
				 String actual_msg = driver.findElementByXPath("//ul[@class='errorsList']").getText();
				 System.out.println(actual_msg);
				    
				//Store message in variable
				 String expect="These required fields must be completed: Subject";

				// Verify error message
			    Assert.assertEquals(actual_msg, expect , "Message Doesnt Not Match");
			    System.out.println("Error message for subject field is verified");
	}

}
