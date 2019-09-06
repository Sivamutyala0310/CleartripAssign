package com.pageactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

enum Action {
	SENDKEYS, CLICK;
}

public class FindElement {
	static WebElement element;
	static Action action;

	public FindElement(Action action) {
		this.action = action;
	}

	public static void findElement(WebDriver driver, String xpath, String value) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		switch (action) {
		case SENDKEYS:
			driver.findElement(By.xpath(xpath)).sendKeys(value);
			break;
			
		case CLICK:
			driver.findElement(By.xpath(xpath)).click();

		default:

		}
	}
}
