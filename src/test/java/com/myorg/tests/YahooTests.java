package com.myorg.tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myorg.dataprovider.DataProviders;
import com.myorg.pages.GoogleHomePage;
import com.myorg.pages.YahooHomePage;
/**
 * Contains tests related to Yahoo search
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public final class YahooTests extends BaseTest {
	private YahooTests() { }

	@Test(dataProvider = "getYahooSearchQueryData", dataProviderClass = DataProviders.class)
	public void validateFirstYahooSearchResult(Map<String, Object> map) throws Exception {
		String textToEnter = map.get("searchText").toString();
		String expectedResult = map.get("firstResultAltText").toString();
		String firstResultAnchorText = new YahooHomePage()
										.navigateToYahoo()
										.performYahooSearch(textToEnter)
										.getFirstSearchResultAnchorText();
		System.out.println("Actual="+firstResultAnchorText);

		Assert.assertTrue(firstResultAnchorText.contains(expectedResult),
				"Expected search result is not present as first link");
		
	}
	
}
