package com.flightreservation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flightreservation.utilities.DateUtility;

public class FlightDetails {
	WebDriver driver;
	WebDriverWait wait;
	private int today;
	private int todayPlus;
	DateUtility dateUtility = new DateUtility();
	List<WebElement> columns;
	By flights = By
			.xpath("//*[@id='main']/div/div/div/div[2]/div/div/div[2]/div/div[2]/h3");
	By search_oneway_and_returnflights = By
			.xpath("//*[@id='main']/div/div/div/div[2]/div/div/div[2]/div/div[2]/a[1]");
	By onewayRadioButton = By
			.xpath("//*[@id='flight-form']/form[1]/div[3]/div[2]/div[2]/div[1]/fieldset/div/div[2]/label/span");
	By fromTextBox = By.xpath("//*[@id='typeahead-input-from']");
	By toTextBox = By.xpath("//*[@id='typeahead-input-to']");
	By departDatePickerCalender = By
			.xpath("//*[@id='flight-form']/form[1]/div[3]/div[5]/div/div[1]/div[1]");
	By departDatePickerTableBody = By
			.xpath("//*[@id='flight-form']/form[1]/div[3]/div[5]/div/div[2]/div/div[4]/div[1]/table");
	By departDatePickerTableBodyNext = By
			.xpath("//*[@id='flight-form']/form[1]/div[3]/div[5]/div/div[2]/div/div[4]/div[2]/table");
	By searchFlight = By
			.xpath("//*[@id='flight-form']/form[1]/div[3]/div[10]/div/button");

	By anyedeal = By
			.xpath("//*[@id='e2e-itinerary-2']/div/div[2]/div/upsell-itinerary-fares/upsell-fare-cell[1]/div/label");
	By addToTripButton = By
			.xpath("//*[@id='upsell-container-bound0']/div/upsell-itinerary-avail[3]/div/div[2]/div/div/div[2]/div[4]/button");
	
	By widgetZero = By.xpath("//*[@id='shoppingCartOpener']/span/ribbon-total-amount/div/div/span[1]");
	By sunTotal = By
			.xpath("//*[@id='tripRecapPanel']/div[2]/div[2]/div[2]/div/div[2]");
	
	By continueButton = By.xpath("//*[@id='btn-continue']");
	By nextcontinueButton = By.xpath("//*[@id='btn-continue']/span");
	By acceptButton = By.xpath("//*[@id='btn-accept']/span");

	public FlightDetails(WebDriver driver) {
		this.driver = driver;
	}

	
	public void selectflightsLink() {
		driver.findElement(flights).click();
	}

	public void selectOneWayFlightSearch() {
		driver.findElement(search_oneway_and_returnflights).click();
	}

	public void checkOneWayRadioButton() {
		driver.findElement(onewayRadioButton).click();
	}

	public void enterText_FromTextBox(String source) {
		driver.findElement(fromTextBox).clear();
		driver.findElement(fromTextBox).sendKeys(source);
	}

	public void enterText_ToTextBox(String destination) {
		driver.findElement(toTextBox).clear();
		driver.findElement(toTextBox).sendKeys(destination);
		driver.findElement(By.xpath("//*[@id='typeahead-list-item-to-0']"))
				.click();

	}

	public void departDate() {
		driver.findElement(departDatePickerCalender).click();
		today = dateUtility.getCurrentDay();
		todayPlus = dateUtility.addDaysToCurrentDate();

		if (todayPlus < today) {
			WebElement dateWidgetFrom = driver
					.findElement(departDatePickerTableBodyNext);

			columns = dateWidgetFrom.findElements(By.tagName("td"));
		} else {
			WebElement dateWidgetFrom = driver
					.findElement(departDatePickerTableBody);

			columns = dateWidgetFrom.findElements(By.tagName("td"));
		}
		for (WebElement cell : columns) {
			if (cell.getText().equals(Integer.toString(todayPlus))) {

				cell.click();
				break;
			}
		}
	}

	public void clickSearchFlighButton() {
		driver.findElement(searchFlight).click();

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
	
	public String getFlightWidgetZero() {
		String flightWidgetCost = driver.findElement(widgetZero).getText();
		return flightWidgetCost;
	}

	public String getSubTotal() {
		String totalCost = driver.findElement(sunTotal).getText();
		return totalCost;
	}
	
	public void clickOnContinueButton()
	{
		driver.findElement(continueButton).click();
	}
	
	public void clickonContinueAndAcceptButtonTillOptionsPage() throws InterruptedException
	{
		driver.findElement(continueButton).click();
		Thread.sleep(10000);
		driver.findElement(nextcontinueButton).click();
		driver.findElement(acceptButton).click();
		
	}
	
	public void waitTilButtonIsDisabled()
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
	}

}
