package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(id = "userName")
	private WebElement userName;

	@FindBy(name = "address1")
	private WebElement address1;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "state")
	private WebElement state;

	@FindBy(name = "postalCode")
	private WebElement postalCode;

	@FindBy(name = "country")
	private WebElement country;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPassword;

	@FindBy(name = "submit")
	private WebElement submit;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getSubmit() {
		return submit;
	}

}
