package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	By header = By.xpath("//td[contains(text(), 'User')]");
	
	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getElement(header).getText();
	}

}
