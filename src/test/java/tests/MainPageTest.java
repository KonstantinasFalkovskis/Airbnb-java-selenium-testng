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
		
	@Test(priority = 1, enabled = true, groups = {"mainPageSmoke"}, description = "Verifying main page menu")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description : verifying menu on the Main Page")
	@Story("Story name: To check main page main menu functionality on the top of main page")
	public void mainPageMenuTestSmoke() {
		log.info("-- MainPage menu smoke test starts --");
		mainPage = new MainPage();
		mainPage.mainMenuSmoke();
	}
	
	@Test(priority = 2, enabled = true, groups = {"mainPageSmoke"}, description = "Verifying main page search")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying search visibility on the Main Page")
	@Story("Story name: To check search module visibility of the main page")
	public void mainPageStaysSearchTestSmoke() {
		log.info("-- MainPage search module smoke test starts --");
		mainPage = new MainPage();
		mainPage.searchSmoke();
	}
	
	@Test(priority = 3, enabled = true, groups = {"mainPageFunc"})
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying search functionality on the Main Page")
	@Story("Story name: To check search module functionality of the main page")
	public void mainPageMenuTestFunctional() {
		log.info("-- MainPage functionsl test starts --");
		mainPage = new MainPage();
		mainPage.mainMenuFunctional();
	}
	
	@Test(priority = 4, enabled = true, groups = {"mainPageRegression"}, dataProvider = "getTestData")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case description: verifying search function on the Main Page")
	@Story("Story name: To check search functionality of the main page")
	public void mainPageSearchModuleTestRegression(String shortname, String destination, String checkin, String checkout) {
		log.info("-- MainPage regression test starts --");
		mainPage = new MainPage();
		mainPage.mainPageSearchModulRegression(shortname, destination, checkin, checkout);
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