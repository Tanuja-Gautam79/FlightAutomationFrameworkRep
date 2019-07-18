package com.seleniumcucumber.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flightreservation.constants.Constants;
import com.flightreservation.pages.Book;
import com.flightreservation.pages.FlightDetails;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {

	public String url = "https://www.qantas.com";
	FlightDetails flightDetails;
	String tripCost;

	@Given("user navigates to site")
	public void user_navigates_to_site() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Constants.driver = new ChromeDriver();
		Constants.driver.get(url);
		Constants.driver.manage().window().maximize();
		Constants.driver.manage().timeouts()
				.implicitlyWait(100, TimeUnit.SECONDS);
	}

	@When("^user search for one-way filght \"([^\"]*)\" to \"([^\"]*)\"$")
	public void user_search_for_one_way_filght_pair(String source,
			String destination) throws Throwable {

		Book bookingPage = new Book(Constants.driver);
		bookingPage.selectBookMenu();
		bookingPage.selectflightsLink();
		bookingPage.selectOneWayFlightSearch();
		bookingPage.checkOneWayRadioButton();
		bookingPage.enterText_FromTextBox(source);
		bookingPage.enterText_ToTextBox(destination);
		bookingPage.departDate();		
		bookingPage.clickSearchFlighButton();
		Thread.sleep(5000);
	}

	@When("user select Re e-deal value and add to trip")
	public void SelectAnyDeal_AddToTrip() throws InterruptedException {
		flightDetails = new FlightDetails(Constants.driver);
		tripCost = flightDetails.selectAnyDeal();
		Thread.sleep(2000);
		flightDetails.clickonAddToTripButton();
	}

	@Then("verify subtotal value")
	public void verify_subtotal() throws Throwable {

		Assert.assertEquals(tripCost, flightDetails.getSubTotal());
		tearDown();
	}

	public static void tearDown() {

		Constants.driver.close();
		Constants.driver = null;
	}
}