package com.myorg.reports;
/**
 * Provides abstraction to write extent logger statements
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public final class ExtentLogger {
	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
}
