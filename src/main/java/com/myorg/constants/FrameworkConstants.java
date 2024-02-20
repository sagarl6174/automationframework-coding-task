package com.myorg.constants;

/**
 * Framework Constants holds all the constants used in the framework.
 * Feb 14, 2024
 * @author Sagar Lolla
 */
public final class FrameworkConstants {
	private FrameworkConstants() { }
	
	private static final String CONFIGFILEPATH = System.getProperty("user.dir") + 
												"/src/test/resources/config.properties";
	
	private static final String TESTDATAPATH = System.getProperty("user.dir") + "/src/test/resources/testdata/";
	
	private static final String EXTENTREPORTROOTDIRPATH = System.getProperty("user.dir") + "/Automation Results/";
			
	private static final int EXPLICITWAIT = 10;
	

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getExtentReportRootDirpath() {
		return EXTENTREPORTROOTDIRPATH;
	}

	public static String getTestdatapath() {
		return TESTDATAPATH;
	}

}
