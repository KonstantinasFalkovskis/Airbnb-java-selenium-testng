package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
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
