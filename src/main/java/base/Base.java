/**
 *   Base.class contains:
 *    - WebDriver definition
 *    - Browsers definitions
 *    - Properties definition
 *    
 *    @author FalcoConstantine
 */
package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Util;
import utils.WebEventListener;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	String browserName;
	
	public Base() {
		try {
			prop = new Properties();
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/config/config.properties");
			prop.load(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public void initialization() {
		browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				} else if(browserName.equalsIgnoreCase("opera")) {
					WebDriverManager.operadriver().setup();
					driver = new OperaDriver();
						} else if(browserName.equalsIgnoreCase("iexplorer")) {
						WebDriverManager.iedriver().setup();	
						driver = new InternetExplorerDriver();
					} else {					
						System.out.println("no browser defined");
					}
		
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			driver.manage().window().maximize();
			//driver.manage().window().fullscreen();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
			driver.get(prop.getProperty("url"));
	
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Some exception occurred while quitting the browser");
		}
	}

}
