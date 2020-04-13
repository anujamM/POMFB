package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FacebookLoginPage {

	WebDriver driver;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Using FindBy for locating elements
	// @FindBy(how = How.XPATH, using = "//input[contains(@name, 'firstname')]]")
	@FindBy(xpath = "//input[contains(@name, 'firstname')]")
	WebElement firstNameTextBox;

	@FindBy(xpath = "//input[contains(@name, 'lastname')]")
	WebElement lastNameTextBox;

	@FindBy(xpath = "//input[contains(@name, 'reg_email__')]")
	WebElement contactNumberTextBox;

	@FindBy(xpath = "//input[contains(@name, 'reg_passwd__')]")
	WebElement passwordTextBox;

	@FindBy(xpath = "//*[@id=\"day\"]")
	WebElement birthDateDropdown;

	@FindBy(xpath = "//*[@id=\"month\"]")
	WebElement birthMonthDropdown;

	@FindBy(xpath = "//*[@id=\"year\"]")
	WebElement birthYearDropdown;

	@FindBy(xpath = "(//input[contains(@name, 'sex')])[1]")
	WebElement genderFemaleRadioButton;

	@FindBy(xpath = "(//input[contains(@name, 'sex')])[2]")
	WebElement genderMaleRadioButton;

	@FindBy(xpath = "(//input[contains(@name, 'sex')])[3]")
	WebElement genderCustomRadioButton;

	@FindBy(xpath = "//button[contains(@name, 'websubmit')]")
	WebElement submitButton;

	@FindBy(id = "reg_error_inner")
	WebElement loginPageErrorMsg;

	// Defining all the user actions (Methods)
	// that can be performed in the Facebook home page

	// This method is to set Email in the email text box
	public void setFirstName(String strFirstName) {
		firstNameTextBox.sendKeys(strFirstName);
	}

	public void setLastName(String strLastName) {
		lastNameTextBox.sendKeys(strLastName);
	}

	public void setContactNumber(String strContactNumber) {
		contactNumberTextBox.sendKeys(strContactNumber);
	}

	public void setPassword(String strPassword) {
		passwordTextBox.sendKeys(strPassword);
	}

	public void setBirthDate(String strBirthDate, String strBirthMonth, String strBirthYear) {
		Select m = new Select(birthMonthDropdown);
		if (strBirthMonth.equalsIgnoreCase("Jan"))
			m.selectByIndex(01);
		else if (strBirthMonth.equalsIgnoreCase("Feb")) {
			m.selectByIndex(02);
		} else if (strBirthMonth.equalsIgnoreCase("Mar")) {
			m.selectByIndex(03);
		} else if (strBirthMonth.equalsIgnoreCase("Apr")) {
			m.selectByIndex(04);
		} else if (strBirthMonth.equalsIgnoreCase("May")) {
			m.selectByIndex(05);
		} else if (strBirthMonth.equalsIgnoreCase("Jun")) {
			m.selectByIndex(06);
		} else if (strBirthMonth.equalsIgnoreCase("Jul")) {
			m.selectByIndex(07);
		} else if (strBirthMonth.equalsIgnoreCase("Aug")) {
			m.selectByIndex(8);
		} else if (strBirthMonth.equalsIgnoreCase("Sept")) {
			m.selectByIndex(9);
		} else if (strBirthMonth.equalsIgnoreCase("Oct")) {
			m.selectByIndex(10);
		} else if (strBirthMonth.equalsIgnoreCase("Nov")) {
			m.selectByIndex(11);
		} else if (strBirthMonth.equalsIgnoreCase("Dec")) {
			m.selectByIndex(12);
		} else {
			try {
				throw new Exception("Month invalid!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Select year = new Select(birthYearDropdown);
		year.selectByValue(strBirthYear);
	}

	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("Female")) {
			genderFemaleRadioButton.click();
		} else if (gender.equalsIgnoreCase("Male")) {
			genderMaleRadioButton.click();
		} else if (gender.equalsIgnoreCase("Custom")) {
			genderCustomRadioButton.click();
		} else
			try {
				throw new Exception("Gender is not specified.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void clickSignUpButton() throws InterruptedException {
		submitButton.click();
		Thread.sleep(5000);
	}

	public void assertLoginPageErrorMsg() throws Exception {
		String msg = loginPageErrorMsg.getAttribute("innerText");
		System.out.println(msg);
		if(!msg.equalsIgnoreCase("Too many users have this phone number listed as pending.")) {
			throw new Exception("Contact number error!!!");
		}
	}

}
