/**
 * Test class
 */
package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.MainPage;
import utils.TestAllureListener;
import utils.Util;


@Listeners({TestAllureListener.class})
public class MainPageTest extends Base{
	
	MainPage mainPage;
	String sheetName = "search";
	
	//--------------------------------------------------->
	/**
	 *  -- Documentation --
	 *  Pretest method for framework activity validation
	 */
	@Test(priority = 1, enabled = false)
	public void mainPageTest() {
		mainPage = new MainPage();
		mainPage.test();
	}
	
	@Test(priority = 2, enabled = false)
	public void keys() {
		mainPage = new MainPage();
		//mainPage.sendtext();
	}
	
	@Test(priority = 5, enabled = false, groups = {"regression"}, dataProvider = "getTestData")
	public void test(String smb) {
		mainPage = new MainPage();
		mainPage.sendtext(smb);
	}
	//---------------------------------------------------->
	
	/**
	 *            -- Documentation --
	 *   Test for Main Page main menu smoke test
	 */
	@Test(priority = 1, enabled = true, groups = {"mainPage_menu_smoke"}, description = "Verifying main page menu")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description : verifying menu on the Main Page")
	@Story("Story name: To check main page main menu functionality on the top of main page")
	public void mainPageMenuTest_SMOKE() {
		mainPage = new MainPage();
		mainPage.mainMenu_SMOKE();
	}
	
	/**
	 *            -- Documentation --
	 *   Test for Main Page search module smoke test
	 */
	@Test(priority = 2, enabled = true, groups = {"mainPage_search_smoke"}, description = "Verifying main page search")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying search visibility on the Main Page")
	@Story("Story name: To check search module visibility of the main page")
	public void mainPageStaysSearchTest_SMOKE() {
		mainPage = new MainPage();
		mainPage.search_SMOKE();
	}
	
	/**
	 *            -- Documentation --
	 *   Test for Main Page main menu functional test
	 */
	@Test(priority = 3, enabled = true, groups = {"mainPage_menu_functional"})
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying search functionality on the Main Page")
	@Story("Story name: To check search module functionality of the main page")
	public void mainPageMenuTest_FUNCTIONAL() {
		mainPage = new MainPage();
		mainPage.mainMenu_FUNCTIONAL();
	}
	
	/**
	 *            -- Documentation --
	 *   Test for Main Page search module regression test
	 *   Data are coming from data.xlsx file
	 * @throws InterruptedException 
	 */
	@Test(priority = 4, enabled = true, groups = {"mainPage_menu_regression"}, dataProvider = "getTestData")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case description: verifying search function on the Main Page")
	@Story("Story name: To check search functionality of the main page")
	public void mainPageSearchModuleTest_REGRESSION(String shortname, String destination, String checkin, String checkout) {
		mainPage = new MainPage();
		mainPage.mainPageSearchModul_REGRESSION(shortname, destination, checkin, checkout);
	}
	
	/**
	 * Data provider
	 * @return
	 */
	@DataProvider
	public Object [][] getTestData() {
		Object data [][] = Util.getTestData(sheetName);
		return data;
	}
}