package com.myorg.pages;

import org.openqa.selenium.By;

import com.myorg.driver.DriverManager;
import com.myorg.enums.WaitStrategy;
import com.myorg.reports.ExtentLogger;

public final class BingSearchResultsPage extends BasePage {
	private final By linkFirstResultAnchorText = By.xpath("//ol[@id='b_results']/li[1]/h2/a");

	public String getFirstSearchResultAnchorText() {
		ExtentLogger.pass("Getting first search result text");
		return getText(linkFirstResultAnchorText, WaitStrategy.VISIBLE);
	}

}
