package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javaUtils.FileReaderManager;
import reusableActions.Reusable_Utils;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "REGISTER")
	private WebElement registerLink;

	public WebElement getRegisterLink() {
		return registerLink;
	}
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")
	private WebElement displayName;
	
	public WebElement getDisplayName() {
		return displayName;
	}

	/////////////////////////// Action /////////////////////////////////
	
	public void navigateTo_HomePage(WebDriver driver) throws IOException {

		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		
		System.out.println(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		

		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}
		
		Reusable_Utils.untilJqueryIsDone(driver);
	}

	public void navigateTo_RegistarionPage() {
		getRegisterLink().click();
	}

}
