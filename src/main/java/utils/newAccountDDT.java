package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameterized;

//DDT framework with Junit
@RunWith(value = Parameterized.class)
public class newAccountDDT {
	
	//Local parameterization
	String name, email, phone, gender, password, country;
	boolean weekly, monthly, occasionalMail;
	WebElement nameElement, emailElement, phoneNumberElement, passwordElement, verifyPasswordElement, 
	countryElement,	dailyEmaeilElement, monthlyEmailElement, occasionalEmailElement, maleRadioBt, femaleRadioBt, 
	submitButton;
	
	public static String filename = "C:\\Selenium\\UserAccounts.csv";
	WebDriver driver;
	
	@Before
	public void setup() {
		String browserType = "chrome";
		driver = utilities.driverFactory.openBrowser(browserType);
		System.out.println("Browser was opened");
		String title = "SDET Training | Account Management";
		System.out.println("Open account page");
		driver = utilities.openPage.openP(driver, title);	
	}
	
	//This is our test method
	@Test
	public void newAccountTest() {
//		//parameters get here
//		if (name.contains("Michael")) {
			System.out.println("Record: " + name + " " + email + " " + phone + " " 
		+ gender + " " + password + " " + country + " " + weekly + " " + " " + monthly + " " + occasionalMail);	
			Assert.assertTrue("Record exist", true);
	//}
						
			//3. Open new account page
			String buttonLink = driver.findElement(By.xpath("//a[@class='btn btn-default']")).getText();
			if (buttonLink.equalsIgnoreCase("Create Account")) {
				System.out.println("Redirecting to Create Account page successfully");
					driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[2]/a[1]")).click();
			} else {
				System.err.println("Error: no link to New Account Creating page");
			}
			
			//4. Checking page visibility
			String verificationText = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]")).getText();
			if (verificationText.equalsIgnoreCase("Create a New Account")) {
				System.out.println("Page: [Create a New Account] opened successfully");
			} else {
				System.err.println("Error: Page Create New Account not available");
			}
					
			//Web elements defining method
			defineWebElements();
			nameElement.sendKeys(name);
			emailElement.sendKeys(email);
			phoneNumberElement.sendKeys(phone);
			passwordElement.sendKeys(password);
			verifyPasswordElement.sendKeys(password);
			new Select(countryElement).selectByVisibleText(country);
			
			//Weekly notification - check boxes
			if (weekly) {
				if (!dailyEmaeilElement.isSelected()) {
					dailyEmaeilElement.click();
						System.out.println("Weekly emails notifications has been selected");
				}
			} else {
				dailyEmaeilElement.isSelected(); 
					dailyEmaeilElement.click();
						System.out.println("Weekly emails notifications has been deselected");
			}
			
			//Monthly notification
			if (monthly) {
				if (!monthlyEmailElement.isSelected()) {
					monthlyEmailElement.click();
						System.out.println("Monthly emails notifications has been selected");
				}
			} else {
				 monthlyEmailElement.isSelected();
					monthlyEmailElement.click();
						System.out.println("Monthly emails notifications has been deselected");
			}
			
			//Occasional notification
			if (occasionalMail) {
				if (!monthlyEmailElement.isSelected()) {
					monthlyEmailElement.click();
						System.out.println("Occasaional emails notifications has been selected");
				}
			} else {
				occasionalEmailElement.isSelected();
					occasionalEmailElement.click();
						System.out.println("Occasaional emails notifications has been deselected");
			}
			
				
			if (gender.equalsIgnoreCase("Male")) {
				maleRadioBt.click();
					System.out.println("Male gender was defined");
			} else if(gender.equalsIgnoreCase("Female")) {
				femaleRadioBt.click();
					System.out.println("Female gender was defined");
			} else {
					System.err.println("Error: No gender type inputed");
			}
					
			//submitting data to DB
			submitButton.click();
			
			//Confirmation message and close driver/browser
			String success = "successfully";
			String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
			if (confirmation.contains(success)) {
				System.out.println("Confirmation goes fine: " + confirmation);
			} else {
				System.err.println("Error: New customer don't created. Some fields should to be filled");
			}

	
	}
	
	//Defined web elements
	public void defineWebElements() {
		nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		emailElement = driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		phoneNumberElement = driver.findElement(By.name("ctl00$MainContent$txtHomePhone"));
		passwordElement = driver.findElement(By.name("ctl00$MainContent$txtPassword"));
		verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		dailyEmaeilElement = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		monthlyEmailElement= driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		occasionalEmailElement= driver.findElement(By.xpath("//input[@id='MainContent_checkUpdates']"));	
		maleRadioBt = driver.findElement(By.id("MainContent_Male"));
		femaleRadioBt = driver.findElement(By.id("MainContent_Female"));
		submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
	}
	
	//This method send class parameters to CSV Reader class via Constructor
	@Parameters
	public static List<String[]> getData() {
		return utilities.csvImport.read(filename);
	}

	//Constructor that passed parameters to the Test method. Global parametrization
	public newAccountDDT(String name, String email, String phone, String gender, 
			String password, String country, 
			String weekly, String monthly, String occasionalMail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		
		if (weekly.equals("TRUE")) {
			this.weekly = true;
		} else {
			this.weekly = false;	
		}
				
		if (monthly.equals("TRUE")) {
			this.monthly = true;
		} else {
			this.monthly = false;
		}
		
		if (occasionalMail.equals("TRUE")) {
			this.occasionalMail = true;
		} else {
			this.occasionalMail = false;
		}
	}
	
	//7. Close browser window
		@After
		public void closse() {
		driver.close();
		driver.quit();
		}
}
 