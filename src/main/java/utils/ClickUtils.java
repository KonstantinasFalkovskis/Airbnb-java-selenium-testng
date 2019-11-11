package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import base.Base;

public class ClickUtils extends Base{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//Actions builder = new Actions(driver);
	
	public void doMultiClick(WebElement element, String arr) {
		
		//wrapper
		//Integer arr = Integer.valueOf(count);	
		Integer num = Integer.parseInt(arr);	
		
		for(int i = 0; i <= num; i++ ) {
			if(i > 0) {
			try {
				doClick(element);
			} catch(WebDriverException e) {
				doClickWithJS(element);
				}
			} else { // if no person is selecting
				//builder.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
				break;
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
