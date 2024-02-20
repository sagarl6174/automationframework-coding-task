package com.myorg.driver;

import org.openqa.selenium.WebDriver;
/**
 * DriverManager achieves Thread Safety for driver object
 * Feb 14, 2024
 * @author Sagar Lolla
 */
public final class DriverManager {
	private DriverManager() { }
	
	public static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();
	
	public static WebDriver getWebDriver() {
		return threadSafeDriver.get();
	}
	
	public static void setWebDriver(WebDriver driver) {
		threadSafeDriver.set(driver);
	}
	
	public static void unloadDriver() {
		threadSafeDriver.remove();
	}

}
