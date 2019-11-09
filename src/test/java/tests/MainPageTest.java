package tests;

import org.testng.annotations.Test;

import base.Base;
import pages.MainPage;

public class MainPageTest extends Base{
	
	MainPage mainPage;
	
	@Test
	public void firstTest() {
		mainPage = new MainPage();
		System.out.println(mainPage.pageTitle());
	}

}
