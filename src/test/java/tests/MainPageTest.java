package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.MainPage;
import utils.Util;

public class MainPageTest extends BaseTest{

	MainPage mainPage;

	String sheetName = "users";
	
	//LoginPage loginPage = page.getInstance(LoginPage.class);
	
		Logger log = Logger.getLogger(MainPageTest.class.getName());
	
//	@BeforeMethod
//	@Parameters({"browserName"})
//	public void testSetUp(String browserName) throws InterruptedException {
//		initialization(browserName);
//		mainPage = new MainPage();
//	}
//	
//	@Test(priority = 1, enabled = true)
//	public void checkLogoTest() {
//		mainPage.checkLogo();
//	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
		

		
		
		@Test(priority = 1, enabled = false)
		public void testLoginPageTitle() {
			String mainPageTitle = page.getInstance(MainPage.class).getMainPageTitle();
			log.info("Login page title " + mainPageTitle);
			Assert.assertEquals(mainPageTitle, prop.getProperty("loginPageTitle"));
		}
		
		@Test(priority = 2, enabled = true)
		public void testLoginPageLogo() {
			boolean mainPageLogo = page.getInstance(MainPage.class).getMainPageLogo();
			log.info("Login page logo is displaying");
			Assert.assertTrue(mainPageLogo);
		}
		
		@Test(priority = 3, enabled = false, dataProvider = "getTestData")
		public void verifyUserLogin(String username, String password) throws IOException  {
			
			HomePage homePage = page.getInstance(MainPage.class).loginMethod(username, password);
			String homePageTitle =  homePage.getHomePageTitle();
			log.info("Home page title " + homePageTitle);
			Assert.assertEquals(homePageTitle, prop.getProperty("homePageTitle"));
			
		}
		
		@DataProvider
		public Object [][] getTestData() {
			Object data [][] = Util.getTestData(sheetName);
			return data;
		}
	
	
}
