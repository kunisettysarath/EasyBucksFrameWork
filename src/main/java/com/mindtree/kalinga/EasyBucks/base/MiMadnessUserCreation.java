package com.mindtree.kalinga.EasyBucks.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiMadnessUserCreation {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		wb.get("https://temp-mail.org/en/");
		Thread.sleep(1000);
		System.out.println(wb.findElement(By.xpath("//*[@id=\"mail\"]")).getAttribute("value"));

	}
	
}
