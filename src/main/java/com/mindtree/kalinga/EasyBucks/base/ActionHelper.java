package com.mindtree.kalinga.EasyBucks.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionHelper {
	WebDriver driver;

	public ActionHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}

	HelperElements help = new HelperElements(driver);

	public void testAction(String action, WebElement element, String data) {

		if (action.equalsIgnoreCase("SendData")) {
			element.sendKeys(data);
		}

		else if (action.equalsIgnoreCase("select")) {
			help.selectBoxByVisibleText(element, data);
		}

	}

	/*
	 * This function can be used when we do not need to pass the data
	 */
	
	public void testAction(String action, WebElement element) {
		if (action.equalsIgnoreCase("click")) {
			element.click();
		} else if (action.equalsIgnoreCase("mouseHover")) {
			help.mouseHover(element);
		}
	}
	
	/*
	 * This method can be used when only action and data is required
	 * 
	 */

	public void testAction(String action, String data) {
		if (action.equalsIgnoreCase("VerticalScrol")) {
			int data1 = Integer.parseInt(data);
			help.verticalScrolls(data1);
		} else if (action.equalsIgnoreCase("HorizontalScrol")) {
			int data1 = Integer.parseInt(data);
			help.horizontalScrolls(data1);
		}
	}
}
