package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class MainPage extends Base{
	
	//--------------------------------------------------------
	@FindBy(id = "Koan-magic-carpet-koan-search-bar__input")
	WebElement placeToGo;
	
	@FindBy(id = "checkin_input")
	WebElement checkinInputField;
	
	@FindBy(id = "checkout_input")
	WebElement checkoutInputField;
	
	@FindBy(id = "lp-guestpicker")
	WebElement guestPicker;
	
	@FindBy(xpath = "//button[@class='_1vs0x720']")
	WebElement searchBtn; 
	
	@FindBy(xpath = "//button[@class='_q243l6j']")
	WebElement clearBtn; 
	
	@FindBy(xpath = "//button[@class='_b0ybw8s']")
	WebElement saveBtn;
	
	
	//calendar
	//---------------------------------------------------------
	@FindBy(xpath = "//div[@class='_1h5uiygl']")
	WebElement arrowRight;
	
	@FindBy(xpath = "//div[@class='_18s8f6ik']")
	WebElement arrowLeft;
	
	//adults
	@FindBy(xpath = "//div[@class='_9cfq872']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]")
	WebElement adultsDecreaseBtn;
	
	@FindBy(xpath = "//div[@class='_9cfq872']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
	WebElement adultsIncreaseBtn;
	
	
	//childrens
	//-----------------------------------------------------------
	@FindBy(xpath = "//div[@class='_e296pg']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]")
	WebElement childrenDecreaseBtn;
	
	@FindBy(xpath = "//div[@class='_e296pg']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
	WebElement childrenIncreaseBtn;
	
	//infants
	@FindBy(xpath = "//div[@class='_slilk2']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]")
	WebElement infantsDecreaseBtn;
	
	@FindBy(xpath = "//div[@class='_slilk2']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
	WebElement infantsIncreaseBtn;

		
	
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public void mainMenu(String menuTxt) {
		List<WebElement> menuArr = driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/header/div/div/div[3]/div/div/nav/ul/li"));
		for(WebElement element : menuArr) {
			if(element.getText().equals(menuTxt)) {
				element.click();
			}
		}
	}
	
	public void whereDoYouGoing(String place) {
		List<WebElement> placesArr = driver.findElements(By.xpath("/html/body/div[3]/div/main/section/div/div/div[1]/div/div/div/div/div/div[2]/div/form/div[1]/div/div/ul/li/ul/li"));
		for(WebElement element : placesArr) {
			if(element.getText().equals(place)) {
				
			}
		}
	
	}
	
			
}
