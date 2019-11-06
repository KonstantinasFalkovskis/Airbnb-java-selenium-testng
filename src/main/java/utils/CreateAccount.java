package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class CreateAccount extends Base{

	CreateAccount createAccount;
	
	public CreateAccount() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Create a New Account')]")
	WebElement accounttext;
	
	@FindBy(id = "MainContent_txtFirstName")
	WebElement name;
	
	@FindBy(name = "ctl00$MainContent$txtEmail")
	WebElement email;
	
	@FindBy(id = "MainContent_txtHomePhone")
	WebElement phone;
	
	@FindBy(id = "MainContent_Male")
	WebElement male;
	
	@FindBy(id = "MainContent_Female")
	WebElement female;
	
	@FindBy(name = "ctl00$MainContent$txtPassword")
	WebElement newPass;
	
	@FindBy(id = "MainContent_txtVerifyPassword")
	WebElement newPassConf;
	
	@FindBy(id = "MainContent_menuCountry")
	WebElement country;
	
	@FindBy(xpath = "//option[contains(text(),'prop.getProperty('country')')]")
	WebElement selectCountry;
	
	@FindBy(id = "MainContent_checkWeeklyEmail")
	WebElement weeklyEmail;
	
	@FindBy(id = "MainContent_checkMonthlyEmail")
	WebElement monthlyEmail;
	
	@FindBy(id = "MainContent_checkUpdates")
	WebElement updates;
	
	@FindBy(xpath = "//input[@id='MainContent_btnSubmit']")
	WebElement Submit;
	
	@FindBy(id = "MainContent_lblTransactionResult")
	WebElement result;
	
	//select from drop down menu list
		//new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Albania");

	public String getText() {
		return accounttext.getText();
	}
	
	//Account for male
		public CreateAccount createMaleAccount(String n, String e, String p, String pass, String newpass, String country) {
			name.sendKeys(n);
			email.sendKeys(e);
			email.sendKeys(p);
			male.click();
			newPass.sendKeys(pass);
			newPassConf.sendKeys(newpass);
			selectCountry.sendKeys(country);
			weeklyEmail.click();
			monthlyEmail.click();
			updates.click();
			Submit.click();
			return new CreateAccount();
		}

		//Account for female
		public CreateAccount createFemaleAccount(String n, String e, String p, String pass, String newpass, String country) {
			name.sendKeys(n);
			email.sendKeys(e);
			email.sendKeys(p);
			female.click();
			newPass.sendKeys(pass);
			newPassConf.sendKeys(newpass);
			selectCountry.sendKeys(country);
			weeklyEmail.click();
			monthlyEmail.click();
			updates.click();
			Submit.click();
			return new CreateAccount();
			}	
		
		public void loginresult() {
			result.getText();
		}

}
