package com.myorg.pages;

import org.openqa.selenium.By;

import com.myorg.enums.ConfigProperties;
import com.myorg.enums.WaitStrategy;
import com.myorg.reports.ExtentLogger;
import com.myorg.utils.PropertyFileUtils;

public final class YahooHomePage extends BasePage{
private final By textboxSearch = By.xpath("//input[@id='ybar-sbq']");

public YahooHomePage navigateToYahoo() throws Exception {
		navigateToUrl(PropertyFileUtils.get(ConfigProperties.YAHOOURL));
		ExtentLogger.pass("Navigated to Yahoo URL");
		return this;
	}
	
	public YahooSearchResultsPage performYahooSearch(String searchText) {
		sendKeysAndSubmit(textboxSearch, searchText, WaitStrategy.CLICKABLE);
		ExtentLogger.pass("Search Query Submmited");
		return new YahooSearchResultsPage();
	}
}
