package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO_30_CreateTask {

	public static void main(String[] args) throws Exception {
		
	/*	//Launch Chrome Driver
		
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		
		//To display chrome notifications
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");      
        ChromeDriver driver = new ChromeDriver(ops);
        System.out.println("Browser Launched Successfully");*/
		
	/*	//Launch firefox driver
		System.setProperty("webdriver.gecko.driver","D://Softwares//Drivers//geckodriver_64 bit.exe"); 
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
     	FirefoxDriver driver = new FirefoxDriver(options); */
		
		//launch edge browser
	/*	System.setProperty("webdriver.edge.driver", "D://Softwares//Drivers//edgedriver_win64//msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();	*/   
	
		System.out.println("Enter browser name: ");
		Scanner s = new Scanner(System.in);
		String browser = s.nextLine();
		System.out.println("Your browser name is " + browser);
		
	 RemoteWebDriver driver ;
		
		//String browser ="chrome";
		if(browser.equalsIgnoreCase("firefox")){
	        	System.setProperty("webdriver.gecko.driver","D://Softwares//Drivers//geckodriver_64 bit.exe"); 

	        	  driver = new FirefoxDriver();
	        }
	       
	        else if(browser.equalsIgnoreCase("chrome")){
	            
	        	WebDriverManager.chromedriver().setup();
	        	ChromeOptions ops = new ChromeOptions();
	            ops.addArguments("--disable-notifications");      
	            driver = new ChromeDriver(ops);
	            System.out.println("Browser Launched Successfully");
	        }
	       
	         else if(browser.equalsIgnoreCase("ie")){
	                    
	                	System.setProperty("webdriver.chrome.driver", "D://Softwares//Drivers//Chromedriver.exe");
	                   
	                    driver = new InternetExplorerDriver();
	                }
	        else{
	            //If no browser passed throw exception
	            throw new Exception("Browser is not correct");
	        }
		
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
		
		
		//Click SVG Global Icon Menu
		Thread.sleep(11000);
		driver.findElementByXPath("//*[@data-key='add']").click();
		System.out.println("SVG Global is clicked Successfully");		
	
		
		//Click on New Task	
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@title='New Task']").click();
		System.out.println("New Task is clicked Successfully");
		
       //Type in Subject text box 
		driver.findElementByXPath("//input[@class='slds-input slds-combobox__input']").sendKeys("BootCamp");
		System.out.println("Subject BootCamp is passed Successfully");
		
		
		//Choose contact
		driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys("Sarath M");
		System.out.println("Contact is passed Successfully");
		
		//Click on Sharath
		driver.findElementByXPath("//div[@title='Sarath M']").click();
		
		
		//Click on satus option
		driver.findElementByXPath("//a[@class='select']").click();
		
		driver.findElementByXPath("(//a[contains(text(),'Waiting on someone else')])[1]").click();
		System.out.println("Status is selected Successfully");
		
		
		//Click on Save button 
		driver.findElementByXPath("(//span[contains(text(),'Save')])[3]").click();
		
		//Verify task created message
		
		
		//Verify error message		
		 String actual_msg = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']").getText();
		 System.out.println(actual_msg);
		    
		//Store message in variable
		 String expect="Task BootCamp was created.";

		// Verify error message
	    Assert.assertEquals(actual_msg, expect , "Message Doesnt Not Match");
		
			


	
	      
	 }
	
}



