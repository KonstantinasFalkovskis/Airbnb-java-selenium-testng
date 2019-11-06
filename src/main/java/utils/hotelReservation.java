package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class hotelReservation {
		
	WebDriver driver;
	String filename = "C:\\Selenium\\elements.xls";	
	WebElement hotelLink, searchElement, buttonSearch, searchTag, selectFromDrop, chekInElement, 
	chekOutElement, travelers, adultsCountIncrease, forStarsHotel, autoSuggestionKeyDownElement, roomsElement, roomIncrease,
	childrensIncrease, childAge, addRoom, hotel;
	String dateIn = "12/25/2018";
	String dateOut = "12/27/2018";
//	String starRating = "star3";
//	String name = "Chico,CA";
		
	@Test(dataProvider = "getData")
	public void reservationTest(String searchResult, String anotherText, String chekIn, String chekOut, String rating, 
			String age, String hotelNr) {
		System.out.println("Looking for: " + searchResult);
		boolean link = driver.findElement(By.xpath("//button[@id='tab-hotel-tab-hp']//span[@class='icons-container']")).isDisplayed();
		Assert.assertTrue(link);
		System.out.println("\nLink for Hotels are visible\n");
		elementsSetUp();
		hotelLink.click();
		//searchElement.clear();
		searchElement.sendKeys(searchResult);
		searchElement.sendKeys(Keys.DOWN);
		searchElement.sendKeys(Keys.DOWN);
		//searchElement.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String scriptText = "return document.getElementById(\"hotel-destination-hp-hotel\").value;";
		String someTxt = (String) js.executeScript(scriptText);
//		Assert.assertEquals(someTxt, "Chicago, Illinois");
//		System.out.println(someTxt);
		
		if(someTxt.equalsIgnoreCase(anotherText)) {
			System.out.println("\nDinamical autosuggestion selected successfully\n");
		} else {
			System.err.println("\nError: " + someTxt + "do not selected\n");
		}

		while(!someTxt.equalsIgnoreCase(anotherText)) {
			searchElement.sendKeys(Keys.DOWN);
			someTxt = (String) js.executeScript(scriptText);
			System.out.println(someTxt);
			break;
		}
		searchElement.sendKeys(Keys.ENTER);
		chekInElement.clear();
		chekInElement.click();
		driver.findElement(By.xpath("//div[@class='datepicker-cal']//div[2]//table[1]//tbody[1]//tr[5]//td[4]//button[1]")).click();
		//chekInElement.sendKeys(chekIn);
		chekOutElement.clear();
		chekOutElement.click();
		//chekOutElement.sendKeys(chekOut);
		//driver.findElement(By.xpath("//tbody[@class='datepicker-cal-dates']//tr[5]//td[6]"));
		driver.findElement(By.xpath("//*[@id=\"hotel-checkout-wrapper-hp-hotel\"]/div/div/div[2]/table/tbody/tr[5]/td[7]/button")).click();
		roomsElement.click();
		roomIncrease.click();
		childrensIncrease.click();
		new Select(childAge).selectByValue(age);
		addRoom.click();
		buttonSearch.click();
		boolean forStarsVisible = driver.findElement(By.xpath("//input[@id='" + rating + "']")).isDisplayed();
		Assert.assertTrue(forStarsVisible);
		System.out.println("\n 3 stars hotels checkbox are visible... \n");
		
		//driver.findElement(By.xpath("//input[@id='star3']")).click();
		//hotel.click();
		//building a relative extended Xpath
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + hotelNr  + "]/div[2]/div/a")).click();
		//=====
		//switch the window
		ArrayList <String> windows = new ArrayList<String>  (driver.getWindowHandles()); 
//		driver.switchTo().window(windows.get(1));
		//Set<String> windows = driver.getWindowHandles();
		Iterator<String> id = windows.iterator();
		String parentId = id.next();
		String childId = id.next();
		//driver.switchTo().window(parentId);
		//driver.switchTo().window(childId);
		driver.findElement(By.xpath("//*[@id='rooms-and-rates']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[5]/button[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='rooms-and-rates']/div/article/table/tbody[1]/tr/td[3]/div/form/div[1]/button[1]")).click();
		String cost = driver.findElement(By.cssSelector("span[class='summary-total amount-value']")).getText();
		Assert.assertEquals(cost, "179.20");
		if (cost.equals("179.20")) {
			System.out.println("Total cost: " + cost + " USD $");
		} else {
			System.err.println("No price...");
		}
		
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
		
		//String txt = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/form[1]/div[13]/div[2]/div[8]/div[1]/header[1]/h1[1]/font[1]/font[1]")).getText();
//		boolean bullet = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/form[1]/div[13]/div[2]/div[8]/div[1]/header[1]/h1[1]/font[1]/font[1]")).isDisplayed();
//		Assert.assertTrue(bullet);

//		if(txt.contains("8 properties")) {
//			System.out.println("\n 3 stars hotels are selected successfully... \n" + txt);
//		} else {
//			System.err.println("\n error \n");
//		}
		
	}
	
	@DataProvider
	public String[][] getData() {
		return utilities.ExcelReader.getXLS(filename);
	}
	
	@BeforeMethod
	public void setup() {
		String browserType = "chrome";
		driver = utilities.browserFactory.openBrowser(browserType);
		System.out.println("\nBrowser opened successfully....\n");
		driver.manage().window().maximize();
		String title = "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver = utilities.openPage.open(title, driver);
	
	}
	
	@AfterMethod
	public void closeBrowse() {
		driver.close();
		driver.quit();
	}
	
	public void elementsSetUp() {
		hotelLink = driver.findElement(By.id("tab-hotel-tab-hp"));
		searchElement = driver.findElement(By.id("hotel-destination-hp-hotel"));
		autoSuggestionKeyDownElement = driver.findElement(By.id("hotel-destination-hp-hotel"));
		chekInElement = driver.findElement(By.id("hotel-checkin-hp-hotel"));
		chekOutElement = driver.findElement(By.id("hotel-checkout-hp-hotel"));
		roomsElement = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button[1]"));
		roomIncrease = driver.findElement(By.xpath("//*[@id='traveler-selector-hp-hotel']/div/ul/li/div/div/div[1]/div[2]/div[4]/button[1]"));
		childrensIncrease = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button[1]"));
		childAge = driver.findElement(By.xpath("//*[@id='traveler-selector-hp-hotel']/div/ul/li/div/div/div[1]/div[3]/div[2]/label[1]/select"));
		addRoom = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/div/div/a"));
		buttonSearch = driver.findElement(By.cssSelector("#gcw-hotel-form-hp-hotel > div.cols-nested.ab25184-submit > label > button"));
		//hotel = driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + hotelNr  + "]/div[2]/div/a"));
		//forStarsHotel = driver.findElement(By.cssSelector("input[name='star'][id='star3']"));
		//forStarsHotel = driver.findElement(By.xpath("//input[@id='star3']"));
	}

}

