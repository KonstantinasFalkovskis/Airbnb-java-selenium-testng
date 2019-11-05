package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.MainPage;
import utils.Util;

public class MainPageTest extends BaseTest{

//	public MainPageTest(WebDriver driver) {
//		super(driver);
//		 
//	}

	MainPage mainPage;
	HomePage homePage;

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
		
		@Test(priority = 2, enabled = false)
		public void testLoginPageLogo() {
			boolean mainPageLogo = page.getInstance(MainPage.class).getMainPageLogo();
			log.info("Login page logo is displaying");
			Assert.assertTrue(mainPageLogo);
		}
		
		@Test(priority = 4, enabled = true, dataProvider = "getUsers")
		public void testUserLogin(String username, String password) throws IOException  {
			mainPage.mainMenu(prop.getProperty("login"));
			homePage = page.getInstance(MainPage.class).loginMethod(username, password);
			String homePageTitle =  homePage.getHomePageTitle();
			log.info("Home page title " + homePageTitle);
			Assert.assertEquals(homePageTitle, prop.getProperty("homePageTitle"));
			
		}
		
		@Test(priority = 3, enabled = true, dataProvider = "getUsers")
		public <email> void testNewUser(String email, String username, String surname, String password, String mm, String dd, String yy) {
			mainPage = page.getInstance(MainPage.class).creatNewUser(email, username, surname, password, mm, dd, yy);
		}
		
		@DataProvider
		public Object [][] getUsers() {
			Object data [][] = Util.getTestData(sheetName);
			return data;
		}
	
	
}
