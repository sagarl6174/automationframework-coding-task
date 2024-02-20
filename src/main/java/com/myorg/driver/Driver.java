package com.myorg.driver;
/**
 * Driver class is responsible for invoking and closing the browsers
 * Feb 14, 2024
 * @author Sagar Lolla
 */
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.myorg.utils.PropertyFileUtils;

public final class Driver {
	private Driver() { }
	
	public static void initDriver() {
		if(Objects.isNull(DriverManager.getWebDriver())) {
			ChromeOptions options = new ChromeOptions();
			WebDriver driver = new ChromeDriver(options);
			DriverManager.setWebDriver(driver);
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getWebDriver())) {
			DriverManager.getWebDriver().quit();
			DriverManager.unloadDriver();
		}
	}
}
