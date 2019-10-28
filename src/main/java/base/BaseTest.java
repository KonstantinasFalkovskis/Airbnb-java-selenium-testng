/**
 * @author FalcoConstantine
 * @ver v1.0
 * @date 2019/10/28
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

import utils.Util;


public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\FalcoConstantine\\EclipseProjects\\AirBnb\\src\\main\\"
					+ "java\\config\\config.properties");
			prop.load(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initialization() {
		
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
				driver = new FirefoxDriver();
				} else if(browserName.equalsIgnoreCase("opera")) {
					System.setProperty("webdriver.opera.driver", "C:\\Selenium\\operadriver.exe");
					driver = new OperaDriver();
						} else if(browserName.equalsIgnoreCase("iexplorer")) {
							System.setProperty("webdriver.ie.driver", "C:\\Selenium\\iedriver.exe");
						driver = new InternetExplorerDriver();
					} else {
						System.out.println("no browser defined");
					}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
			driver.get(prop.getProperty("url"));
		
	}	
	
}
