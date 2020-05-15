package com.mindtree.kalinga.EasyBucks.base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

	public Capabilities() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * this method sets the desired capabilities of the browser which is passed
	 * from xml
	 */
	public DesiredCapabilities desiredCap(String browser) {
		DesiredCapabilities capabilities = null;

		if (browser.equalsIgnoreCase("ie")) {
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		} else if (browser.equalsIgnoreCase("firefox")) {
			capabilities = DesiredCapabilities.firefox();
			FirefoxProfile profile = new FirefoxProfile();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		} else if (browser.equalsIgnoreCase("chrome")) {
			capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			capabilities.setCapability("chrome.binary", "");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		}
		return capabilities;
	}
}
