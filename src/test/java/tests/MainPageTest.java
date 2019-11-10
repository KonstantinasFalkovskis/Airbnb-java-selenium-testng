package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Base;
import pages.MainPage;

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
		mainPage.sendtext();
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
	 */
	@Test(priority = 4, enabled = true, groups = {"regression", "mainPage_search_regression"}, dataProvider = "getData")
	public void mainPageSearchModuleTest_REGRESSION(String place, WebElement table, String date, String adults, String childrens, String infants) {
		mainPage = new MainPage();
		mainPage.mainPageSearchModul_REGRESSION(place, table, date, adults, childrens, infants);
	}
	
	
}