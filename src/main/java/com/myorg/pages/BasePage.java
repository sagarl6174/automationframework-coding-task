package com.myorg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.myorg.driver.DriverManager;
import com.myorg.enums.WaitStrategy;
import com.myorg.factories.ExplicitWaitFactory;
/**
 * Super class of all page classes. Contains reusable methods
 * Feb 14, 2024
 * @author Sagar Lolla
 */
public class BasePage {
	
	protected void navigateToUrl(String url) {
		DriverManager.getWebDriver().get(url);
		DriverManager.getWebDriver().manage().window().maximize();
	}
	
	protected void sendKeysAndSubmit(By by, String text, WaitStrategy waitStrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(text, Keys.ENTER);
	}

	protected String getText(By by, WaitStrategy waitStrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		return element.getText();
	}
	protected void click(By by, WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
	}
}
