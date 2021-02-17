package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestClass {
	
	public static WebDriver driver = null;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Eclipse_Oxy/Drivers/chromedriver_win32/chromedriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		options.addArguments("--disable-infobars");
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		options.setCapability("unhandledPromptBehavior", "accept");
		options.setCapability("unexpectedAlertBehaviour", "accept");
		options.setCapability("CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR", "accept");
		
//		driver = new RemoteWebDriver(new URL("http://" + System.getProperty("hub", "localhost") + ":4444/wd/hub"),
//				options);
		
		String hubURL = "http://192.168.0.109:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubURL), options);
		
		driver.get("https://www.google.com");
		driver.quit();
	}

}
