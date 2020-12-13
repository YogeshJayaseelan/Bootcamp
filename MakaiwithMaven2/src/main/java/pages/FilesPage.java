package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class FilesPage extends PreAndPost{
	
	public FilesPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	
	public FilesPage clickUploadFile(){
	Actions builder = new Actions(driver);
	WebElement uploadButton = driver.findElement(By.xpath("//div[text()='Upload Files']"));
	builder.moveToElement(uploadButton).click().perform();		
	System.out.println("Upload File button is clicked");
	return this;
	}
	
	
	public FilesPage UploadFileRobot() throws InterruptedException, AWTException{
	Thread.sleep(10000);
	StringSelection stringSelection = new StringSelection("D:\\Excel\\OppTest.xlsx");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	// Paste it using Robot class
	Robot robot = new Robot();
	// Enter to confirm it is uploaded
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("Filepath is selected File button is clicked");	
	Thread.sleep(5000);
	// finish download
	Actions builder = new Actions(driver);
	WebElement doneClick = driver.findElement(By.xpath("//span[text()='Done']"));
	builder.moveToElement(doneClick).click().perform();
	return this;
	}
	

	public FilesPage clickOnDropDownOnNewlyAddedFile() throws InterruptedException {
	Thread.sleep(3000);
	click(locateElement("xpath", "//div[@data-aura-class='forceVirtualAction']/a"));
	System.out.println("Click Dropdown on the newly added file");
	return this;
	}
	
	public FilesPage clickViewDetails() throws InterruptedException {
	Thread.sleep(3000);
	click(locateElement("xpath", "//a[@title='View File Details']"));
	System.out.println("View details Option is clicked");
	return this;
	}
	
	public FilesPage getFilenameAndExtentsion() {
	String fileName = driver.findElement(By.xpath("//div[text()='File']/following::span")).getText();
	System.out.println(fileName);
	String fileExtension = driver.findElement(By.xpath("//span[@title='File Extension']/following::span")).getText();
	System.out.println(fileExtension);
	Assert.assertEquals(fileName, "Day3 java Questions");
	Assert.assertEquals(fileExtension, "txt");
	System.out.println("Filename and extension is captured");
	return this;
	}
	
	public FilesPage closetheFileWindow()  {
	click(locateElement("xpath", "//div[@class='close slds-col--bump-left slds-p-left--none slds-context-bar__icon-action ']"));
	System.out.println("File window is closed");
	return this;
	}
	
	public FilePopUpPage clickonLastModifiedFile()  {
	click(locateElement("xpath", "(//div[@class='slds-truncate']//span)[1]"));
	System.out.println("Last Modified file is clicked");
	return new FilePopUpPage(driver,test);
	}
	
	public FilesPage chooseDeleteOption()  {
	click(locateElement("xpath", "//a[@title='Delete']"));
	System.out.println("Delete Option is choosed");
	return this;
	}
	

	public FilesPage confirmDelete()  {
	click(locateElement("xpath", "//span[text()='Delete']"));
	System.out.println("Delete is confirmed");
	return this;
	}
			

	public FilesPage verifyDeletionMessage() throws InterruptedException  {
	Thread.sleep(3000);
	String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
	System.out.println(text);
	return this;
	}	
	
	
			
}
