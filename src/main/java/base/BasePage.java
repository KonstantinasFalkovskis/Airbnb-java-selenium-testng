package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public BasePage(WebDriver driver) {
		super(driver);
	}

	
	@Override
	public String getPageTitle() {
		 return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		 } catch(Exception e) {
			 System.out.println("Exception occured while element is finding: " + locator.toString());
			 e.printStackTrace();
		 }
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch(Exception e) {
			System.out.println("Exception occured while waiting for element: " + locator.toString());
			e.getStackTrace();
		}
		
	}
	
	@Override
	public void waitForElementClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while waiting for element will be clicable: " + locator.toString());
		}
	}

	@Override
	public void doClick(By locator) {
		waitForElementClickable(locator);
		getElement(locator).click();
	}

	@Override
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	@Override
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Some exception occurred while quitting the browser");
		}
	}

	@Override
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Some exception occurred while closing the browser");
		}
	}


	@Override
	public void doClickWithJS(By locator) {
		try {
			waitForElementClickable(locator);
			js.executeScript("arguments[0].click()", locator);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public void doSmartClick(By locator) {
		waitForElementPresent(locator);
		waitForElementClickable(locator);
		try {
			doClick(locator);		
		} catch(WebDriverException e) {
			doClickWithJS(locator);
		}
	}
	
//	@Override
	public void doSendKeys(By locator, String text) {
		try {
		waitForElementPresent(locator);
		getElement(locator).sendKeys(text);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while " + text + " is sending to element");	
		}
	}

//	@Override
	public void doMoveToElement(WebElement element) {
		try {
		   new Actions(driver).moveToElement(element).perform();
	     } catch(Exception e) {
				e.printStackTrace();
				System.out.println("Exception occured while element " + element + " is waiting");	
		}
	}

//	@Override
	public void doSwitchToFrame(By locator, String nameOrId) {
		try {
		waitForElementPresent(locator);
		driver.switchTo().frame(nameOrId);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while frame " + nameOrId + " is waiting");	
		}
		
	}

//	@Override
	public void doOpenUrl(String url) {
		try {
		driver.get(url);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while page " + url + " is loading");	
		}
	}

}
