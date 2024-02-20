package com.myorg.pages;

import org.openqa.selenium.By;

import com.myorg.driver.DriverManager;
import com.myorg.enums.WaitStrategy;
import com.myorg.reports.ExtentLogger;

public final class GoogleSearchResultsPage extends BasePage{
	private final By linkFirstResultAnchorText = By.xpath("//div[@id='search']//h3[1]");
	
	public String getFirstSearchResultAnchorText() {
		ExtentLogger.pass("Getting first search result text");
		return getText(linkFirstResultAnchorText, WaitStrategy.VISIBLE);
	}


}