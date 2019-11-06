package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.CreateAccount;
import pages.LoginPage;
import pages.UserPage;

public class CreateAccountTest extends Base {
	
	LoginPage loginPage;
	CreateAccount createAccount;
	UserPage userPage;
	
	public CreateAccountTest() {
		super();
	} 
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage();
		userPage = loginPage.loginTest(prop.getProperty("user"), prop.getProperty("pass"));

	}
	
	@Test(priority = 1)
	public void textTest() {
		String successResult = createAccount.getText();
		Assert.assertEquals(successResult, "Customer information added successfully");
	}
	
	@Test(priority = 2, dataProvider = "getData")
	public void maleAccountTest(String n, String e, String p, String pass, String newpass, String country) {
		createAccount.createMaleAccount(n, e, p, pass, newpass, country);
	}
	
	@Test(priority = 3, dataProvider = "getData")
	public void femaleAccountTest(String n, String e, String p, String pass, String newpass, String country) {
		createAccount.createFemaleAccount(n, e, p, pass, newpass, country);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public String [][] getData() {
		return utils.ExcelReader.getXLS("C:\\Selenium\\CreateUser.xls");
		
	}


}
