package com.mindtree.kalinga.EasyBucks.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.kalinga.EasyBucks.base.ActionHelper;

import com.mindtree.kalinga.EasyBucks.base.RowDataReader;

import com.mindtree.kalinga.EasyBucks.reports.Reporters;
import com.mindtree.kalinga.EasyBucks.utils.ExcelUtil;

public class CommonImplementation {
	WebDriver driver;
	Reporters repo;
	WebElement element;

	public CommonImplementation(WebDriver driver, Reporters repo) {
		super();
		this.driver = driver;
		this.repo = repo;
	}

	/*
	 * This method will take the Locators of the particular Test Scenario and
	 * will perform the action according to the data provided in excel sheet.
	 */
	public void implementationTestCases(String keyword, String testcase) throws IOException, InterruptedException {

		//System.out.println(keyword + "  " + testcase);
		ExcelUtil excel = new ExcelUtil();
		ActionHelper help = new ActionHelper(driver);

		ArrayList<String> al = new ArrayList<String>();
		RowDataReader row = new RowDataReader();
		int j = 0;

		al = row.rowDataReader(keyword, testcase);

		//System.out.println("RowData is " + al);
		int startNum = excel.getStartRow("LocatorsSheet", keyword);
		int endNum = excel.getEndRow("LocatorsSheet", startNum);

		for (int i = startNum; i <= endNum; i++) {

			String action = excel.getRowNumData("LocatorsSheet", i, "Keywords");
			Thread.sleep(200);
			String locator = excel.getRowNumData("LocatorsSheet", i, "Locator");
			String locatorType = excel.getRowNumData("LocatorsSheet", i, "LocatorType");
			String log = excel.getRowNumData("LocatorsSheet", i, "Logs");
			//System.out.println(action + "***" + locator + "***" + locatorType + "***" + log);
			if (action.trim().equalsIgnoreCase("sendData") || action.equalsIgnoreCase("select")) {
				//System.out.println("I am J " + j);
				element = this.convertToWebElement(locatorType, locator);
				//System.out.println("I am element");
				//System.out.println(element);
				//System.out.println("ArrayList data" + al.get(j));
				help.testAction(action, element, al.get(j));
				repo.addMsg(log);
				j++;
			} else if (action.trim().equalsIgnoreCase("sleep")) {
				Thread.sleep(3000);
			} else if (action.trim().equalsIgnoreCase("mouseHover")) {
				//System.out.println("I am Mouse Hover");
				element = this.convertToWebElement(locatorType, locator);
				Actions act = new Actions(driver);
				Thread.sleep(2000);
				act.moveToElement(element).build().perform();
				element.click();
				Thread.sleep(1000);
			} else if (action.trim().equalsIgnoreCase("select")) {
				element = this.convertToWebElement(locatorType, locator);
				help.testAction(action, element, al.get(j));
				;
				j++;
			}

			else {

				element = this.convertToWebElement(locatorType, locator);

				help.testAction(action, element);
				repo.addMsg(log);
				//System.out.println(log);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}

		}

	}

	// WebElement converter..Just call this method and pass the Locator and
	// Locator Type
	public WebElement convertToWebElement(String LocatorType, String Locator) {

		if (LocatorType.trim().equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(Locator));
			return (element);
		} else if (LocatorType.trim().equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(Locator));
			return (element);
		} else if (LocatorType.trim().equalsIgnoreCase("cssSelector")) {
			element = driver.findElement(By.cssSelector(Locator));
			return (element);
		} else if (LocatorType.trim().equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(Locator));
			return (element);

		} else if (LocatorType.trim().equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(Locator));
			return (element);
		} else if (LocatorType.trim().equalsIgnoreCase("tagName")) {
			return (driver.findElement(By.tagName(Locator)));
		} else if (LocatorType.trim().equalsIgnoreCase("linkText")) {
			return (driver.findElement(By.linkText(Locator)));
		} else
			return null;

	}

}
