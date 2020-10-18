package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewChart {

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
		driver.findElementByXPath("//span[contains(text(),'Open Tasks')]").click();
		System.out.println("Open tasks option is selected");
		
		//click on Display as Split view icon
		driver.findElementByXPath("//button[@title='Display as Split View']").click();
		System.out.println("Display as Split view icon is clicked");
		
		//Choose Option as Table
		WebElement tableoption = driver.findElement(By.xpath("//span[contains(text(),'Table')]"));      
		String javascript = "arguments[0].click()";      
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;        
		jsExecutor1.executeScript(javascript, tableoption);
		System.out.println("Table option is clicked");
		
		
		//click on ShowCharts icon
		WebElement showcharticon = driver.findElement(By.xpath("//span[contains(text(),'Show charts')]"));      
		String javascript1 = "arguments[0].click()";      
		JavascriptExecutor jsExecutor11 = (JavascriptExecutor) driver;        
		jsExecutor11.executeScript(javascript1, showcharticon);
		System.out.println("Show chart icon is clickedd");
		
		
		//Click on New Chart button
		driver.findElementByXPath("//span[contains(text(),'New Chart')]").click();
		System.out.println("New chart button is clicked");
		
		//Type chart name
		driver.findElementByXPath("//input[@class='chartNameInputBox input']").sendKeys("Opened Tasks");
		System.out.println("Chart name is typed as Opened Charts");
		
		//click on Chart Type dropdown
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[contains(text(),'Horizontal Bar Chart')])[1]").click();
		System.out.println("Chart dropdown is clicked");
		
		//Choose Option as Donut chart
		driver.findElementByXPath("//a[@title='Donut Chart']").click();
		System.out.println("Chart option is selected as Donut");
		
		//Click on Aggregrate Dropdown
		driver.findElementByXPath("(//a[contains(text(),'Account')])[1]").click();
		System.out.println("Aggregrate Dropdown is clicked");
		
		//Choose Aggregrate as Priority
		driver.findElementByXPath("//a[@title='Priority']").click();
		System.out.println("Aggegrate is choosed as priority");
		
		//click on grouping code dropdown
		driver.findElementByXPath("(//a[contains(text(),'Account')])[1]").click();
		System.out.println("Grouping dropdown is clicked");
		
		//Choose Grouping as status
		driver.findElementByXPath("(//a[@title='Status'])[2]").click();
		System.out.println("Grouping is selected as Status");
		
		//Click on Save button
		driver.findElementByXPath("//button[@title='Save']").click();
		System.out.println("Save button is clicked");
		
	    //Mouse hover on chart 
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement target = driver.findElementByXPath("//canvas[@class='chart']");
		actions.moveToElement(target).build().perform();
		
		Thread.sleep(10000);
				
		//get Priority value
		String PriorityValue = driver.findElementByXPath("//span[@class='right uiOutputNumber']").getText();
		System.out.println(PriorityValue);
		
		//click on mark complete
		driver.findElementByXPath("(//button[@title='Mark Complete'])[1]").click();
		System.out.println("Mark complete option is selected");
		
		driver.navigate().refresh();
		System.out.println("chart is refreshed");		
			
		//click on ShowCharts icon
		Thread.sleep(3000);
		WebElement showcharticon1 = driver.findElement(By.xpath("//span[contains(text(),'Show charts')]"));      
		String javascript11 = "arguments[0].click()";      
		JavascriptExecutor jsExecutor111 = (JavascriptExecutor) driver;        
		jsExecutor111.executeScript(javascript11, showcharticon1);
		System.out.println("Show chart icon is clickedd");
		
		//verify the chart status and priority value
		String chartstatus = driver.findElementByXPath("(//div[contains(text(),'In Progress')])[1]").getText();
		System.out.println(chartstatus);
		
		String PriorityValue1 = driver.findElementByXPath("//span[@class='right uiOutputNumber']").getText();
		System.out.println(PriorityValue1);
	
		
		
	}

}
