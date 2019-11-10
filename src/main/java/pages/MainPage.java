package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;
import utils.CalendarUtils;
import utils.ClickUtils;

public class MainPage extends Base{
	
	Logger log = Logger.getLogger(MainPage.class.getName());
	
	LanguagePage langPage = new LanguagePage();
	CalendarUtils calendar = new CalendarUtils();
	ClickUtils clickUtils = new ClickUtils();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions builder = new Actions(driver);
	
	//-------------------------------------------------------->	
	@FindBy(xpath = "//input[@id='Koan-magic-carpet-koan-search-bar__input']")
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
	//---------------------------------------------------------->
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

	//Rent screen
	//---------------------------------------------------------->
	@FindBy(xpath = "//button[@class='_1o4htsfg']")
	WebElement getStarted;
	
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
	
	@FindBy(xpath = "//button[@class='_1rp5252']")
	WebElement closeBtnForLogin;
	
	@FindBy(xpath = "//button[@class='_98kere2']")
	WebElement helpCloseBtn; 
	
	
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 *          -- Documentation --
	 *   Method for framework activity validation
	 */
	public void test() {
		driver.getTitle();
	}
	
	public void sendtext() {
		placeToGo.sendKeys("NY");
	}
	
	/**
	 *         -- Documentation --
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
	 *             -- Documentation --
	 *    Method for stay places search smoke test
	 *    All elements in search module shall be visible
	 */
	public void search_SMOKE() {
		Assert.assertTrue(placeToGo.isDisplayed());
		log.info(placeToGo.getText() + " - is visible");
		System.out.println(placeToGo.getText() + " - is visible");
		Assert.assertTrue(checkinInputField.isDisplayed());
		log.info(checkinInputField.getText() + " - is visible");
		System.out.println(checkinInputField.getText() + " - is visible");
		Assert.assertTrue(checkoutInputField.isDisplayed());
		log.info(checkoutInputField.getText() + " - is visible");
		System.out.println(checkoutInputField.getText() + " - is visible");
		Assert.assertTrue(guestPicker.isDisplayed());
		log.info(guestPicker.getText() + " - is visible");
		System.out.println(guestPicker.getText() + " - is visible");
		Assert.assertTrue(searchBtn.isDisplayed());
		log.info(searchBtn.getText() + " - is visible");
		System.out.println(searchBtn.getText() + " - is visible");
	}
	
	 /**
	 *            -- Documentation --
	 *    Method for main menu functional test
	 *    Every main menu tab shall be clickable
	 *    Windows shall to have possibility to be closed
	 */
	public void mainMenu_FUNCTIONAL() {
		List<WebElement> menuArr = driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/header/div/div/div[3]/div/div/nav/ul/li"));
		for(int index = 1; index <= menuArr.size(); index++) {
			WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/header/div/div/div[3]/div/div/nav/ul/li[" + index +"]"));
			if(index <= 2) {
				element.click();
				log.info(element.getText() + " - menu element is clickable");
				System.out.println(element.getText() + " - menu element is clickable");
				closeBtn.click();
				log.info("Close is clicked. Window is closed.");
				System.out.println("Close button is clicked. Window is closed.");
			} else if(3 <= index && index <= 4) {
					element.click();
//					log.info(element.getText() + " - menu element is clickable");
//					System.out.println(element.getText() + " - menu element is clickable");
//					new WebDriverWait(driver, Util.IMPLICIT_WAIT).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(getStarted));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.history.go(-1)");
					//driver.navigate().back();
//					log.info(element.getText() + " - is closed.");
//					System.out.println(element.getText() + " - is closed.");
			} else if(index == 5) {
				element.click();
				log.info(element.getText() + " - menu element is clickable");
				System.out.println(element.getText() + " - menu element is clickable");
				helpCloseBtn.click();
				log.info("Close is clicked. Window is closed.");
				System.out.println("Close button is clicked. Window is closed.");
			} else if(index > 5) {
				element.click();
				log.info(element.getText() + " - menu element is clickable");
				System.out.println(element.getText() + " - menu element is clickable");
				closeBtnForLogin.click();
				log.info("Close is clicked. Window is closed.");
				System.out.println("Close button is clicked. Window is closed.");
			}
		}
	}
	
	
	
	
	/**
	 *                 -- Documentation --
	 * Method for stay places searching. 
	 * 1. User place the destination
	 * 2. CalendarUtil.java class is calling twice. User select check-in and check-out terms 
	 *    (check-in starts from any day of next month and check-out is defining 
	 *    for one week - 7 days)
	 * 3. Guest section will be fill-out (Adults shall be filled. Children and infants are optional)
	 * 4. Data for search module is coming from data.xlsx file search sheet
	 * @param place
	 */
	public void mainPageSearchModul_REGRESSION(String place, WebElement table, String date, String adults, String childrens, String infants) {
		placeToGo.clear();
		placeToGo.sendKeys(place);
		destination(place);
		checkinInputField.click();
		arrowRight.click();
		calendar.getTableBodyRowByText(table, date); // for check-in date defining
		calendar.getTableBodyRowByText(table, date); // for check-out date defining
		guestPicker.click();
		clickUtils.doMultiClick(adultsIncreaseBtn, adults);
		clickUtils.doMultiClick(childrenIncreaseBtn, childrens);
		clickUtils.doMultiClick(infantsIncreaseBtn, infants);
		saveBtn.click();
		searchBtn.click();
	}

	
	/**
	 *         -- Documentation --
	 * Method for destination list validation     
	 * @param place
	 */
	public void destination(String place) {
		List<WebElement> placesArr = driver.findElements(By.xpath("/html/body/div[3]/div/main/section/div/div/div[1]/div/div/div/div/div/div[2]/div/form/div[1]/div/div/ul/li/ul/li"));
		for(WebElement element : placesArr) {
			if(element.getText().equals(place)) {
				selectDestination(element);
			}
		}
	}
	
	/**
	 *            -- Documentation --
	 * Method for particular destination selecting
	 * @param element
	 */
	public void selectDestination(WebElement element) {
		//1. could be click on element from list
		builder.click(element).build().perform();
		//2. could be pressed KeyDown + Enter
		//builder.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).click(element).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
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
