package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class AppLauncherPage extends PreAndPost{
	
	public AppLauncherPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	public ServiceConsolePage clickServiceConsole() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement("xpath", "//p[text()='Service Console']"));
		System.out.println("Service Console App is clicked");
		return new ServiceConsolePage(driver, test);
	}
}
