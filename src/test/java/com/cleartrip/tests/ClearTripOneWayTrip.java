package com.cleartrip.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.cleartrip.ConstantFilePaths;
import com.cleartrip.TestBase;
import com.utils.LogReports;
import com.utils.ReadLocatorsFile;
import com.utils.TestDataProvider;

public class ClearTripOneWayTrip extends TestBase
{
	Properties properties1;
	LogReports log = new LogReports();
	
	@Test(dataProvider = "testdata",dataProviderClass = TestDataProvider.class)
	
	public void oneWayTrip(String email,String titleInitial,String firstName,String lastName,String phoneNbr,String str) throws IOException, Exception 
	{	
		properties1 = ReadLocatorsFile.loadProperty(ConstantFilePaths.LOCATORS_FILE);
		String nFromPlace = properties1.getProperty("fromPlace");
		String nFromPlaceValue = properties1.getProperty("fromPlaceValue");
		driver.findElement(By.xpath(nFromPlace)).sendKeys(nFromPlaceValue);
		log.info("sending FromPlace value:");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		String nToPlace = properties1.getProperty("toPlace");
		String ntoPlaceValue = properties1.getProperty("toPlaceValue");
		driver.findElement(By.xpath(nToPlace)).sendKeys(ntoPlaceValue);
		Thread.sleep(3000);
		log.info("sending  Toplace value:");
		action.sendKeys(Keys.ENTER).build().perform();
		String nDateOfJourney = properties1.getProperty("dateOfJourney");
		String nDateOfJourneyValue = properties1.getProperty("dateOfJourneyValue");
		driver.findElement(By.xpath(nDateOfJourney)).click();
		driver.findElement(By.xpath(nDateOfJourneyValue)).click();
		log.info("sending date");
		String nSearchFlight = properties1.getProperty("searchFlight");
		driver.findElement(By.xpath(nSearchFlight)).click();
		log.info("searching flight");
		String nselectFlight = properties1.getProperty("booking");
		Thread.sleep(5000);
		driver.findElement(By.xpath(nselectFlight)).click();
		String naccepttermCheckbox = properties1.getProperty("accepttermsCheckbox");
		Thread.sleep(5000);
		driver.findElement(By.xpath(naccepttermCheckbox)).click();
		log.info("accepting terms and conditions");
		String ncontinueBooking = properties1.getProperty("continueBooking");
		Thread.sleep(5000);
		driver.findElement(By.xpath(ncontinueBooking)).click();
		log.info("selecting flight");
		String nemailAddress = properties1.getProperty("emailAddress");
		Thread.sleep(3000);
		driver.findElement(By.xpath(nemailAddress)).sendKeys(email);
		log.info("sending E-mail of the passenger");
		String nemailAddressContinue = properties1.getProperty("emailAddressContinue");
		driver.findElement(By.xpath(nemailAddressContinue)).click();
		String ntravellerNameTittle = properties1.getProperty("travellerNameTittle");
		Thread.sleep(5000);
		driver.findElement(By.xpath(ntravellerNameTittle)).click();
		WebElement titleBox = driver.findElement(By.xpath(ntravellerNameTittle));
		Select s = new Select(titleBox);
		s.selectByValue(titleInitial);
		String ntravellersFirstName = properties1.getProperty("travellersFirstName");
		driver.findElement(By.xpath(ntravellersFirstName)).sendKeys(firstName);
		log.info("sending firstname of the passenger");
		String ntravellersLastName = properties1.getProperty("travellersLastName");
		driver.findElement(By.xpath(ntravellersLastName)).sendKeys(lastName);
		log.info("sending Lastname of the passenger");
		String ntravellersMobileNumber = properties1.getProperty("travellersMobileNumber");
		Thread.sleep(3000);
		log.info("sending mobile number");
		driver.findElement(By.xpath(ntravellersMobileNumber)).sendKeys(phoneNbr);
		String ntravellersContinuePayment = properties1.getProperty("travellersContinuePayment");
		driver.findElement(By.xpath(ntravellersContinuePayment)).click();
		log.info("going for payment page");
		log.info("oneway trip testcase passed");
		}
}

