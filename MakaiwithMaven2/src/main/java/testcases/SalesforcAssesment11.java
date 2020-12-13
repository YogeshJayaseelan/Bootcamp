package testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class SalesforcAssesment11 extends PreAndPost {
	

	@BeforeTest
	public void setData() {
		testCaseName = "Assessement 11";
		testDescription = "To Create Assessement 11";
		authors = "Yogesh";
		category = "Regression";
		nodes = "Service";
		dataSheetName ="Assessement_week11";
	}

	@Test(dataProvider="fetchData")	
	public void login(String uName , String pwd ) throws InterruptedException, AWTException {
		new pages.LoginPage(driver, test)
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll()
		.clickServiceConsole()
		.clickOnDropDown()
		.chooseFileOption()
		.clickUploadFile()
		.UploadFileRobot()
		.clickOnDropDownOnNewlyAddedFile()
		.clickViewDetails()
		.getFilenameAndExtentsion()
		.closetheFileWindow()
		.clickonLastModifiedFile()
		.clickShare()
		.clickShareUser()
		.chooseDerrick()
		.verifyError()
		.clickCancel()
		.closetheDialog()
		.clickOnDropDownOnNewlyAddedFile()
		.chooseDeleteOption()
		.confirmDelete()
		.verifyDeletionMessage();
		

		
}
}