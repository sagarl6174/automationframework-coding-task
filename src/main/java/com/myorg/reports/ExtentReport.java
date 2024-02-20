package com.myorg.reports;
/**
 * ExtentReport perform initialization and termination of ExtentReports object
 * Feb 19, 2024
 * @author Sagar Lolla
 */
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myorg.constants.FrameworkConstants;

public final class ExtentReport {
	private ExtentReport() {}
	private static String reportingDirPath=null;
	private static String extentReportFilePath=null;
	private static ExtentReports extent;

	public static void initReports() {
		if(Objects.isNull(extent)) {
			try {
				reportingDirPath = ReportingDirHelper.createReportingDirectory();
			} catch (Exception e) {
				e.printStackTrace();
			}
			extentReportFilePath=reportingDirPath+"/TestResultsReport.html";
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFilePath); 
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Coding Task Report");
			spark.config().setReportName("Coding Task Report");
		}
	}

	
	public static void flushReports(){
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(extentReportFilePath).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}
	
	
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
	
}
