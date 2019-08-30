package stepDef;

import java.io.IOException;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.HomePage;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) throws IOException {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("navigate to home page")
	public void navigate_to_home_page() throws IOException {
		homePage.navigateTo_HomePage(testContext.getWebDriverManager().getDriver());
	}

	@When("click on registration link")
	public void click_on_registration_link() {
		homePage.navigateTo_RegistarionPage();
	}

	@Then("verrify registration is sucessfull")
	public void verrify_registration_is_sucessfull() {
		String diplyName = homePage.getDisplayName().getText();

		String userName = (String) testContext.getScenarioContext().getContext(Context.DISPLAY_NAME);
		if (diplyName.contains(userName)) {
			System.out.println("User Name is getting displayed");
		} else {
			System.out.println("User Name is not getting displayed");
		}
	}
}
