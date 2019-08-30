package cucumber;

import java.io.IOException;

import enums.WebDriverManager;
import pageObjects.PageObjectManager;

public class TestContext {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext = new ScenarioContext();

	public TestContext() throws IOException {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }
}
