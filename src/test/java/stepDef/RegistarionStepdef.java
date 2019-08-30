package stepDef;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import javaUtils.FileReaderManager;
import pageObjects.RegistrationPage;
import testDataTypes.Registration;

public class RegistarionStepdef {
	TestContext testContext;
	RegistrationPage registrationPage;

	public RegistarionStepdef(TestContext context) {
		testContext = context;
		registrationPage = testContext.getPageObjectManager().getRegistrationPage();
	}

	String userName;
	String paswd;

	@Then("enter all the required fields")
	public void enter_all_the_required_fields() throws IOException, IOException {

		Registration customer = FileReaderManager.getInstance().getJsonReader().getRegistrationData();

		userName = customer.getUSERNAME() + reusableActions.Reusable_Utils.generateRandomNum();

		System.out.println(userName);
		testContext.getScenarioContext().setContext(Context.DISPLAY_NAME, userName);
		

		paswd = customer.getPASSWORD() + reusableActions.Reusable_Utils.generateRandomNum();

		registrationPage.getFirstName().click();
		registrationPage.getFirstName().sendKeys(userName);

		registrationPage.getLastName().click();
		registrationPage.getLastName().sendKeys(customer.getLASTNAME());

		registrationPage.getPhone().click();
		registrationPage.getPhone().sendKeys(customer.getPHONE());

		registrationPage.getUserName().click();
		registrationPage.getUserName()
				.sendKeys(userName + reusableActions.Reusable_Utils.generateRandomNum() + "@gmail.com");

		registrationPage.getAddress1().click();
		registrationPage.getAddress1().sendKeys(customer.getADDRESS1());

		registrationPage.getCity().click();
		registrationPage.getCity().sendKeys(customer.getCITY());

		registrationPage.getState().click();
		registrationPage.getState().sendKeys(customer.getSTATE());

		registrationPage.getPostalCode().click();
		registrationPage.getPostalCode().sendKeys(customer.getPOSTALCODE());

		registrationPage.getCountry().click();
		Select src = new Select(registrationPage.getCountry());
		src.selectByVisibleText(customer.getCOUNTRY());

		registrationPage.getEmail().click();
		registrationPage.getEmail().sendKeys(customer.getEMAIL() + reusableActions.Reusable_Utils.generateRandomNum());

		registrationPage.getPassword().click();
		registrationPage.getPassword().sendKeys(paswd);

		registrationPage.getConfirmPassword().click();
		registrationPage.getConfirmPassword().sendKeys(paswd);

		registrationPage.getSubmit().click();
	}

}
