package week1;

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

public class SFO_31_EditTask {

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
			    
			    Thread.sleep(4000);
			   //click on edit due date
			    driver.findElementByXPath("//button[@title='Edit Due Date']").click();
			    System.out.println("Due date is in editbale mode");
			    
			    			    
			    Thread.sleep(3000);
			    //Click on Calendar Icon
			     driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
			    
			    //Set Today date
			    
			    Date today = new Date();               
				SimpleDateFormat formattedDate = new SimpleDateFormat("MM/dd/yyyy");            
				Calendar c = Calendar.getInstance();  
				// number of days to add  
				String currentdate = (String)(formattedDate.format(c.getTime()));
				System.out.println("Current date is " + currentdate);
				driver.findElementByXPath("//input[@class='inputDate input']").clear();
				driver.findElementByXPath("//input[@class='inputDate input']").sendKeys(currentdate);
				System.out.println("Due date is selected as today");
				
				Thread.sleep(3000);
				//Click on Priority Dropdown
				driver.findElementByXPath("(//a[@class='select'])[2]").click();
				System.out.println("Priority Drop down is clicked");
				
				//Set priority as low
				driver.findElementByXPath("(//a[contains(text(),'Low')])[1]").click();
				System.out.println("Priority is set to low");
				
				
				//Click on save button
				driver.findElementByXPath("//span[contains(text(),'Save')]").click();
				System.out.println("Task is edited and saved successfully");
				
				
				
				
				
				
			    
			    
			    
			    
			    
			    
			    
			
				


	}

}
