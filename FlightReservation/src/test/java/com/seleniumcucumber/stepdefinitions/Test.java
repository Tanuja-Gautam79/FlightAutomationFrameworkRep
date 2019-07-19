package com.seleniumcucumber.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flightreservation.constants.Constants;
import com.flightreservation.pages.BookPage;
import com.flightreservation.pages.FlightDetails;
import com.flightreservation.pages.OptionsPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {

	public String url = "https://www.qantas.com";
	FlightDetails flightDetails;
	OptionsPage optionPage;
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

		BookPage bookingPage = new BookPage(Constants.driver);
		bookingPage.selectBookMenu();
		flightDetails = new FlightDetails(Constants.driver);
		flightDetails.selectflightsLink();
		flightDetails.selectOneWayFlightSearch();
		flightDetails.checkOneWayRadioButton();
		flightDetails.enterText_FromTextBox(source);
		flightDetails.enterText_ToTextBox(destination);
		flightDetails.departDate();		
		flightDetails.clickSearchFlighButton();
		Thread.sleep(5000);
	}

	@Then("verify flight widget is O")
	public void verifyflightWidget()
	{
		Assert.assertEquals("$0", flightDetails.getFlightWidgetZero());
	}
	
	@Then("user select Re e-deal value and add to trip")
	public void SelectAnyDeal_AddToTrip() throws InterruptedException {
		
		tripCost = flightDetails.selectAnyDeal();
		Thread.sleep(2000);
		flightDetails.clickonAddToTripButton();
	}

	@Then("verify subtotal value")
	public void verify_subtotal() throws Throwable {

		Assert.assertEquals(tripCost, flightDetails.getSubTotal());
		
	}
	@When("user click on continue till options page")
	public void clickOnContinue() throws InterruptedException
	{
		
		flightDetails.clickonContinueAndAcceptButtonTillOptionsPage();
	}

	@When("user check baggage and seats")
	public void addBaggage() throws InterruptedException
	{
		optionPage = new OptionsPage(Constants.driver);
		optionPage.addBaggage();	
		
	}
	@After
	public static void tearDown() {

		Constants.driver.close();
		Constants.driver = null;
	}
}