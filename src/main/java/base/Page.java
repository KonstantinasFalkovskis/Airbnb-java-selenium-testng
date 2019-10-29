package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}
	
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);	
	public abstract void waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	public abstract void doClick(By locator);
	public abstract String doGetText(By locator);
	public abstract void quitBrowser();
	public abstract void closeBrowser();
	
	// create a method with Java Generics and return a new page
			public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
				try {
					return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}


}
