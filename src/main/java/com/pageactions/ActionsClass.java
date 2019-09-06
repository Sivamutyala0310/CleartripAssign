package com.pageactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	public static void enterSendkeys(WebDriver driver)
	{
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();
	}

}
