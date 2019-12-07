package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
		
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	//public static RemoteWebDriver rdriver = null;
	
	String browserName;
	
	public BrowserFactory(String browserName) {
		this.browserName = browserName.toLowerCase();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	

		public WebDriver initialization(String browserName) {
			System.out.println("Starting " + browserName + " locally");
			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				tdriver.set(new ChromeDriver());
			} else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
					tdriver.set(new FirefoxDriver());
					} else if(browserName.equalsIgnoreCase("opera")) {
						WebDriverManager.operadriver().setup();
						tdriver.set(new OperaDriver());
							} else {
							WebDriverManager.iedriver().setup();	
							tdriver.set(new InternetExplorerDriver());
						} 
			

			
//				driver.set(Base.driver);
//				return getDriver();
			return tdriver.get();
			
		}
		
//		public WebDriver parallelRun(String platform, String browserName, String version) throws MalformedURLException {
		public WebDriver parallelRun(String platform, String browserName) throws MalformedURLException {
			
			String hubURL = "http://192.168.0.102:4444/wd/hub";
			DesiredCapabilities caps = new DesiredCapabilities();
			System.out.println("Starting " + browserName + " on grid");
			
			if (platform.equals("WINDOWS")) {
				caps.setPlatform(Platform.WINDOWS);
			}
			if (platform.equals("VISTA")) {
				caps.setPlatform(Platform.VISTA);
			}
			if (platform.equals("MAC")) {
				caps.setPlatform(Platform.HIGH_SIERRA);
			} 
			if (platform.equalsIgnoreCase("Linux")) {
				caps.setPlatform(Platform.LINUX);
			}

			if (browserName.equals("chrome")) {
				//caps = DesiredCapabilities.chrome();
				//caps.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
				caps.setBrowserName(new ChromeOptions().getBrowserName());
			}
			if (browserName.equals("firefox")) {
				//caps = DesiredCapabilities.firefox();
				caps.setBrowserName(new FirefoxOptions().getBrowserName());
			}
			if (browserName.equalsIgnoreCase("opera")) {
				//caps = DesiredCapabilities.operaBlink();
				caps.setBrowserName(new OperaOptions().getBrowserName());
			}
			if (browserName.equalsIgnoreCase("edge")) {
				//caps = DesiredCapabilities.edge();
				caps.setBrowserName(new EdgeOptions().getBrowserName());
			}
			if (browserName.equalsIgnoreCase("safari")) {
				//caps = DesiredCapabilities.safari();
				//caps.setBrowserName(DesiredCapabilities.safari().getBrowserName());
				caps.setBrowserName(new SafariOptions().getBrowserName());
			}
			
			
			// Version
			//caps.setVersion(version);
			
//			ChromeOptions options = new ChromeOptions();
//			options.merge(caps);
			
			try {
				tdriver.set(new RemoteWebDriver(new URL(hubURL), caps));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			return tdriver.get();
		}

}
