package com.myorg.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.myorg.constants.FrameworkConstants;
import com.myorg.enums.ConfigProperties;
/**
 * Utility class to read values from Properties file
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public class PropertyFileUtils {
	private PropertyFileUtils() { }
	
	private static Properties property = new Properties();
	
	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String get(ConfigProperties key) throws Exception  {
		String propKey = key.name().toLowerCase();
		String propValue = property.getProperty(propKey);
		if(Objects.isNull(propValue))
			throw new Exception("Property name" + key + " is not found. Please check config.properties file");
		System.out.print("Prop value="+propValue);
		return propValue;
	}

}
