package io.cucumber.stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.cucumber.skeleton.Reusable_Utils;
import pageObjects.HomePage;

public class RegistarionStepdef {
	WebDriver driver;
	String userName;
    
	@Given("navigate to home page")
	public void navigate_to_home_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\cucumber-java\\cucumber-java\\Drivers\\1.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String baseUrl = "http://demo.guru99.com/test/newtours/";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";

		driver.get(baseUrl);
		actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

	}

	@When("click on registration link")
	public void click_on_registration_link() {
		HomePage page = new HomePage();		
		page.getUserName().click();
	}

	@Then("enter all the required fields")
	public void enter_all_the_required_fields() {

		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).click();
		userName = "vijay" + Reusable_Utils.generateRandomNum();
		driver.findElement(By.name("firstName")).sendKeys(userName);
		driver.findElement(By.name("lastName")).click();
		driver.findElement(By.name("lastName")).sendKeys("K");
		driver.findElement(By.name("phone")).click();
		driver.findElement(By.name("phone")).sendKeys("7708048465");
		driver.findElement(By.id("userName")).click();
		driver.findElement(By.id("userName")).sendKeys("vijay" + Reusable_Utils.generateRandomNum() + "@gmail.com");
		driver.findElement(By.name("address1")).click();
		driver.findElement(By.name("address1")).sendKeys("Chennai");
		driver.findElement(By.name("city")).click();
		driver.findElement(By.name("city")).sendKeys("Chennai");
		driver.findElement(By.name("state")).click();
		driver.findElement(By.name("state")).sendKeys("TamilNadu");
		driver.findElement(By.name("postalCode")).click();
		driver.findElement(By.name("postalCode")).sendKeys("603103");
		driver.findElement(By.name("country")).click();

		WebElement dropdown = driver.findElement(By.name("country"));
		Select src = new Select(dropdown);
		src.selectByVisibleText("INDIA");

		// driver.findElement(By.name("country")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("vijay156" + Reusable_Utils.generateRandomNum());
		driver.findElement(By.name("password")).click();
		String paswd = "vijay" + Reusable_Utils.generateRandomNum();
		driver.findElement(By.name("password")).sendKeys(paswd);
		driver.findElement(By.name("confirmPassword")).click();
		driver.findElement(By.name("confirmPassword")).sendKeys(paswd);
		driver.findElement(By.name("submit")).click();
	}

	@Then("verrify registration is sucessfull")
	public void verrify_registration_is_sucessfull() {

		String diplyName = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b"))
				.getText();

		if (diplyName.contains(userName)) {
			System.out.println("User Name is getting displayed");
		} else {
			System.out.println("User Name is not getting displayed");
		}

		driver.close();
	}

}
