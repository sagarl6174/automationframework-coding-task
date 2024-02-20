package com.myorg.dataprovider;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

import com.myorg.enums.ConfigProperties;
import com.myorg.utils.JsonUtils;
/**
 * Dataprovider acts as a bridge between test data file and your test. Helps to read data from external files
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public class DataProviders {
	
	@DataProvider(name = "getBingSearchQueryData")
	public Object[] getBingSearchQueryData() throws Exception {
		HashMap<String, Object> map = JsonUtils.getData(ConfigProperties.BINGTESTDATA);
		return new Object[] { map };

	}
	
	
	@DataProvider(name = "getGoogleSearchQueryData")
	public Object[] getGoogleSearchQueryData() throws Exception {
		HashMap<String, Object> map = JsonUtils.getData(ConfigProperties.GOOGLETESTDATA);
		return new Object[] { map };

	}
	
	@DataProvider(name = "getYahooSearchQueryData")
	public Object[] getYahooSearchQueryData() throws Exception {
		HashMap<String, Object> map = JsonUtils.getData(ConfigProperties.YAHOOTESTDATA);
		return new Object[] { map };

	}
}
