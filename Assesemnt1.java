package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assesemnt1 {

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
		
		//Click on Service Console
		driver.findElementByXPath("//p[text()='Service Console']").click();
		System.out.println("Serive Console is clicked Successfully");
		
		//Click on the dropdown icon
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class='slds-context-bar__icon-action']").click();
		System.out.println("Drop down icon V is clicked");
		
		
		//Choose option as Home
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@title='Home']").click();
		System.out.println("Home Option is choosed");
		
		
		//Get the value of Closed 
		Thread.sleep(3000);
		String ClosedValue = driver.findElementByXPath("(//span[@class='metricAmount uiOutputText'])[1]").getText();
		System.out.println(ClosedValue);
		
		//Get Open Value
		String OpenValue = driver.findElementByXPath("(//span[@class='metricAmount uiOutputText'])[2]").getText();
		System.out.println(OpenValue);
		
		
		//Converting ClosedValue string into number
		int closedvalueNumber = Integer.parseInt(ClosedValue.replaceAll("[^0-9]", ""));
		System.out.println(closedvalueNumber);
		
		//Converting ClosedValue string into number
		int OpenValueNumber = Integer.parseInt(OpenValue.replaceAll("[^0-9]", ""));
		System.out.println(OpenValueNumber);
		
		int closeandOpenValue = closedvalueNumber+OpenValueNumber;
		System.out.println(closeandOpenValue);
		
		//Click on Goal Edit Icon
		driver.findElementByXPath("//*[@data-key='edit']").click();
		System.out.println("Goal Edit Icon is clicked");
		
		if(closeandOpenValue > 10000)
			
		{
			driver.findElementByXPath("//div[@class='inputContainer']//input[@type='text']").clear();
			driver.findElementByXPath("//div[@class='inputContainer']//input[@type='text']").sendKeys(String.valueOf(closeandOpenValue));
		}
		else {
			driver.findElementByXPath("//div[@class='inputContainer']//input[@type='text']").clear();
			driver.findElementByXPath("//div[@class='inputContainer']//input[@type='text']").sendKeys("10000");
		}
		
		System.out.println("USD Gaol value is typed successfully");
		
		
		//Click on Save Button
		driver.findElementByXPath("//span[contains(text(),'Save')]").click();
		System.out.println("Goal is Edited and Daved Successfully");
		
		//Click on the dropdown icon
		driver.findElementByXPath("//div[@class='slds-context-bar__icon-action']").click();
		System.out.println("Drop down icon V is clicked");
				
				
		//Choose option as Dashboards
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@title='Dashboards']").click();
		System.out.println("Dashboard Option is choosed");
		
		//Click on Private Dashboard
		driver.findElementByXPath("(//a[contains(text(),'Private Dashboards')])[1]").click();
		System.out.println("Private Dashboard is selected");
		
		//Click on New Dashboard
		driver.findElementByXPath("//div[contains(text(),'New Dashboard')]").click();
		System.out.println("New Dashboard is selected");
		
			
		//Enter Dashboard Name
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='dashboardNameInput']").sendKeys("Yogesh_Bootcamp");
		System.out.println("Dashboard name is entered");
		
		//Enter Dashboard Description
		driver.findElementByXPath("//input[@id='dashboardDescriptionInput']").sendKeys("Testing");
		System.out.println("Dashboard Description is entered");
		
		//Click on Create Button
		driver.findElementByXPath("//button[contains(text(),'Create')]").click();
		System.out.println("New Private Dashboard is Created");
		
		//Click on Done button
		Thread.sleep(4000);
		driver.findElementByXPath("//button[contains(text(),'Done')]").click();
		System.out.println("Done option is clicked");
		
		//Click on Subscribe option
		driver.findElementByXPath("//button[contains(text(),'Subscribe')]").click();
		System.out.println("Dashboard is subscribed");
		
		
		
	}

}
