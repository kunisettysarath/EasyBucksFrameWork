package com.mindtree.kalinga.EasyBucks.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CrossBrowser {
	protected WebDriver driver;

	public CrossBrowser(WebDriver driver) {
		super();
		this.driver = driver;

	}
	/*
	 * this method receives the parameter passed from xml
	 */

	@SuppressWarnings("deprecation")
	public WebDriver multiBrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Running firefox");
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin",
					"C:\\Users\\M1043066\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			Capabilities dc = new Capabilities();
			driver = new FirefoxDriver(dc.desiredCap(browser));

		} else if (browser.equalsIgnoreCase("chrome")) {
			//System.out.println("Running Chrome");
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

			Capabilities dc = new Capabilities();
			driver = new ChromeDriver(dc.desiredCap(browser));
		} else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("Running IE");
			System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
			Capabilities dc = new Capabilities();
			driver = new InternetExplorerDriver(dc.desiredCap(browser));
		}
		return driver;
	}

}
