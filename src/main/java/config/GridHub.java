 package config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridHub {

	DesiredCapabilities cap = new DesiredCapabilities();
	
	public void setCapabilities() throws MalformedURLException {
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.MAC);
	
	ChromeOptions options = new ChromeOptions();
	options.merge(cap);
	
	String hubUrl = "http://192.168.0.100:4444/wd/hub";
	WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);
	
	}
			
}
