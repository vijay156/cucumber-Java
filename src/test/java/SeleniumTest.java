
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\cucumber-java\\cucumber-java\\Drivers\\1.exe");
		WebDriver driver = new ChromeDriver();

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
		
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).click();
		String userName = "vijay" + generateRandomNum();
		driver.findElement(By.name("firstName")).sendKeys(userName);
		driver.findElement(By.name("lastName")).click();
		driver.findElement(By.name("lastName")).sendKeys("K");
		driver.findElement(By.name("phone")).click();
		driver.findElement(By.name("phone")).sendKeys("7708048465");
		driver.findElement(By.id("userName")).click();
		driver.findElement(By.id("userName")).sendKeys("vijay" + generateRandomNum() + "@gmail.com");
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
		driver.findElement(By.id("email")).sendKeys("vijay156" + generateRandomNum());
		driver.findElement(By.name("password")).click();
		String paswd = "vijay" + generateRandomNum();
		driver.findElement(By.name("password")).sendKeys(paswd);
		driver.findElement(By.name("confirmPassword")).click();
		driver.findElement(By.name("confirmPassword")).sendKeys(paswd);
		driver.findElement(By.name("submit")).click();

		String diplyName = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b"))
				.getText();

		if (diplyName.contains(userName)) {
			System.out.println("User Name is getting displayed");
		} else {
			System.out.println("User Name is not getting displayed");		
		}

		driver.close();

		FileWriter writer = new FileWriter("YourFile.txt",true);
		writer.write("\r\n");
		writer.write(userName);
		writer.write("\r\n");
		writer.write(paswd);
		writer.close();
	}

	public static int generateRandomNum() {

		Random num = new Random();
		int number = num.nextInt(100);
		return number;
	}

}
