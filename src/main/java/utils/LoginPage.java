package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LoginPage extends Base{
	
	LoginPage loginPage;
	UserPage userPage;
	
	@FindBy(id = "MainContent_txtUserName")
	WebElement username;
	
	@FindBy(name = "ctl00$MainContent$txtPassword")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='MainContent_btnLogin']")
    WebElement loginBt; 
	
	@FindBy(xpath = "//a[contains(text(), 'Create Account')]")
	WebElement createAccount;
	
	
	
	//constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public UserPage loginTest(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBt.click();
		return new UserPage();
	}
	
	public CreateAccount createacc() {
		createAccount.click();
		return new CreateAccount();
	}
	
	
	
}
