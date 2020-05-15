package com.mindtree.kalinga.EasyBucks.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.kalinga.EasyBucks.utils.ExcelUtil;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	ExcelUtil excel = new ExcelUtil();
	@FindBy(xpath = "/html/body/app-root/app-home/div/div[1]/div/nav/div/ul/li[6]/a/b")
	WebElement homeLoginButton;
	
	@FindBy(name = "email")
	WebElement uname;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "/html/body/app-root/app-login/div/div/div/form/input")
	WebElement login;
	
	public WebElement getHomeLoginButton() {
		return homeLoginButton;
	}

	public WebElement getUname() {
		return uname;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return login;
	}

}
