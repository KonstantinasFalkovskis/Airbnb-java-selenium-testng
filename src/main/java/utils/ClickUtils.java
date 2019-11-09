package utils;

import org.openqa.selenium.WebElement;

import base.Base;

public class ClickUtils extends Base{
	
	public void doClick(WebElement element, int clickCount) {
		for(int i = 0; i <= clickCount; i++ ) {
			element.click();
		}
	}

}
