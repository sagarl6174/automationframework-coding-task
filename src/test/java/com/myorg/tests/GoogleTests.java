package com.myorg.tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myorg.dataprovider.DataProviders;
import com.myorg.pages.BingHomePage;
import com.myorg.pages.GoogleHomePage;
import com.myorg.pages.GoogleSearchResultsPage;
/**
 * Contains tests related to Google search
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public final class GoogleTests extends BaseTest {
	private GoogleTests() { }

	@Test(dataProvider = "getGoogleSearchQueryData", dataProviderClass = DataProviders.class)
	public void validateFirstGoogleSearchResult(Map<String, Object> map) throws Exception {
		String textToEnter = map.get("searchText").toString();
		String expectedResult = map.get("firstResultAltText").toString();
		String firstResultAnchorText = new GoogleHomePage()
										.navigateToGoogle()
										.performGoogleSearch(textToEnter)
										.getFirstSearchResultAnchorText();
		Assert.assertTrue(expectedResult.equals(firstResultAnchorText),
				"Expected search result is not present as first link");
		
	}
	
	
	

}
