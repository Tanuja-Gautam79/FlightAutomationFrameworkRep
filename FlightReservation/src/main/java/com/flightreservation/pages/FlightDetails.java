package com.flightreservation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FlightDetails {
	WebDriver driver;
	By anyedeal = By
			.xpath("//*[@id='e2e-itinerary-2']/div/div[2]/div/upsell-itinerary-fares/upsell-fare-cell[1]/div/label");
	By addToTripButton = By
			.xpath("//*[@id='upsell-container-bound0']/div/upsell-itinerary-avail[3]/div/div[2]/div/div/div[2]/div[4]/button");
	By sunTotal = By
			.xpath("//*[@id='tripRecapPanel']/div[2]/div[2]/div[2]/div/div[2]");

	public FlightDetails(WebDriver driver) {
		this.driver = driver;
	}

	public String selectAnyDeal() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(anyedeal).click();
		String delaValue = driver.findElement(anyedeal).getText();
		return delaValue;
	}

	public void clickonAddToTripButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(addToTripButton).click();
	}

	public String getSubTotal() {
		String totalCost = driver.findElement(sunTotal).getText();
		return totalCost;
	}

}
