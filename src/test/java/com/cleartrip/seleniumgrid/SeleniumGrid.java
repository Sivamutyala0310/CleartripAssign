package com.cleartrip.seleniumgrid;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid {
	@Test
	public static void seleniumGridDriver() throws Exception
	{

	//	DesiredCapabilities desiredcapality=DesiredCapabilities.firefox();
		
		//desiredcapality.setPlatform(Platform.WINDOWS);
		//desiredcapality.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		//URL url=new URL("http://localhost:4444/wd/hub");
		//WebDriver driver=new RemoteWebDriver(url,desiredcapality);
		driver.get("http://cleartrip.com");
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
