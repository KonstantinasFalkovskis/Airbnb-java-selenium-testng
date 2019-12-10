package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.Util;
import utils.WebEventListener;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	public Logger log;
	
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
	@Parameters({"environment","platform","browserName","url"})
	public void selectRunningSource(@Optional("local") String environment, @Optional("ANY") String platform, @Optional("chrome") String browserName, String url, ITestContext ctx) throws MalformedURLException {
		
		BrowserFactory factory = new BrowserFactory(browserName);
		if(environment.equals("grid")) {
				driver = factory.parallelRun(platform,browserName);
		} else {
				driver = factory.initialization(browserName);
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("url"));
		driver.get(url);
		
		setCurrentThreadName();
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
	}
	
	private void setCurrentThreadName() {
		Thread thread = Thread.currentThread();
		String threadName = thread.getName();
		String threadId = String.valueOf(thread.getId());
		if (!threadName.contains(threadId)) {
			thread.setName(threadName + " " + threadId);
			System.out.println(threadName + " " + threadId);
		}
	}
	
	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		try {
			log.info("[Closing session]");
			System.out.println("[Closing session]");
			driver.quit();
		} catch(Exception e) {
			log.info(e);
			System.out.println("ERROR: " + e);
		}
	}
	
	
}
