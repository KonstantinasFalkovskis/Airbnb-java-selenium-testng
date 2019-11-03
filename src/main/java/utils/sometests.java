package trials;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sometests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String txt = "return document.findElementById(\"SomeId\").value;";
		String line = (String) js.executeScript(txt);
		System.out.println(line);
		
		driver.findElement(By.id("ID")).sendKeys(Keys.ARROW_DOWN);
		js.executeScript("window.location = 'http://www.google.com'");
		WebElement forInput = (WebElement) js.executeScript("return document.findElementById('name');");
		forInput.sendKeys("test");
		
		//switch the window
				ArrayList <String> windows = new ArrayList<String>  (driver.getWindowHandles()); 
//				driver.switchTo().window(windows.get(1));
				//Set<String> windows = driver.getWindowHandles();
				Iterator<String> id = windows.iterator();
				String parentId = id.next();
				String childId = id.next();
	}

}
