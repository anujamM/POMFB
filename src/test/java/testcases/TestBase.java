package testcases;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeClass
	public void initialize() throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		options.setCapability("unhandledPromptBehavior", "accept");
		options.setCapability("unexpectedAlertBehaviour", "accept");
		options.setCapability("CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR", "accept");

		driver = new RemoteWebDriver(new URL("http://" + System.getProperty("hub", "localhost") + ":4444/wd/hub"),
				options);

		// To maximize browser
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// To open Gmail site
		driver.get("https://www.facebook.com");
	}

	@AfterClass
	// Test cleanup
	public void TeardownTest() {
		TestBase.driver.quit();
	}
}