package utilities;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;

public class windowsHandler {
	
	WebDriver driver;
	public void winHandler() {
		ArrayList<String> list = new ArrayList<String> (driver.getWindowHandles()); 
	//Set<String> list = driver.getWindowHandles();
		Iterator<String> ids = list.iterator();
		String parentID = ids.next();
		String childID = ids.next(); 
	
	}

}
