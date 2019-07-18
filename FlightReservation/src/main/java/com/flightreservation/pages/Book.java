package com.flightreservation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flightreservation.utilities.DateUtility;

public class Book {
	WebDriver driver;
	private int today;
	private int todayPlus;
	DateUtility dateUtility = new DateUtility();
	List<WebElement> columns;
	By bookMenu = By.xpath("//*[@id='primary-navigation__book-a-trip']");
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

	public Book(WebDriver driver) {
		this.driver = driver;
	}

	public void selectBookMenu() {
		driver.findElement(bookMenu).click();
		driver.findElement(bookMenu).click();
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
}