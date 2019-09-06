package com.cleartrip;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import com.utils.LogReports;
import com.utils.ReadLocatorsFile;

public class TestBase {
	LogReports log = new LogReports();
	Properties baseProperty;
	String url;
	String browser;
	public static WebDriver driver;

	@BeforeMethod
	public void initializeBrowser() throws Exception {

		baseProperty = ReadLocatorsFile.loadProperty(ConstantFilePaths.CONFIG_FILE);
	DesiredCapabilities desiredcapality=DesiredCapabilities.firefox();
		
		desiredcapality.setPlatform(Platform.WINDOWS);
		desiredcapality.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		URL url1=new URL("http://localhost:4444/wd/hub");
	WebDriver driver=new RemoteWebDriver(url1,desiredcapality);

		
		url = baseProperty.getProperty("url");
	//	browser = baseProperty.getProperty("browserType");

//		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", ConstantFilePaths.CHROME_FILE);
//			driver = new ChromeDriver();
//			log.info("Chrome browser is started...");
//		} 
//		else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", ConstantFilePaths.FIREFOX_FILE);
//			driver = new FirefoxDriver();
//			log.info("Firefox browser is started...");
//		}
//		else if (browser.equalsIgnoreCase("IE")) {
//			System.setProperty("webdriver.ie.driver", ConstantFilePaths.IE_FILE);
//			driver = new InternetExplorerDriver();
//			log.info("IE browser is started...");
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
