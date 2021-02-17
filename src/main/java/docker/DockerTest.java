package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");

		RemoteWebDriver driver = new RemoteWebDriver(url, dc);

		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
