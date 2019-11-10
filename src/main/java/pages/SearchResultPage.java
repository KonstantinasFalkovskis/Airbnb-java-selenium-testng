package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class SearchResultPage extends Base{

	@FindBy(xpath = "//div[@class='_jcyejhc']")
	WebElement destinationInputField;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDestinationInputField() {
		return destinationInputField.isDisplayed();
	}
	
	
}
