package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import pages.UserPage;

public class LoginPageTest extends Base {
	
	LoginPage loginPage;
	UserPage userPage;
	
	public LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void start() {
		initialization();
		loginPage = new LoginPage();
	}
	
	//@Test(dataProvider = "getData", priority = 1)
	@Test(priority = 1)
	public void login() {
		userPage = loginPage.loginTest(prop.getProperty("user"), prop.getProperty("pass"));
	}
	
	@Test(priority = 2)
	public void createAccBtPush() {
			loginPage.createacc();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public String [][] getData() {
		return utils.ExcelReader.getXLS("C:\\Selenium\\UserLogin.xls");
		
	}
}
