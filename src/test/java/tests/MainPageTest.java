package tests;

import org.testng.annotations.Test;

import base.Base;
import pages.MainPage;

public class MainPageTest extends Base{
	
	MainPage mainPage = new MainPage();
	
	/**
	 *  -- Documentation --
	 *  Pre-test method for framework activity validation
	 */
	@Test(priority = 1, enabled = false)
	public void mainPageTest() {
		mainPage.test();
	}
	
	/**
	 *   -- Documentation --
	 *   Test for Main Page main menu smoke test
	 */
	@Test(priority = 1, enabled = true, groups = {"smoke","mainPage_menu"})
	public void mainMenuTest_SMOKE() {
		mainPage.mainMenu_SMOKE();
	}
	

}
