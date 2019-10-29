package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

		
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
	public void waitForPageTitle(String title) {
		 try {
			 wait.until(ExpectedConditions.titleContains(title));
		 } catch(Exception e) {
			 System.out.println("Exception occured while waiting for page loading: " + title.toString());
		 }
	}

	@Override
	public void doClick(By locator) {
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

}
