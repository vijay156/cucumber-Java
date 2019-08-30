package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private WebDriver driver;

	private HomePage homePage;

	private RegistrationPage registrationPage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public HomePage getHomePage() throws IOException {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public RegistrationPage getRegistrationPage() {
		return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
	}

}
