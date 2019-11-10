package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import base.Base;

public class ClickUtils extends Base{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void doMultiClick(WebElement element, int clickCount) {
		for(int i = 0; i <= clickCount; i++ ) {
			try {
				doClick(element);
			} catch(WebDriverException e) {
				doClickWithJS(element);
			}
		}
	}
	
	public void doClick(WebElement element) {
		try {
			element.click();
		} catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
	public void doClickWithJS(WebElement element) {
		try {
			js.executeScript("arguments[0].click()", element);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
