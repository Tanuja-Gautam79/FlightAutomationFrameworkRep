package com.flightreservation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flightreservation.utilities.DateUtility;

public class BookPage {
	WebDriver driver;	
	By bookMenu = By.xpath("//*[@id='primary-navigation__book-a-trip']");
	
	public BookPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectBookMenu() {
		driver.findElement(bookMenu).click();
		driver.findElement(bookMenu).click();
	}

	
}