package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class aTagsTest {
	
	WebDriver driver;
	
	@Test
    public void aTagsLinksTest() {
	  
		List <WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		int numOfLinkElements = listOfLinks.size();
		boolean accountLink = false;
		
		System.out.println("Number of links on the page is: " + numOfLinkElements);		
		for (WebElement aElement : listOfLinks) {
			System.out.println(aElement.getText());
			if (aElement.getText().equals("CREATE ACCOUNT")) {
				accountLink = true;
				break;
			}
		}
		Assert.assertTrue(accountLink);
		
    }
	
	@BeforeTest
	public void setup() {
		String browserType = "chrome";
		driver = utilities.driverFactory.openBrowser(browserType);
		System.out.println("\nBrowser was opened\n");
		String title = "SDET Training | Account Management";
		System.out.println("Open account page");
		driver = utilities.openPage.openP(driver, title);	
	}

	@AfterTest
	public void close() {
		System.out.println("\nClosing browser\n");
		driver.close();
		driver.quit();
	}
}
