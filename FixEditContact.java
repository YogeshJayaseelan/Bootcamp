package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixEditContact {

    @Test
	public void main() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://Softwares//Drivers//Chromedriver.exe");
        
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");      
        ChromeDriver driver = new ChromeDriver(ops);
        System.out.println("Browser Launched Successfully");
		//ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Chrome browser is launched and maximized");
		

//		Authentication
		driver.findElementById("username").sendKeys("dhivya@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		System.out.println("Login is successful");

		//click on Toggle menu / changed xpath
		driver.findElement(By.className("slds-icon-waffle_container")).click();
		System.out.println("Toggle is clicked");
		
		//Click on Community option
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[3]")).click();
		System.out.println("Community option is clicked");
		
		//Click on Contacts options
		WebElement contact = driver.findElement(By.xpath("//span[text()='Contacts']"));      
		String javascript = "arguments[0].click()";      
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
		jsExecutor.executeScript(javascript, contact);
		System.out.println("Contacts tab is clicked");
		
	/*	//Click on the checkbox for the first contact / changed xpath
		driver.findElement(By.xpath("(//span[@class='slds-checkbox--faux'])[2]")).click();
		System.out.println("First Contact checkbox is enabled"); */
		
		//Click on the dropdown menu icon V
		Thread.sleep(3000);
		WebElement Dropdownicon = driver.findElement(By.xpath("(//span[contains(text(),'Show Actions')])[1]"));      
		String javascript1 = "arguments[0].click()";      
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;        
		jsExecutor1.executeScript(javascript1, Dropdownicon);
		System.out.println("Drop down icon is clicked");
		
		//Choose option as edit / Changed Edit xpath
		WebElement editoption = driver.findElement(By.xpath("//div[contains(text(),'Edit')]"));      
		String javascript11 = "arguments[0].click()";      
		JavascriptExecutor jsExecutor11 = (JavascriptExecutor) driver;        
		jsExecutor11.executeScript(javascript11, editoption);
		//driver.findElement(By.xpath("(//span[contains(text(),'Show Actions')])[1]")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'Edit')]")).click();
		System.out.println("Edit option is selected");
		
		//click on Calendar icon
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
		System.out.println("Birthdate Calendar icon is clicked");
		
		//Click on Previous month button
		driver.findElement(By.xpath("//a[@class='navLink prevMonth']")).click();
		System.out.println("Previous button is clicked");
				
		//Choose date as 24
		driver.findElement(By.xpath("//span[text()='24']")).click();
		System.out.println("Date 24 is clicked");
		
		//click on save button
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		System.out.println("Contact is edited and saved successfully");
		
		String contactnaveenelumalai = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		
		System.out.println(contactnaveenelumalai);
	
		
	}

}
