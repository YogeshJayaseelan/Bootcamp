package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class FilePopUpPage extends PreAndPost{
	
	public FilePopUpPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public FilePopUpPage clickShare()  {
	click(locateElement("xpath", "//button[@title='Share']"));
	System.out.println("Share Option is Clicked");
	return this;
	}
	
	public FilePopUpPage clickShareUser() {
	click(locateElement("xpath", "//input[@title='Search People']"));
	System.out.println("Share user Option is Clicked");
	return this;
	}
	
	public FilePopUpPage chooseDerrick() {
	click(locateElement("xpath", "//div[text()='Derrick Dsouza']"));
	System.out.println("Derrick is clicked");
	return this;
	}

	public FilePopUpPage verifyError() {
	String errorMessage = driver.findElement(By.xpath("//li[@class='form-element__help']")).getText();
	Assert.assertEquals(errorMessage, "Can't share file with the file owner.");
	System.out.println("Error message is captured");
	return this;
	}
	
	public FilePopUpPage clickCancel() {
	click(locateElement("xpath", "(//span[text()='Cancel'])[2]"));
	System.out.println("Cancel button is clicked");
	return this;
	}

	public FilesPage closetheDialog() {
	click(locateElement("xpath", "//button[@title='Close']"));
	System.out.println("Share Dialog is closed");
	return new FilesPage(driver, test);
	}

	
	
}
