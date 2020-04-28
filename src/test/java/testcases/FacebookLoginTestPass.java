package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.FacebookLoginPage;
import setup.TestBase;

public class FacebookLoginTestPass extends TestBase {

	@Test(groups={"pass"})
	public void init() throws Exception {
		// driver.get("https://www.gmail.com");
		FacebookLoginPage loginpage = PageFactory.initElements(driver, FacebookLoginPage.class);
		loginpage.setFirstName("Anujam");
		loginpage.setLastName("Mandal");
		loginpage.setContactNumber("1234567890");
		loginpage.setPassword("ABC123");
		loginpage.setBirthDate("5", "Apr", "1993");
		loginpage.setGender("Male");
		loginpage.clickSignUpButton();
		loginpage.assertLoginPageErrorMsg();
		
	}
}