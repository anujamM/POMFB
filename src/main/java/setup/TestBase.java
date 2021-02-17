package setup;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeClass(alwaysRun = true)
	public void initialize() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:/Eclipse_Oxy/Drivers/chromedriver_win32/chromedriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		String hubURL = "http://192.168.0.109:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubURL), cap);

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-infobars");
//		options.addArguments("start-maximized");
//		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//		options.setExperimentalOption("useAutomationExtension", false);
//		options.setCapability("unhandledPromptBehavior", "accept");
//		options.setCapability("unexpectedAlertBehaviour", "accept");
//		options.setCapability("CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR", "accept");
		
//		driver = new RemoteWebDriver(new URL("http://" + System.getProperty("hub", "localhost") + ":4444/wd/hub"),
//				options);

		// To maximize browser
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// To open FB site
		driver.get("https://www.facebook.com");
	}

	@AfterClass(alwaysRun = true)
	// Test cleanup
	public void TeardownTest() {
		TestBase.driver.quit();
	}
}