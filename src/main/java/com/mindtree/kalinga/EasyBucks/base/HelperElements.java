package com.mindtree.kalinga.EasyBucks.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.IAssert;

/*
 * 
 * Project- EasyBucks
 * Ravi Kumar Gupta
 * M1043164
 * 
 */

public class HelperElements {

	WebDriver driver;

	public HelperElements(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// *************Check for enable elements*************************************

	public void enableElementAndClick(String Locaters, WebElement element) {

		if (!element.isEnabled()) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementByXpath(" + Locaters + ").disable=false;");
			element.click();

		} else
			element.click();
	}

	// *************Checking and Unchecking of CheckBoxes*************
	public void checkUncheckCheckBoxes(WebElement element) {

		try {
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// *****************Vertical Scrolls************************

	public void verticalScrolls(int ScrollPixel) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0," + ScrollPixel + ")", "");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// *****************Horizontal Scrolls*************************

	public void horizontalScrolls(int ScrollPixel) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(" + ScrollPixel + ",0)", "");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// *******************JavaScript Click***************************

	public void javascriptClick(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// ***************************Mouse Left Click***********************

	public void mouseLeftClick(WebElement element) {

		try {
			Actions action = new Actions(driver);
			action.click(element).build().perform();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	// **************************Mouse Right Click*********************

	public void mouseRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();

	}
	// *************************Mouse Hover*************************

	public void mouseHover(WebElement element) {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// *************************Drag and Drop*************************

	public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}

		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation " + e.getStackTrace());
		}
	}

	// ****************************KeyBoard Action Tab and
	// Enter**************************

	public void keyBoardAction(String key) {
		try {
			Robot robot = new Robot();
			if (key.equalsIgnoreCase("TAB")) {
				robot.keyPress(KeyEvent.VK_TAB);

				robot.keyRelease(KeyEvent.VK_TAB);

			} else if (key.equalsIgnoreCase("Enter")) {
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}

		} catch (AWTException e) {

			e.printStackTrace();
		}
	}

	// ****************************KeyBoard Action Ctrl+T
	// **************************

	public void keyBoardActionCtrlT() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);

		} catch (AWTException e) {

			e.printStackTrace();
		}

	}

	// ****************************Fill Text Box **************************

	public void enterInTextBox(WebElement element, String data) {

		try {
			element.sendKeys(data);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// ************************* Select Box by Visible Text*********************

	public void selectBoxByVisibleText(WebElement element, String data) {

		try {
			Select select = new Select(element);
			select.selectByVisibleText(data);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// ************************* Select Box by Value Text*********************

	public void selectBoxByValue(WebElement element, String data) {
		try {
			Select select = new Select(element);
			select.selectByValue(data);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// *************************Select Combo Box*****************************

	public void selectComboBox(WebElement element, ArrayList<String> data) {
		int size = data.size();
		for (int i = 0; i < size; i++) {
			Select select = new Select(element);
			select.selectByValue(data.get(i));
			;
		}
	}
	
	// **************************To click on Alert Msg*************************
	
	public void clickOnAlertOK() {
		driver.switchTo().alert().accept();
	}
	
	//******************Get the Pop-Up msg************************************
	public String getPopUpMsg(){
		return(driver.switchTo().alert().getText());
	}


}
