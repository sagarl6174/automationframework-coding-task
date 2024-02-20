package com.myorg.reports;

import java.util.Date;

import com.myorg.constants.FrameworkConstants;

import java.io.File;
import java.text.SimpleDateFormat;
/**
 * This helper class has a method that gets called before every run to create automation results directory.
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public final class ReportingDirHelper {
	private ReportingDirHelper() {}
	
	static String createReportingDirectory() throws Exception {
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
//        String reportingDirPath = System.getProperty("user.dir") + File.separator + "Automation_Results" + File.separator + timestamp;
        String reportingDirPath = FrameworkConstants.getExtentReportRootDirpath() + File.separator + "AutomationResults_"+timestamp;

        File resultsFolder = new File(reportingDirPath);
        boolean folderCreated = resultsFolder.mkdirs();

        if (!folderCreated) 
        	throw new Exception("Failed to created Automation Results Directory");
        return reportingDirPath;
        
	}

}
