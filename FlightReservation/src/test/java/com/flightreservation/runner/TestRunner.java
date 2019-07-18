package com.flightreservation.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.flightreservation.constants.Constants;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, features = "classpath:features", glue = { "com.seleniumcucumber.stepdefinitions", // user
																																																		// step
																																																		// definitions
																																																		// package

})
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/config/report.xml"));

	}

	public static void tearDown() {

		Constants.driver.close();
		Constants.driver = null;
	}

}
