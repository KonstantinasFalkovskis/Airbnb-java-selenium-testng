package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class MainPage extends BasePage{
	
	Logger log = Logger.getLogger(MainPage.class.getName());
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
//	By username = By.name("username");
//	By password = By.name("password");
//	By loginButton = By.xpath("//input[contains(@value,'Login')]");
	
	By logo = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[1]/div[1]/"
			+ "div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/*");
	By boolTxt = By.xpath("/html/body/div[3]/div/main/section/div/div/div[1]/div/div/div/div/div/div[1]/h1");
	By where = By.id("Koan-magic-carpet-koan-search-bar__input");
	By checkin_input = By.id("checkin_input");
	By checkout_input = By.id("checkout_input");
	By guests = By.id("lp-guestpicker");
	By facebook = By.xpath("//div[@class='_jro6t0'][contains(.,'Log in with Facebook')]");
	
	public String getMainPageTitle() {
		return getPageTitle();
	}
	
	
	
	public WebElement PageLogo() {
		return getElement(logo);
	}
	
	public boolean getMainPageLogo() {
		return PageLogo().isDisplayed();
	}
	
	public HomePage loginMethod(String uname, String pwd) {
		//getUsername().sendKeys(uname);
		//getPassword().sendKeys(pwd);
		try {
			Thread.sleep(6000);
		//	getLoginButton();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.fatal("Excepption occured");
		}
		log.info("Login successful");
		return getInstance(HomePage.class);
	}
	
	

}
