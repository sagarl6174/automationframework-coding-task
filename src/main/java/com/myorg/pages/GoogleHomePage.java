package com.myorg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.myorg.driver.DriverManager;
import com.myorg.enums.ConfigProperties;
import com.myorg.enums.WaitStrategy;
import com.myorg.factories.ExplicitWaitFactory;
import com.myorg.reports.ExtentLogger;
import com.myorg.utils.PropertyFileUtils;

public final class GoogleHomePage extends BasePage{
		private final By textboxSearch = By.name("q");
		
		public GoogleHomePage navigateToGoogle() throws Exception {
			navigateToUrl(PropertyFileUtils.get(ConfigProperties.GOOGLEURL));
			ExtentLogger.pass("Navigated to Google URL");
			return this;
		}
		
		public GoogleSearchResultsPage performGoogleSearch(String searchText) {
			sendKeysAndSubmit(textboxSearch, searchText, WaitStrategy.CLICKABLE);
			ExtentLogger.pass("Search Query Submmited");
			return new GoogleSearchResultsPage();
		}
		

}
