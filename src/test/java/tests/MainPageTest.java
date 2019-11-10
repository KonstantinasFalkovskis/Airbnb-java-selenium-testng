package tests;

import org.testng.annotations.Test;

import base.Base;
import pages.MainPage;

public class MainPageTest extends Base{
	
	MainPage mainPage;
	
	//--------------------------------------------------->
	/**
	 *  -- Documentation --
	 *  Pre-test method for framework activity validation
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
	 *   -- Documentation --
	 *   Test for Main Page main menu smoke test
	 */
	@Test(priority = 1, enabled = true, groups = {"smoke","mainPage_menu_smoke"})
	public void mainPageMenuTest_SMOKE() {
		mainPage = new MainPage();
		mainPage.mainMenu_SMOKE();
	}
	
	@Test(priority = 2, enabled = true, groups = {"smoke","mainPage_search_smoke"})
	public void mainPageStaysSearchTest_SMOKE() {
		mainPage = new MainPage();
		mainPage.search_SMOKE();
	}
	
	@Test(priority = 3, enabled = true, groups = {"functional","mainPage_menu_functional"})
	public void mainPageMenuTest_FUNCTIONAL() {
		mainPage = new MainPage();
		mainPage.mainMenu_FUNCTIONAL();
	}
	
	
}