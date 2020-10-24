package week4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCommunityContact {

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
				driver.findElementByXPath("//p[text()='Community']").click();
				System.out.println("Sale app is launched Successfully");
				
				//Click on Contacts(use Java Script executer if normal selenium click doesnt work)		
				WebElement Contacts = driver.findElement(By.xpath("(//a[@Title='Contacts'])"));      
				String javascript = "arguments[0].click()";      
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
				jsExecutor.executeScript(javascript, Contacts);
				
				//Click on new contact option
				driver.findElementByXPath("//div[contains(text(),'New')]").click();
				System.out.println("New button is clicked");
				
				//click on saluation dorpdown
				driver.findElementByXPath("(//a[@class='select'])[1]").click();
				System.out.println("Salutation dropdown is selected");
				
				//Select saluation as Mr
				driver.findElementByXPath("//a[@title='Mr.']").click();
				System.out.println("Salutation is selected as MR");
				
				//Type name as jamie
				driver.findElementByXPath("//span[contains(text(),'First Name')]/parent::label/following-sibling::input").sendKeys("Jamie");
				System.out.println("contact firstname is typed as jamie");
				
				//Type last name as foxx
				Thread.sleep(2000);
				driver.findElementByXPath("//span[contains(text(),'Last Name')]/parent::label/following-sibling::input").sendKeys("foxx");
				System.out.println("contact lastname is typed as foxx");
				
				//Click on Search account filed
				driver.findElementByXPath("//input[@title='Search Accounts']").click();
				System.out.println("Search account filed is clicked");
				
				//select the first resulting account 
				Thread.sleep(2000);
				driver.findElementByXPath("(//ul[@class='lookup__list  visible']/li/a/div/span/img)[1]").click();
				System.out.println("First resulting account is selected");
				
				//Type title
				driver.findElementByXPath("//span[contains(text(),'Title')]/parent::label/following-sibling::input").sendKeys("Business Analyst");
				System.out.println("Title is typed as Business Analyst");
				
				//Type Phone Number
				driver.findElementByXPath("//span[contains(text(),'Phone')]/parent::label/following-sibling::input").sendKeys("9952563100");
				System.out.println("Phone Number is Typed");
				
				//Type Email
				driver.findElementByXPath("//span[contains(text(),'Email')]/parent::label/following-sibling::input").sendKeys("Yogikingston57it@gmail.com");
				System.out.println("Email is Typed");
				
				//Click on Save button
				driver.findElementByXPath("(//span[contains(text(),'Save')])[3]").click();
				System.out.println("contact is saved successfully");
				
			/*	//verify contact is created by capturing the message
				String Conactcreated = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']").getText();
				System.out.println(Conactcreated);
				
				//Store message in variable
				 String expect="Contact \"Jamie foxx\" was created.";

				// Verify error message
			    Assert.assertEquals(Conactcreated, expect , "Message Doesnt Not Match");*/
			    
			    //click on new button under opportunities
			    Thread.sleep(1000);
			    WebElement newOpportunity = driver.findElement(By.xpath("(//div[@title='New'])[2]"));      
				String javascript1 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;        
				jsExecutor1.executeScript(javascript1, newOpportunity);				
			    System.out.println("New button is clicked under Opportunies");
			    
			    
				//Type opportunity name
			    Thread.sleep(4000);
			    driver.findElementByXPath("//span[contains(text(),'Opportunity Name')]/parent::label/following-sibling::input").sendKeys("Jamie_15M");
			    System.out.println("Opportunity name is typed");
			    
				//Click on Search account field under opportunies
			    driver.findElementByXPath("//span[@class='deleteIcon']").click();
				driver.findElementByXPath("//input[@title='Search Accounts']").click();
				System.out.println("Search account filed is clicked");
				
				//select the first resulting account 
				Thread.sleep(2000);
				driver.findElementByXPath("(//ul[@class='lookup__list  visible']/li/a/div/span/img)[1]").click();
				System.out.println("First resulting account is selected");
				
				
			    //Click on Type drodpwon
				driver.findElementByXPath("//span[contains(text(),'Type')]/parent::span/following-sibling::div").click();
				System.out.println("Type dropdown is clicked");
				
				//14 - Choose Type as New customer
				driver.findElementByXPath("//a[@title='New Customer']").click();
				System.out.println("Step 14 -Type is choosen as new customer");
				
				//14 - Type amount
				driver.findElementByXPath("//span[contains(text(),'Amount')]/parent::label/following-sibling::input").sendKeys("35000");
			    System.out.println("Step 14- Amount is typed as 350000");
				
			    
			    //15 - seelct close date as next month 15th 
			    //click on Calendar icon
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
				System.out.println("Step 15 - Close date Calendar icon is clicked");
				
				//15 Click on Next month button
				driver.findElement(By.xpath("//a[@class='navLink nextMonth']")).click();
				System.out.println("Step 15 - Next button is clicked");
						
				//15 Choose date as 15
				driver.findElement(By.xpath("//span[text()='15']")).click();
				System.out.println("Step 15 - Date 15 is clicked");
				
				//16 Click on stage dropdown
				driver.findElementByXPath("//span[contains(text(),'Stage')]/parent::span/following-sibling::div").click();
				System.out.println("Step 16 - Type dropdown is clicked");
				
				//16 - Choose stage as proposal price quote
				driver.findElementByXPath("//a[@title='Proposal/Price Quote']").click();
				System.out.println("Step 16 - Stage is choosen as proposal price quote");
				
				//16 click on save button
				driver.findElementByXPath("(//span[contains(text(),'Save')])[2]").click();
				System.out.println("Step 16 - Opportunity is saved");
				
				//17 verfiy opportunity is created 
				String opportunitycreated = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']").getText();
				System.out.println(opportunitycreated);
				
				//17 Store message in variable
				 String expect1="Opportunity Jamie_15M was created.";

				//17 Verify error message
			   // Assert.assertEquals(opportunitycreated, expect1 , "Message Doesnt Not Match");
				
			   // 18. Click on New in Cases
			    Thread.sleep(1000);
			    WebElement newCase = driver.findElement(By.xpath("(//div[@title='New'])[3]"));      
				String javascript11 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor11 = (JavascriptExecutor) driver;        
				jsExecutor11.executeScript(javascript11, newCase);				
			    System.out.println("Step 18 - New button is clicked under cases");
			    
			   // 19. Select Contact Name as Jamie Foxx
			    //19. select Case Origin
			    driver.findElementByXPath("//span[contains(text(),'Case Origin')]/parent::span/following-sibling::div").click();
			    driver.findElementByXPath("//a[@title='Phone']").click();
			    System.out.println("Step 19 - Case origin is selected as phone");
			    
			   // 20. Status as New and Subject as Sales Report Issue and click on Save
			    Thread.sleep(4000);
			    driver.findElementByXPath("//span[contains(text(),'Subject')]/parent::label/following-sibling::input").sendKeys("Sales Report Issue");
			    System.out.println("Step 20 - Subject is typed as send quote");
			    
			    //20Click on Save button
			    driver.findElementByXPath("(//span[contains(text(),'Save')])[3]").click();
				System.out.println("Step 21 - Case is saved");
				
			    // 21. Verify the new case has created under Related Tag				
			    
			    
			   // 22. Click on New Task under Activity tag
				Thread.sleep(2000);
				WebElement newTask = driver.findElement(By.xpath("//span[contains(text(),'Create a task')]"));      
				String javascript111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor111 = (JavascriptExecutor) driver;        
				jsExecutor111.executeScript(javascript111, newTask);				
			  	System.out.println("Step 22 - New Task is clicked");
				
			  //  23. Select Subject as Send Quote
			  	Thread.sleep(2000);
			  	
				driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[2]").click();
				System.out.println("Step 23 - Subject search button is clicked");
				
				//select subject as Send quote
				driver.findElementByXPath("//span[@title='Send Quote']").click();
				System.out.println("Subject is selected as Send Quote");
				
			  //  24. Set Due Date as next month 10th date
				Thread.sleep(2000);
				WebElement DueDate = driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']"));      
				String javascript1111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor1111 = (JavascriptExecutor) driver;        
				jsExecutor1111.executeScript(javascript1111, DueDate);				
			  	System.out.println("Step 24 - Due date Calendar icon is clicked");
				
				//24 Click on Next month button
				driver.findElement(By.xpath("//a[@class='navLink nextMonth']")).click();
				System.out.println("Step 24 - Next button is clicked");
						
				//24 Choose date as 10
				driver.findElement(By.xpath("//span[text()='10']")).click();
				System.out.println("Step 24 - Date 10 is clicked");
				
			    //25. Set Name  as Jamie Foxx and Select First resulti//Click on Search account field under opportunies
				WebElement searchaccount = driver.findElement(By.xpath("//input[@title='Search Accounts']"));      
				String javascript2 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;        
				jsExecutor2.executeScript(javascript2, searchaccount);				
				System.out.println("Step 25 - Search account filed is clicked");
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)");
				
				//select the first resulting account 
				Thread.sleep(2000);
				WebElement searchaccount1 = driver.findElement(By.xpath("(//ul[@class='lookup__list  visible']/li/a/div/span/img)[1]"));      
				String javascript21 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor21 = (JavascriptExecutor) driver;        
				jsExecutor21.executeScript(javascript21, searchaccount1);					
				System.out.println("First resulting account is selected");
			    
			   //26. Select the Status as In Progress and click on Save
				WebElement statusdropdown = driver.findElement(By.xpath("//a[contains(text(),'Not Started')]"));      
				String javascript211 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor211 = (JavascriptExecutor) driver;        
				jsExecutor211.executeScript(javascript211, statusdropdown);					
				System.out.println("Step 26 - Status drop down is clicked");
				
				//26. Choose status option as inprogress
				driver.findElementByXPath("//a[@title='In Progress']").click();
				System.out.println("Status is choosen as inprogress");
				WebElement SaveButton = driver.findElement(By.xpath("(//span[contains(text(),'Save')])[4]"));      
				String javascript2111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor2111 = (JavascriptExecutor) driver;        
				jsExecutor2111.executeScript(javascript2111, SaveButton);					
				System.out.println("Step 26 - Task is saved");
			    
		/*	  //  27. Verify the Task Send Quote has created
				String taskcreated = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']").getText();
				System.out.println(taskcreated);
				
				//Store message in variable
				 String expect11="Task Send Quote was created.";

				// Verify error message
			    Assert.assertEquals(taskcreated, expect11 , "Message Doesnt Not Match");*/
				
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("window.scrollBy(0,-250)");
				
			  //  28. Click on Log a Call
			    WebElement newCall = driver.findElement(By.xpath("//span[contains(text(),'Log a Call')]"));      
				String javascript3 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;        
				jsExecutor3.executeScript(javascript3, newCall);				
			    System.out.println("Step 28 - Log a call option is clicked");
			    
			  //  29. Set Subject as Call and verify the  Name Field has set as Jamie Fox
			    
			    
			   //30. Select First resulting account in Related To field and click on Save
			    Thread.sleep(2000);
			    WebElement searchaccountCall = driver.findElement(By.xpath("//input[@title='Search Accounts']"));      
				String javascript4 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;        
				jsExecutor4.executeScript(javascript4, searchaccountCall);				
			   	System.out.println("Step 30 - Search account filed is clicked");
			   	
			   	JavascriptExecutor jse11 = (JavascriptExecutor)driver;
				jse11.executeScript("window.scrollBy(0,250)");
				
				//30 select the first resulting account 
				Thread.sleep(2000);
				WebElement searchaccount11 = driver.findElement(By.xpath("(//ul[@class='lookup__list  visible']/li/a/div/span/img)[1]"));      
				String javascript21111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor21111 = (JavascriptExecutor) driver;        
				jsExecutor21111.executeScript(javascript21111, searchaccount11);	
				System.out.println("First resulting account is selected");
				WebElement save1 = driver.findElement(By.xpath("(//span[contains(text(),'Save')])[7]"));      
				String javascript211111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor211111 = (JavascriptExecutor) driver;        
				jsExecutor211111.executeScript(javascript211111, save1);
				System.out.println("Step 30 - Call saved successfully");
				
			/*   // 31. Verify the call has created.
				String callcreated = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']").getText();
				System.out.println(callcreated);
				
				//Store message in variable
				 String expect111="Task Send Quote was created.";

				// Verify error message
			    Assert.assertEquals(callcreated, expect111 , "Message Doesnt Not Match"); */
				
				JavascriptExecutor jse111 = (JavascriptExecutor)driver;
				jse111.executeScript("window.scrollBy(0,-250)");
			   
			    //32. Click on New Event
			    WebElement newEvent = driver.findElement(By.xpath("//a[@title='New Event']"));      
				String javascript41 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor41 = (JavascriptExecutor) driver;        
				jsExecutor41.executeScript(javascript41, newEvent);		
			    System.out.println("Step 32 - New Event is Clicked");
			    
			 
			   //33. Select Subject as Meeting
			    Thread.sleep(4000);
			   driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[4]").click();
			   System.out.println("Step 33 - Subject field is clicked");
			   
			   //33. Choose subject as meeting
			   Thread.sleep(2000);
			   driver.findElementByXPath("//span[@title='Meeting']").click();
				System.out.println("Step 33 - Subject is choosen as Meeting");
			 
			   // 34. Select Start Date as following month 5 th day and Time as 11 AM
				Thread.sleep(2000);
				WebElement startDate = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));      
				String javascript11111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor11111 = (JavascriptExecutor) driver;        
				jsExecutor11111.executeScript(javascript11111, startDate);				
			  	System.out.println("Step 34 - Start date is clicked");
				
				//34 Click on Next month button
				driver.findElement(By.xpath("//*[@data-key='right']")).click();
				System.out.println("Step 34 - Next button is clicked");
						
				//34 Choose date as 5
				driver.findElement(By.xpath("(//span[text()='5'])[3]")).click();
				System.out.println("Step 34 - Date 5 is clicked");
				
				//Set start time
				Thread.sleep(2000);
				WebElement Time = driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[5]"));      
				String javascript111111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor111111 = (JavascriptExecutor) driver;        
				jsExecutor111111.executeScript(javascript111111, startDate);				
			  	System.out.println("Step 34 - Time option is clicked");
			  	
			  	//34 Choose time as 11AM
			  	Thread.sleep(2000);
			  	driver.findElementByXPath("//span[@title='11:00 AM']").click();
				System.out.println("Step 34 - Time is choosen as 11.00AM");
			    
			    //35. Select End Date as following month 15 th day and Time as 3 PM
			    Thread.sleep(2000);
				WebElement endDate = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));      
				String javascript1111111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor1111111 = (JavascriptExecutor) driver;        
				jsExecutor1111111.executeScript(javascript1111111, endDate);				
			  	System.out.println("Step 35 - End date is clicked");
				
				//35 Click on Next month button
				driver.findElement(By.xpath("//*[@data-key='right']")).click();
				System.out.println("Step 35 - Next button is clicked");
						
				//35 Choose date as 15
				driver.findElement(By.xpath("(//span[text()='15'])[2]")).click();
				System.out.println("Step 35 - End Date 15 is clicked");
				
				//35 Set End Time
				Thread.sleep(2000);
				WebElement endTime = driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[6]"));      
				String javascript11111111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor11111111 = (JavascriptExecutor) driver;        
				jsExecutor11111111.executeScript(javascript11111111, endTime);				
			  	System.out.println("Step 35 - End Time option is clicked");
			  	
			  	//35 Choose time as 3PM
			  	Thread.sleep(2000);
			  	driver.findElementByXPath("//span[@title='03:00 PM']").click();
				System.out.println("Step 35 - Time is choosen as 03:00 PM");
			    
			 //   36. Set Name  as Jamie Foxx and Select First resulting account in Related To field
				
				JavascriptExecutor jse1111 = (JavascriptExecutor)driver;
				jse1111.executeScript("window.scrollBy(0,250)");
			  //  37. Click on Save.
				driver.findElementByXPath("(//span[contains(text(),'Save')])[10]").click();
				System.out.println("Step 37 - Event is saved successfully");
				
			 //   38. Verify the Event meeting has created.
				
				JavascriptExecutor jse11111 = (JavascriptExecutor)driver;
				jse11111.executeScript("window.scrollBy(0,250)");
				
			 //   39. Click on Email
				WebElement Email = driver.findElement(By.xpath("//a[@title='Email']"));      
				String javascript411 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor411 = (JavascriptExecutor) driver;        
				jsExecutor411.executeScript(javascript411, Email);		
			    System.out.println("Step 32 - Email is Clicked");
			    
			//    40. Give Subject as Reminder
			    driver.findElementByXPath("//input[@class='standardField input']").sendKeys("Remainder");
			    System.out.println("Step 40 - Subject is typed as reminder");
			    
			  //  41. Type Reminder for Meeting in message body.
			    
			  //  42. Select First resulting account in Related To field and click on Send
			    
			    WebElement searchAccountEmail = driver.findElement(By.xpath("(//input[@title='Search Accounts'])[4]"));      
				String javascript4111 = "arguments[0].click()";      
				JavascriptExecutor jsExecutor4111 = (JavascriptExecutor) driver;        
				jsExecutor4111.executeScript(javascript4111, searchAccountEmail);				
			   	System.out.println("Step 42 - Search account filed is clicked");
			   	
			   	Thread.sleep(2000);
				driver.findElementByXPath("(//ul[@class='lookup__list  visible']/li/a/div/span/img)[1]").click();
				System.out.println("First resulting account is selected");
				
				//click on send button
				driver.findElementByXPath("//span[contains(text(),'Send')]").click();
				System.out.println("42 Send button is clicked");
				
			   // 43. Verify the Email sent to Jamis Foxx */
	}

}
