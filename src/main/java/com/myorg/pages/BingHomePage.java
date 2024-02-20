package com.myorg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.myorg.driver.DriverManager;
import com.myorg.enums.ConfigProperties;
import com.myorg.enums.WaitStrategy;
import com.myorg.reports.ExtentLogger;
import com.myorg.utils.PropertyFileUtils;

public final class BingHomePage extends BasePage{
	private final By textboxSearch = By.id("sb_form_q");
	
	public BingHomePage navigateToBing() throws Exception {
		navigateToUrl(PropertyFileUtils.get(ConfigProperties.BINGURL));
		ExtentLogger.pass("Navigated to Bing URL");
		return this;
	}
	
	public BingSearchResultsPage performBingSearch(String searchText) {
		click(textboxSearch, WaitStrategy.CLICKABLE);
		sendKeysAndSubmit(textboxSearch, searchText, WaitStrategy.CLICKABLE);
		ExtentLogger.pass("Search Query Submmited");
		return new BingSearchResultsPage();
	}
}
