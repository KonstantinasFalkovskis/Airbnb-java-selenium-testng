package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import base.Base;

public class MainPage extends Base{
	
	Logger log = Logger.getLogger(MainPage.class.getName());
	
	LanguagePage langPage = new LanguagePage();
	
	//-------------------------------------------------------->
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
	//--------------------------------------------------------->
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
	//----------------------------------------------------------->
	@FindBy(xpath = "//div[@class='_e296pg']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]")
	WebElement childrenDecreaseBtn;
	
	@FindBy(xpath = "//div[@class='_e296pg']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
	WebElement childrenIncreaseBtn;
	
	//infants
	@FindBy(xpath = "//div[@class='_slilk2']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]")
	WebElement infantsDecreaseBtn;
	
	@FindBy(xpath = "//div[@class='_slilk2']//div//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//button[1]")
	WebElement infantsIncreaseBtn;

	
	//help desc screen
	//----------------------------------------------------------->
	@FindBy(xpath = "//input[@id='help-field-guide-search-input']")
	WebElement guidHelpInputField;
	
	@FindBy(xpath = "//div[@class='_eflz7d']//div//div[2]")
	WebElement backLink;
	
	@FindBy(xpath = "//a[@class='_12jvhwr']")
	WebElement giveFeedbackLink;
	
	@FindBy(xpath = "//a[@class='_6niksfg']")
	WebElement visitHelpCenterBtn;
	
	@FindBy(xpath = "//div[@class='_s1tlw0m']")
	WebElement articleHeader;
	
	
	//main elements
	//----------------------------------------------------------->
	@FindBy(xpath = "//div[@class='_luvunc']//button[@class='_111s5i9']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//button[@class='_98kere2']")
	WebElement helpCloseBtn; 
	
	
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 *   -- Documentation --
	 *   Method for framework activity validation
	 */
	public void test() {
		driver.getTitle();
	}
	
	/**
	 *    -- Documentation --
	 *    Method for main menu smoke test
	 *    Main menu shall be visible
	 */
	public void mainMenu_SMOKE() {
		List<WebElement> menuArr = driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/header/div/div/div[3]/div/div/nav/ul/li"));
		for(WebElement element : menuArr) {
			if(element.isDisplayed()) {
				log.info(element.getText() + " - is visible on Main Page");
				System.out.println(element.getText() + " - is visible on Main Page");
			}
		}
	}
	
	 /**
	 *    -- Documentation --
	 *    Method for main menu smoke test
	 *    main menu shall be visible and clickable
	 */
	public void mainMenuSmoke(String menuTxt) {
		List<WebElement> menuArr = driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/header/div/div/div[3]/div/div/nav/ul/li"));
		for(int index = 0; index <= menuArr.size(); index++) {
			WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/header/div/div/div[3]/div/div/nav/ul/li[" + index +"]"));
			if(index <= 2) {
				element.click();
				log.info(element.getText());
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
	
	/**
	 * -- Documentation --
	 * 1. Method for helpful articles finding
	 *    by given word or sentence
	 * 2. Validate article header
	 * @param article
	 */
	public void helpDescArticlesList(String article) {
		List<WebElement> articlesArr = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/section[1]/div"));
		for (WebElement element : articlesArr) {
			if(element.getText().equals(article)) {
				element.click();
				log.debug(article + " -> is clickable");
				Assert.assertEquals(articleHeader.getText(), article);
				log.info(article + " - is visible");
			}
		}
	}
	

			
}
