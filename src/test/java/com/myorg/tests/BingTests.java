package com.myorg.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myorg.dataprovider.DataProviders;
import com.myorg.pages.BingHomePage;
/**
 * Contains tests related to Bing search
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public final class BingTests extends BaseTest {
	private BingTests() {
	}

	
	@Test(dataProvider = "getBingSearchQueryData", dataProviderClass = DataProviders.class)
	public void validateFirstBingSearchResult(Map<String, Object> map) throws Exception {
		String textToEnter = map.get("searchText").toString();
		String expectedResult = map.get("firstResultAltText").toString();
		String firstResultAnchorText = new BingHomePage()
										.navigateToBing()
										.performBingSearch(textToEnter)
										.getFirstSearchResultAnchorText();
		Assert.assertTrue(expectedResult.equals(firstResultAnchorText),
				"Expected search result is not present as first link");
		
	}
	
	
}
