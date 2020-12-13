package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ServiceConsolePage extends PreAndPost{
	
	public ServiceConsolePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public ServiceConsolePage clickOnDropDown() throws InterruptedException {
	Thread.sleep(5000);
	click(locateElement("xpath", "//button[@title='Show Navigation Menu']"));
	System.out.println("Dropdown is clicked Successfully");
	return this;
	}
	
	
	public FilesPage chooseFileOption()  {
	click(locateElement("xpath", "//span[text()='Files']"));
	System.out.println("File optio is selected");
	return new FilesPage(driver, test);
	}
	
	
	
}
