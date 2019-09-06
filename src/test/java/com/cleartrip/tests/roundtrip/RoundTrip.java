package com.cleartrip.tests.roundtrip;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.cleartrip.ConstantFilePaths;
import com.cleartrip.RoundtripTestBase;
import com.cleartrip.TestBase;
import com.utils.LogReports;
import com.utils.ReadLocatorsFile;
import com.utils.TestDataProvider;

public class RoundTrip extends RoundtripTestBase
{
	LogReports log=new LogReports();
Properties properties1;
	
	@Test(dataProvider = "testdata",dataProviderClass = TestDataProvider.class)
	
	public void oneWayTrip(String email,String titleInitial,String firstName,String lastName,String phoneNbr,String str) throws IOException, Exception 
	{	
		properties1 = ReadLocatorsFile.loadProperty(ConstantFilePaths.ROUNDTRIPLOCATORS_FILE);
		String tripType = properties1.getProperty("roundTrip");
		driver.findElement(By.xpath(tripType)).click();
		log.info("selecting roundtrip");
		String nFromPlace = properties1.getProperty("fromPlace");
		String nFromPlaceValue = properties1.getProperty("fromPlaceValue");
		driver.findElement(By.xpath(nFromPlace)).sendKeys(nFromPlaceValue);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		log.info("sending FromPlace value");
		String nToPlace = properties1.getProperty("toPlace");
		String ntoPlaceValue = properties1.getProperty("toPlaceValue");
		driver.findElement(By.xpath(nToPlace)).sendKeys(ntoPlaceValue);
		Thread.sleep(3000);
		action.sendKeys(Keys.ENTER).build().perform();
		log.info("sending LastName of the passenger");
		String nDateOfJourney = properties1.getProperty("dateOfJourney");
		String nDateOfJourneyValue = properties1.getProperty("dateOfJourneyValue");
		driver.findElement(By.xpath(nDateOfJourney)).click();
		driver.findElement(By.xpath(nDateOfJourneyValue)).click();
		log.info("sending dateof journey");
		String nSearchFlight = properties1.getProperty("searchFlight");
		driver.findElement(By.xpath(nSearchFlight)).click();
		log.info("clicking on searchflight");
		String nselectFlight = properties1.getProperty("booking");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		driver.findElement(By.xpath(nselectFlight)).click();
		log.info("selecting particular flight");
		String naccepttermCheckbox = properties1.getProperty("acceptTerms");
		Thread.sleep(5000);
		driver.findElement(By.xpath(naccepttermCheckbox)).click();
		log.info("accepting terms and conditions");
		String ncontinueBooking = properties1.getProperty("continueBooking");
		Thread.sleep(5000);
		driver.findElement(By.xpath(ncontinueBooking)).click();
		String nemailAddress = properties1.getProperty("emailAddress");
		Thread.sleep(3000);
		driver.findElement(By.xpath(nemailAddress)).sendKeys(email);
		log.info("sending email address of the passenger");
		String nemailAddressContinue = properties1.getProperty("emailAddressContinue");
		driver.findElement(By.xpath(nemailAddressContinue)).click();
		String ntravellerNameTittle = properties1.getProperty("travellerNameTittle");
		Thread.sleep(5000);
		driver.findElement(By.xpath(ntravellerNameTittle)).click();
		WebElement titleBox = driver.findElement(By.xpath(ntravellerNameTittle));
		Select s = new Select(titleBox);
		s.selectByValue(titleInitial);
		String ntravellersFirstName = properties1.getProperty("firstName");
		driver.findElement(By.xpath(ntravellersFirstName)).sendKeys(firstName);
		log.info("sending details of the passenger");
		String ntravellersLastName = properties1.getProperty("lastName");
		driver.findElement(By.xpath(ntravellersLastName)).sendKeys(lastName);
		String ntravellersMobileNumber = properties1.getProperty("mobileNumber");
		Thread.sleep(3000);
		driver.findElement(By.xpath(ntravellersMobileNumber)).sendKeys(phoneNbr);
		String ntravellersContinuePayment = properties1.getProperty("travellersContinuePayment");
		driver.findElement(By.xpath(ntravellersContinuePayment)).click();
		log.info("twoway trip test case passed");
}
}
