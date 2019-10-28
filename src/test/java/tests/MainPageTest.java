package tests;

import org.testng.annotations.BeforeMethod;

import base.BaseTest;
import pages.MainPage;

public class MainPageTest extends BaseTest{

	MainPage mainPage;
	
	
	public MainPageTest() {
		super();
	}
	
	@BeforeMethod
	public void testSetUp() {
		initialization();
		mainPage = new MainPage();
	}
	
	
}
