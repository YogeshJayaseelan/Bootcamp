package week2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO_48_CreateNewCampaign {

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
				driver.findElementByXPath("//p[text()='Community']").click();
				System.out.println("Community App is clicked Successfully");
				
				
				//click on Edit icon on the first assistant (use Java Script executer if normal selenium click doesnt work)	
					
				WebElement NewTask = driver.findElement(By.xpath("(//span[contains(text(),'editButton')])[1]"));      
				String javascript = "arguments[0].click()";      
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
				jsExecutor.executeScript(javascript, NewTask);
			//	driver.findElementByXPath("(//span[contains(text(),'editButton')])[1]").click();
				System.out.println("Edit icon for the first assistant is clicked");
				
				//click on amount textbox and type
				Thread.sleep(4000);
				driver.findElementByXPath("//input[@class='input uiInputSmartNumber uiInput uiInput--default uiInput--input']").sendKeys("10000");
				System.out.println("Amount 10000 is entered");
				
				
				//check private checkbox
				driver.findElementByXPath("//span[contains(text(),'Private')]").click();
				System.out.println("Private Checkbox is clicked");
				
				//Set close date to 1 week from today date	
				SimpleDateFormat CurrentDate = new SimpleDateFormat("MM/dd/yyyy");            
				Calendar c = Calendar.getInstance();  
				// number of days to add  
				c.add(Calendar.DATE, 7);
				String OneweekfromToday = (String)(CurrentDate.format(c.getTime()));
				System.out.println("One week from today date is " + OneweekfromToday);					
				driver.findElementByXPath("//div[@class='form-element']/input").clear();
				driver.findElementByXPath("//div[@class='form-element']/input").sendKeys(OneweekfromToday);
				
				//Click on Primary Campaign source
				driver.findElementByXPath("//input[@title='Search Campaigns']").click();
				System.out.println("Primary Source Campaign is clicked");	
				
				//Choose option as new campaign
				driver.findElementByXPath("//span[contains(text(),'New Campaign')]").click();
				System.out.println("New Campaign option is selected");	
				
				
				//Type Campaign name
				Thread.sleep(3000);
			    driver.findElementByXPath("(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input[@class=' input'])[7]").sendKeys("Bootcamp");
			    System.out.println("Campaign is named as Bootcamp");
			  
			    
			    //Set Start date as 1 week from today date
			    driver.findElementByXPath("(//div[@class='form-element']/input)[2]").sendKeys(OneweekfromToday);
			    System.out.println("Start date is set to 1 week from today");
			    
			    //Set End date as 3 week from today date
			    SimpleDateFormat CurrentDatee = new SimpleDateFormat("MM/dd/yyyy");            
				Calendar calc = Calendar.getInstance();  
				// number of days to add  
				calc.add(Calendar.DATE, 21);
				String Threeweekfromtoday = (String)(CurrentDate.format(c.getTime()));
				System.out.println("One week from today date is " + Threeweekfromtoday);					
				driver.findElementByXPath("(//div[@class='form-element']/input)[3]").sendKeys(Threeweekfromtoday);
				System.out.println("Start date is set to 3 week from toda");
				
				//Type description
				driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Specimen");
				System.out.println("Description is entered as specimen");
				
				//click on Save button
				driver.findElementByXPath("//button[@title='Save']/span[contains(text(),'Save')]").click();
				System.out.println("Save button is clicked in the new campaign page");
				
				
				//verify the campaign is created
				String CampCreated = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']").getText();
				System.out.println(CampCreated);
				
				
				

	}

}
