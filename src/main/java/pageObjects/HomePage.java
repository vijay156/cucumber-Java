package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(linkText= "REGISTER") private WebElement userName;

	public WebElement getUserName() {
	return userName;
	}
		
}
