package com.myorg.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.myorg.driver.Driver;
/**
 * Parent class to other test classes. This class is responsible for invoking and terminating browser.
 * Feb 19, 2024
 * @author Sagar Lolla
 */
public class BaseTest {
	protected BaseTest() { }
	
	@BeforeMethod
	public void setUp() throws Exception {
			Driver.initDriver();
	}

	@AfterMethod	
	public void tearDown() {
		Driver.quitDriver();
	}
}
