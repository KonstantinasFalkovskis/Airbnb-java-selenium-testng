package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class MainPage extends BaseTest{
	
	Logger log = Logger.getLogger(MainPage.class.getName());
	
	
	
	By logo = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[1]/div[1]/"
			+ "div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/*");
	By boolTxt = By.xpath("/html/body/div[3]/div/main/section/div/div/div[1]/div/div/div/div/div/div[1]/h1");
	By where = By.id("Koan-magic-carpet-koan-search-bar__input");
	By checkin_input = By.id("checkin_input");
	By checkout_input = By.id("checkout_input");
	By guests = By.id("lp-guestpicker");
	By facebook = By.xpath("//div[@class='_jro6t0'][contains(.,'Log in with Facebook')]");
	
	
	//sign up frame
	@FindBy(xpath ="//span[@class='_ftj2sg4']//div[@class='_jro6t0']")
	WebElement signWithEmail;	
	
	@FindBy(id = "email-signup-email")
	WebElement email;
	
	@FindBy(id = "email-signup-user[first_name]")
	WebElement firstName;
	
	@FindBy(id = "email-signup-user[last_name]")
	WebElement lastName;
	
	@FindBy(id = "email-signup-password")
	WebElement password;
	
	
	
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void mainMenu(String menuName) {
		List<WebElement> loginArr = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/ul[1]/li"));
		System.out.println(loginArr.size());
		for(int i=0; i<loginArr.size(); i++){
			System.out.println(loginArr.get(i).getText());
			if(loginArr.get(i).getText().equals(menuName)){
				loginArr.get(i).click();
				break;
			}
		  }
		}
		
	public void signTabMenu() {
		List<WebElement> signArr = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/ul[1]/li"));
		System.out.println(signArr.size());
		for(WebElement element : signArr){
			System.out.println(element.getText());
			if(element.getText().equals(prop.getProperty("sign"))){
				element.click();
				break;
			}
		  }
		}
	public void signUpWithEmail() {
		signWithEmail.click();
		
		
	}
	
	}
	 
	
	


