package com.flightreservation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OptionsPage {
	WebDriver driver;
	By addBaggage = By.xpath("//*[@id='PH_passenger_baggage_promoADT']/div/div/div[3]/button/span[1]");
	By incrementBaggage = By.xpath("//*[@id='passengerADT1']/div/div/div[2]/form/add-bags-bound-input/div/button[2]");
	By bagsButtonContinue =By.xpath("//*[@id='bags-btn-continue']");
	By acceptButton= By.xpath("//*[@id='bagsTermsAndConditionsModal']/div/div/div[2]/navigation-ribbon/navigation-ribbon-view-tac/div/nav/div[2]/button");
	By selectSeatButton = By.xpath("//*[@id='PH_passenger_seat_promo']/div/div/div/div[2]/button");
	By seatSelection = By.xpath("//*[@id='sm_modal_body']/div[2]/seatmap/seatmap-paginator/div/div/seatmap-paginator-content/deck/table/tbody/tr[10]/td[1]/div/i");
	By seatButtonContinue = By.xpath("//*[@id='seats-btn-continue']");
	
	public OptionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addBaggage() throws InterruptedException{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(addBaggage).click();
		driver.findElement(incrementBaggage).click();
	}
	

}
