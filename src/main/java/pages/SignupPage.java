package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class SignupPage extends Base{
	
	//1st Sign up screen
	//----------------------------------------------->
	@FindBy(xpath = "//button[@class='_1rp5252']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//a[@class='_1o4htsfg']")
	WebElement signWithEmailBtn;
	
	@FindBy(id = "email-signup-email")
	WebElement email;
	
	@FindBy(id = "email-signup-user[first_name]")
	WebElement firstName;
	
	@FindBy(id = "email-signup-user[last_name]")
	WebElement lastName;
	
	@FindBy(id = "email-signup-password")
	WebElement password;
	
	@FindBy(id = "email-signupuser[birthday_month]")
	WebElement birthMonth;
	
	@FindBy(id = "email-signupuser[birthday_day]")
	WebElement birthDay;
	
	@FindBy(id = "email-signupuser[birthday_year]")
	WebElement birthYear;
	
	@FindBy(xpath = "//button[@class='_1o4htsfg']")
	WebElement signUpBtn;
	
	//2nd Privacy police screen
	//------------------------------------------------------------------------------->
	@FindBy(xpath = "//button[@class='_72kmbi0']//span[contains(text(),'Accept')]")
	WebElement acceptBtn;
	
	@FindBy(xpath = "//button[@class='_1hvet6cu']//span[contains(text(),'Decline')")
	WebElement declineBtn;
	
	@FindBy(xpath = "//button[@class='_72kmbi0']//span[contains(text(),'Go back')]")
	WebElement goBackBtn;
	
	@FindBy(xpath = "//button[@class='_1hvet6cu']//span[contains(text(),'Cancell signup')")
	WebElement cancelSignUpBtn;
	
	@FindBy(xpath = "//div[@class='_18hrqvin']")
	WebElement cancelHeader;
	
	@FindBy(id = "commitment-feedback-20fa071a-ce67-4ae2-87b6-49d2528620a7")
	WebElement feedback;
	
	@FindBy(xpath = "//button[@class='_72kmbi0']//span[contains(text(),'Send feedback')]")
	WebElement sendFeedbackBtn;
	
	@FindBy(xpath = "//span[@class='alert-message']")
	WebElement alertMessageForFeedback;
	
	@FindBy(xpath = "//button[@class='close alert-close']")
	WebElement closeAlert;
	
	//3rd Welcome screen
	//----------------------------------------------->
	@FindBy(xpath = "//button[@class='_1l06pe9a']//span[contains(text(),'Next - 4 steps')]")
	WebElement nextBtn;
	
	
	
	
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
