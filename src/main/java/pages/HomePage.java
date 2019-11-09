package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base{

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void loginPageMenu(String loginMenuTab) {
		List<WebElement> loginMenuArr = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/ul[1]/li"));
		for(WebElement element : loginMenuArr) {
			if(element.getText().equals(loginMenuTab)) {
				element.click();
			} else {
				break;
			}
		}
	}
	
	public void loginPageProfileMenu(String profileMenuTab) {
		List<WebElement> profileMenuArr = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/header[1]/div[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/ul[1]/li[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li"));
		for(WebElement element : profileMenuArr) {
			if(element.getText().equals(profileMenuTab)) {
				element.click();
			} else {
				break;
			}
		}
	}
	
	
}
