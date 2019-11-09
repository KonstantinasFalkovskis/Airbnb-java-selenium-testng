package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LanguagePage extends Base {

	@FindBy(xpath = "/html/body/div[9]/div/div/div/div/section/div/div/button/span[1]")
	WebElement closeBtn;
	
	
	public LanguagePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectLanguage(String lang) {
		List<WebElement> langArr = driver.findElements(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[1]/"
				+ "section[1]/div[1]/section[2]/div[1]/ul[1]/li"));
		for(WebElement element : langArr) {
			if(element.getText().equals(lang)) {
				element.click();
			}
		}
		
	}
	
}
