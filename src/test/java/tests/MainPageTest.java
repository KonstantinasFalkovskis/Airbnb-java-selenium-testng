package tests;

import java.util.logging.Logger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.MainPage;
import utils.Util;

public class MainPageTest extends BaseTest{

	MainPage mainPage;

	String menu_sheet = "menu";
	
		Logger log = Logger.getLogger(MainPageTest.class.getName());

		
		@Test(priority = 1, enabled = true, dataProvider = "getMenuData")
		public void mainMenuTest(String menuName) {
			mainPage = new MainPage();
			mainPage.mainMenu(menuName);
		}
		
		@DataProvider
		public Object [][] getMenuData() {
			
			Object data_menu [][] = Util.getTestData(menu_sheet);
			return data_menu;
		}
	
	
}
