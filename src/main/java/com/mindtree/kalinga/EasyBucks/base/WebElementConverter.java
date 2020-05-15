/**
 * 
 */
package com.mindtree.kalinga.EasyBucks.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author M1043164
 *
 */
public class WebElementConverter {
	WebElement element;
	WebDriver driver;

	public WebElementConverter(WebDriver driver2) {
		driver = driver2;
	}

	public WebElement convertToWebElement(String LocatorType, String Locator) {

		if (LocatorType.equalsIgnoreCase("name")) {
			return (driver.findElement(By.name(Locator)));
		} else if (LocatorType.equalsIgnoreCase("id")) {
			return (driver.findElement(By.id(Locator)));
		} else if (LocatorType.equalsIgnoreCase("cssSelector")) {
			return (driver.findElement(By.cssSelector(Locator)));
		} else if (LocatorType.equalsIgnoreCase("id")) {
			return (driver.findElement(By.id(Locator)));

		} else if (LocatorType.trim().equalsIgnoreCase("xpath")) {
			driver.manage().window().maximize();

			System.out.println("Ravvviiiiiii" + "LocatorType---" + LocatorType + "*****8" + Locator);
			element = driver.findElement(By.xpath(Locator));
			return (element);
		} else if (LocatorType.equalsIgnoreCase("tagName")) {
			return (driver.findElement(By.tagName(Locator)));
		} else if (LocatorType.equalsIgnoreCase("linkText")) {
			return (driver.findElement(By.linkText(Locator)));
		} else
			return null;

	}

}
