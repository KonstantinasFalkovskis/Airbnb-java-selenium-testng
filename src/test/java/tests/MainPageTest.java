/**
 * Test class
 */
package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.MainPage;
import utils.Util;

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
	
	@Test(priority = 5, enabled = false, groups = {"regression", "mainPage_test_regression"}, dataProvider = "getTestData")
	public void test(String smb) {
		mainPage = new MainPage();
		mainPage.sendtext(smb);
	}
	//---------------------------------------------------->
	
	/**
	 *            -- Documentation --
	 *   Test for Main Page main menu smoke test
	 */
	@Test(priority = 1, enabled = true, groups = {"smoke","mainPage_menu_smoke"})
	public void mainPageMenuTest_SMOKE() {
		mainPage = new MainPage();
		mainPage.mainMenu_SMOKE();
	}
	
	/**
	 *            -- Documentation --
	 *   Test for Main Page search module smoke test
	 */
	@Test(priority = 2, enabled = true, groups = {"smoke","mainPage_search_smoke"})
	public void mainPageStaysSearchTest_SMOKE() {
		mainPage = new MainPage();
		mainPage.search_SMOKE();
	}
	
	/**
	 *            -- Documentation --
	 *   Test for Main Page main menu functional test
	 */
	@Test(priority = 3, enabled = true, groups = {"functional","mainPage_menu_functional"})
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
	@Test(priority = 4, enabled = true, groups = {"regression", "mainPage_search_regression"}, dataProvider = "getTestData")
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