package com.myorg.utils;

import java.io.File;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myorg.constants.FrameworkConstants;
import com.myorg.enums.ConfigProperties;
/**
 * Utility class to get data from JSON File
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public class JsonUtils {

	private JsonUtils() { }

	public static HashMap<String, Object> getData(ConfigProperties key) throws Exception {
		HashMap<String, Object> map = new ObjectMapper().readValue(
				new File(FrameworkConstants.getTestdatapath()+PropertyFileUtils.get(key)),
				new TypeReference<HashMap<String, Object>>() {
				});
		return map;
	}
}
