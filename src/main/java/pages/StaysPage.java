package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class StaysPage extends Base{

	//Work Trip filter
	//--------------------------------------------------------------------------------------------->
	@FindBy(xpath = "//div[@id='menuItemButton-work_trip']//button[@class='_1o8pdwg']")
	WebElement workTrip;
	
	@FindBy(xpath = "//button[@id='filterItem-switch-work_trip-true']")
	WebElement switchWorkTrip;
		
	//Type of place filter
	//---------------------------------------------------------------------------------------------->
	@FindBy(xpath = "//button[@class='_v2ee95z']")
	WebElement placeType;
	
	@FindBy(xpath = "//input[@id='filterItem-checkbox-room_types-Entire_home/apt']")
	WebElement entirePlace;
	
	@FindBy(xpath = "//input[@id='filterItem-checkbox-room_types-Private_room']")
	WebElement privateRoom;
	
	@FindBy(xpath = "//input[@id='filterItem-checkbox-room_types-Hotel_room']")
	WebElement hotelRoom;
	
	@FindBy(xpath = "//input[@id='filterItem-checkbox-room_types-Shared_room']")
	WebElement sharedRoom;
	
	
	//Price filter
	//---------------------------------------------------------------------------------------------->
	@FindBy(xpath = "//div[@id='menuItemButton-price_range']//button[@class='_1o8pdwg']")
	WebElement price;
	
	@FindBy(xpath = "//input[@id='price_filter_min']")
	WebElement priceMin;
	
	@FindBy(xpath = "//input[@id='price_filter_max']")
	WebElement priceMax;
	
	//Instant book filter
	//---------------------------------------------------------------------------------------------->
	@FindBy(xpath = "//div[@id='menuItemButton-instant_book']//button[@class='_v2ee95z']")
	WebElement instantBook;
	
	@FindBy(xpath = "//button[@id='filterItem-switch-ib-false']")
	WebElement instantBookSwith;
	

	//Main elements
	//---------------------------------------------------------------------------------------------->
	@FindBy(xpath = "//div[@class='_txfhnyy']//button[@class='_n8x1sdh'][contains(text(),'Clear')]")
	WebElement clearBtn;
	
	@FindBy(xpath = "//div[@class='_txfhnyy']//button[@id='filter-panel-save-button']")
	WebElement saveBtn;
	
	//Pagination last element
	//---------------------------------------------------------------------------------------------->
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/main[1]/div[1]/div[1]/div[5]/div[1]/div[1]/nav[1]/span[1]/div[1]/ul[1]/li[5]/a[1]/div[1]")
	WebElement lastPaginationPage;
	
	
	public StaysPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectStayPlace(String placeName) {
	
		String lastNum = lastPaginationPage.getText();
		int arr = Integer.parseInt(lastNum);
		for(int i = 0; i <= arr; i++) {
			WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/main[1]/div[1]/"
					+ "div[1]/div[5]/div[1]/div[1]/nav[1]/span[1]/div[1]/ul[1]/li[" + i + "]"));
			element.click();
		
		}
	}
	
	public void selectplacesList() {
		List<WebElement> placesArr = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div"));
		for(WebElement element : placesArr) {
			 ////div[@class='_aov0j6']//div//div[2]//div[1]//div[1]//meta[1]
			//body[@class='with-new-header']/div/div/main[@id='site-content']/div[@class='content-container']/div/div/div/div/div[@class='_19qnt1y']/div[@class='_1gw6tte']/div[@class='_1tukcbvt']/div/div[@class='_aov0j6']/div/div/div/div/div[@class='_fhph4u']/div[2]/div[1]/div[1]/div[1]/div[1]
		}
	}
	
}
