package com.myorg.pages;

import org.openqa.selenium.By;

import com.myorg.enums.WaitStrategy;
import com.myorg.reports.ExtentLogger;

public final class YahooSearchResultsPage extends BasePage{
	private final By linkFirstResultAnchorText = By.xpath("//a[@aria-label=\"Apache JMeter - User's Manual\"]");
	public String getFirstSearchResultAnchorText() {
		ExtentLogger.pass("Getting first search result text");
//		System.out.println("Linketext=<"+getText(linkFirstResultAnchorText, WaitStrategy.VISIBLE)+">");
		return getText(linkFirstResultAnchorText, WaitStrategy.VISIBLE);
	}
}
