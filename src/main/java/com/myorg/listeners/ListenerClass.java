package com.myorg.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.myorg.reports.ExtentLogger;
import com.myorg.reports.ExtentReport;
/**
 * ListenerClass Implements org.testng.ITestListener and org.testng.ISuiteListener to leverage the abstract methods.
 * Helps with extent report generation
 * Feb 14, 2024
 * @author Sagar Lolla
 */
public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		
//		ITestListener.super.onTestFailedWithTimeout(result);
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		
//		ITestListener.super.onStart(context);
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		
//		ITestListener.super.onFinish(context);
//	}
//
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		
//		return super.clone();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		
//		return super.equals(obj);
//	}
//
//	@Override
//	protected void finalize() throws Throwable {
//		
//		super.finalize();
//	}
//
//	@Override
//	public int hashCode() {
//		
//		return super.hashCode();
//	}
//
//	@Override
//	public String toString() {
//		
//		return super.toString();
//	}

	
	
}
