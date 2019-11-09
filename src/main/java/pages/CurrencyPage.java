package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class CurrencyPage extends Base{

	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/button[1]/span[1]")
	WebElement closeBtn;
	
	public CurrencyPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectCurrency(String currency) {
		List<WebElement> currArr = driver.findElements(By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[1]/section[1]/"
				+ "div[1]/section[1]/div[1]/ul[1]/li"));
		for(WebElement element : currArr) {
			if(element.getText().equals(currency)){
				element.click();
			}
		}
		
	}
	
	
}
