package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class MainPage extends BaseTest{
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/*")
	WebElement logo;
	
	@FindBy(xpath = "/html/body/div[3]/div/main/section/div/div/div[1]/div/div/div/div/div/div[1]/h1")
	WebElement boolTxt;
	
	@FindBy(id = "Koan-magic-carpet-koan-search-bar__input")
	WebElement where;
	
	@FindBy(id = "checkin_input")
	WebElement checkin_input;
	
	@FindBy(id = "checkout_input")
	WebElement checkout_input;
	
	@FindBy(id = "lp-guestpicker")
	WebElement guests;
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean checkLogo() {
		boolean logoIsVisible = logo.isDisplayed();
		Assert.assertTrue(logoIsVisible);
		return logoIsVisible;
	}
	
	

}
