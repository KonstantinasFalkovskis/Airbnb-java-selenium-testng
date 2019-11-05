package pages;

import java.time.Year;
import java.util.List;

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
	
	By logo = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[1]/div[1]/"
			+ "div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/*");
	By boolTxt = By.xpath("/html/body/div[3]/div/main/section/div/div/div[1]/div/div/div/div/div/div[1]/h1");
	By where = By.id("Koan-magic-carpet-koan-search-bar__input");
	By checkin_input = By.id("checkin_input");
	By checkout_input = By.id("checkout_input");
	By guests = By.id("lp-guestpicker");
	By facebook = By.xpath("//div[@class='_jro6t0'][contains(.,'Log in with Facebook')]");
	
	//login frame
	By emailForLogin = By.xpath("//input[@id='email-login-email']");
	By passwordForLogin = By.xpath("//input[@id='email-login-password']");
	By loginBtn = By.xpath("//button[@class= '1o4htsfg']");
	
	//sign up frame
	By signWithEmail = By.xpath("//span[@class='_ftj2sg4']//div[@class='_jro6t0']");
	By emailForSignUp = By.id("email-signup-email"); 
	By firstName = By.id("email-signup-user[first_name]");
	By lastName = By.id("email-signup-user[last_name]");
	By passwordForSignUp = By.id("email-signup-password");
	By month = By.id("email-signupuser[birthday_month]");
	By day = By.id("email-signupuser[birthday_day]");
	By year = By.id("email-signupuser[birthday_year]");
	By signBtn = By.xpath("//span[contains(text(),'Sign up')]");
	
	
	//Getters - Setters
	public String getMainPageTitle() {
		return getPageTitle();
	}
	
	public WebElement PageLogo() {
		return getElement(logo);
	}
	
	public WebElement getLoginEmail() {
		return getElement(emailForLogin);
	}
	
	public WebElement getLoginPassword() {
		return getElement(passwordForLogin);
	}
	
//	public WebElement getSignUpEmail() {
//		return getElement(emailForSignUp);
//	}
//	
//	public WebElement getFirstName() {
//		return getElement(firstName);
//	}
//	
//	public WebElement getLastName() {
//		return getElement(lastName);
//	}
//	
//	public WebElement getPasswordForSignUp() {
//		return getElement(passwordForSignUp);
//	}
//	
//	public WebElement getMonth() {
//		return getElement(month);
//	}
//	
//	public WebElement getDay() {
//		return getElement(day);
//	}
//	
//	public WebElement getYear() {
//		return getElement(year);
//	}
//	
//	public WebElement getSignBtn() {
//		return getElement(signBtn);
//	}
	
	
	//Actions
	
	public boolean getMainPageLogo() {
		return PageLogo().isDisplayed();
	}
	
	public HomePage loginMethod(String user, String pwd) {
		getElement(emailForLogin).sendKeys(user);
		getElement(passwordForLogin).sendKeys(pwd);
		getElement(loginBtn);
		return getInstance(HomePage.class);
	}
	
	
	
	public void mainMenu(String menuElement) {
		
		List<WebElement> menuArr = driver.findElements(By.xpath("//div[@class='_uec4nrl']//li"));
		
		for (WebElement element : menuArr) {
			if(element.equals(menuElement)){
				element.click();
				
			}
		}
		
	}
	
	
	public void selectMonth(String month) {
		List<WebElement> monthArr = driver.findElements(By.xpath("//*[@id='email-signupuser[birthday_month]']/option"));
		
		for(WebElement element : monthArr) {
			if(element.equals(month)) {
				element.click();
			}
		}
	}

	public MainPage creatNewUser(String email, String name, String surename, String pwd, String mm,
			String dd, String yy) {
		getElement(emailForSignUp).sendKeys(email);
		getElement(firstName).sendKeys(name);
		getElement(lastName).sendKeys(surename);
		getElement(passwordForSignUp).sendKeys(pwd);
		getElement(month).sendKeys(mm);
		getElement(day).sendKeys(dd);
		getElement(year).sendKeys(yy);
		return null;
	}
	
	

}
