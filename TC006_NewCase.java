package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC006_NewCase {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://Softwares//Drivers//Chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

//		Authentication
		driver.findElementById("username").sendKeys("dhivya@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();

		Thread.sleep(10000);
		
//		Click SVG Icon
		WebElement svg = driver.findElementByXPath("//div[@class='slds-global-header__item']//li[4]//a");
		svg.sendKeys(Keys.ENTER);
		
//		Click New Opportunity and maximize it
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@title='New Opportunity']").click();
		System.out.println("New Opportunity is clicked Successfully");
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@data-key='expand_alt']").click();
		System.out.println("Opportunity is maximized");
		//
		
		/*Actions builder = new Actions(driver);
		builder.click(driver.findElementByXPath("//a[@title='New Event']"));
		Thread.sleep(2000);
		builder.click(driver.findElement(By.xpath("//button[@title='Maximize']"))).perform();*/
		
		//Enter Opportunity name
		driver.findElementByXPath("(//input[@class=' input'])[1]")
													.sendKeys("On site");
		System.out.println("Opportunity name is entered");
		
		//Click on Stage option
		driver.findElementByXPath("//span[text()='Stage']/../following-sibling::div").click();
		System.out.println("Stage Dropdown option is clicked");
		
		//Choose Option as prospect
		driver.findElementByXPath("//a[@title='Prospecting']").click();
		System.out.println("Prospecting is selected");
		
		driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		
		Thread.sleep(5000);
		
		driver.close();
		
	}



	}


