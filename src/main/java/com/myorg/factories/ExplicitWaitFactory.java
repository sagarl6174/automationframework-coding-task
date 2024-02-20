package com.myorg.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myorg.constants.FrameworkConstants;
import com.myorg.driver.DriverManager;
import com.myorg.enums.WaitStrategy;
/**
 * ExplicitWaitFactory generates different waits
 * Feb 14, 2024
 * @author Sagar Lolla
 */
public class ExplicitWaitFactory {
	
	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		if(waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
			.until(ExpectedConditions.elementToBeClickable(by));
		} else if(waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if(waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if(waitStrategy == WaitStrategy.NONE) {
			element = DriverManager.getWebDriver().findElement(by);
		}
		return element;
	}
	
}
