package com.mindtree.kalinga.EasyBucks.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	WebDriver driver;

	public void refresh() {
		driver.navigate().refresh();
	}

	public void reload() {
		driver.get(driver.getCurrentUrl());
	}

	public void waitforElement() {
		@SuppressWarnings("unused")
		WebElement element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.id("data")));
	}

	public void explicit() {
		driver.get("url");
		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
	}

	public void implicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("url");
		@SuppressWarnings("unused")
		WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));
	}
}
