package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.confirmationPage;
import pages.loginPage;

public class loginFramework {
	
	WebDriver driver;
	loginPage loginpage = new loginPage(driver);
	confirmationPage confirmationpage = new confirmationPage(driver);
	closeUtil exitutil = new closeUtil(driver);
	
	
	@BeforeMethod
	public void setup() {
		String browserType = "chrome";
		driver = utilities.driverFactory.openBrowser(browserType);
		System.out.println("\nBrowser was opened\n");
		String title = "SDET Training | Account Management";
		driver = utilities.openPage.openP(driver, title);	
		System.out.println("\nOpen account page\n");
	}

	
	//2. Enter Login information (Login Page)
	@Test(dataProvider = "getData")
	public void loginTestPom(String name, String email, String pass) {
		
		loginpage.visibility(name, email, pass);
		
		loginpage.setEmail(email);
		loginpage.setPass(pass);
		loginpage.clickSubmit();
				
	
		String success = confirmationpage.confirm();
		String title = confirmationpage.title();
		Assert.assertTrue(success.equalsIgnoreCase("Logged in successfully"));
		Assert.assertTrue(title.contains("Account"));
		
		confirmationpage.changePass();
	}
	
	
	//4. Close driver
	@AfterMethod
	public void close() {
		exitutil.exit();
	}
		
	@DataProvider
	public String [][] getData() {
		return utilities.ExcelReader.getXLS("C:\\Selenium\\UserLogin.xls");
		
	}	
}
