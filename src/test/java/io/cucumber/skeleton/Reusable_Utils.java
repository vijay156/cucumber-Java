package io.cucumber.skeleton;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reusable_Utils implements WebDriverManagerTest {
	
	public static int generateRandomNum() {
		Random num = new Random();
		int number = num.nextInt(100);
		return number;
	}
	
	public static WebDriver getDriver() {
		
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	@Override
	public void WebdriverManger() {
		
	}
}
