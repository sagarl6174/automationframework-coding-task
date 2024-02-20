package com.myorg.reports;
/**
 * ExtentManager achieves thread safety for ExtentTest object
 * Feb 19, 2024
 * @author Sagar Lolla
 */
import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		if (Objects.nonNull(test)) {
			extTest.set(test);
		}
	}

	static void unload() {
		extTest.remove();
	}
}
