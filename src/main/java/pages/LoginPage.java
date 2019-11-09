package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LoginPage extends Base {

	//1st Log in screen
	//---------------------------------------------->
	@FindBy(xpath = "//button[@class='_1rp5252']")
	WebElement closeBtn;
	
	@FindBy(id = "email-login-email")
	WebElement username;
	
	@FindBy(id = "email-login-password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='_1o4htsfg']//span[contains(text(), 'Log in')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Forgot password?')]")
	WebElement forgotPasswordLink;
	
	//2nd Reset password screen
	//----------------------------------------------->
	@FindBy(xpath = "//div[@class='_s1tlw0m']//div[contains(text(), 'Reset password')]")
	WebElement resetPasswordHeader;
	
	@FindBy(id = "forgot-password-email")
	WebElement forgottenEmailInputField;
	
	@FindBy(xpath = "//div[contains(text(),'Back to Login')]")
	WebElement goBackLink;
	
	@FindBy(xpath = "//button[@class='_1vs0x720']//span[contains(text(), 'Send reset link')]")
	WebElement resendPasswordBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
}
