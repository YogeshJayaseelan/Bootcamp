package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO_32_DeleteTask {

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
		
		//Click on Login button		
		driver.findElementById("Login").click();
		System.out.println("Login is Successfull");
		

		//Click toggle Menu		
		driver.findElementByClassName("slds-icon-waffle_container").click();
		System.out.println("Toggle Menu is clicked Successfully");
		
		//Click on View all		
		driver.findElementByXPath("//button[text()='View All']").click();
		System.out.println("Login is Successfully");
		
		//Click on Sale App		
		driver.findElementByXPath("//p[text()='Sales']").click();
		System.out.println("Sale app is launched Successfully");
		
		
		//Click on Task Tab(use Java Script executer if normal selenium click doesnt work)		
		WebElement tasks = driver.findElement(By.xpath("(//a[@Title='Tasks'])"));      
		String javascript = "arguments[0].click()";      
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
		jsExecutor.executeScript(javascript, tasks);
		System.out.println("Task tab is clicked Successfully");
		
		//Click on Dropdown option
		driver.findElementByXPath("//a[@title='Select List View']").click();
		System.out.println("Droped is clicked Successfully");
		
		//Choose Recently viewed option
		driver.findElementByXPath("(//span[contains(text(),'Recently Viewed')])[3]").click();
		System.out.println("Recently Viewed option is selected");
		
		//click on Bootcamp first result
	    driver.findElementByXPath("(//div[@class='forceRecordLayout'])[1]").click();
	    System.out.println("First Bootcamp task is clicked");
	    
	    //click on action dropdown
	   
	    driver.findElementByXPath("//a[@title='Show 13 more actions']").click();
	    System.out.println("Action Dropdown is clicked");
	    
	     
	    //Click on Delete option(use Java Script executer if normal selenium click doesnt work)
		Thread.sleep(3000);
	    WebElement delete = driver.findElement(By.xpath("//div[@class='branding-actions actionMenu']//div[contains(text(),'Delete')]"));      
		String javascript1 = "arguments[0].click()";      
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;        
		jsExecutor1.executeScript(javascript1, delete);
		System.out.println("Task tab is clicked Successfully");	    
	   
	    
	    //Click on delete button
	    driver.findElementByXPath("//span[contains(text(),'Delete')]").click();
	    System.out.println("Delete button is selected");
	    
	    
	   //Verify task is deleted
	  //Verify error message		
		 String actual_msg = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']").getText();
		 System.out.println(actual_msg);
		    
		//Store message in variable
		 String expect="Task \"BootCamp\" was deleted. Undo";

		// Verify error message
	    Assert.assertEquals(actual_msg, expect , "Message Doesnt Not Match");
	    System.out.println("Task Boot camp is deleted successfuly");
	}

}
