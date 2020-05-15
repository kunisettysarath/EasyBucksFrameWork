package com.mindtree.kalinga.EasyBucks.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {

	WebDriver driver;

	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/app-root/app-home/div/div[1]/div/nav/div/ul/li[5]/a/b")
	WebElement homeSignUp;

	@FindBy(xpath = "/html/body/app-root/app-home/div/div[1]/div/nav/div/ul/li[5]/a/b")
	WebElement SignUpButton;

	@FindBy(id = "name")
	WebElement fullName;

	@FindBy(xpath = "html/body/app-root/app-signup/div/div/div/form/div/div[1]/div/font")
	WebElement nameError;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "rpassword")
	WebElement confirmPassword;

	@FindBy(xpath = "/html/body/app-root/app-signup/div/div/div/form/div/div[5]/fieldset/select")
	WebElement role;

	@FindBy(xpath = "/html/body/app-root/app-signup/div/div/div/form/button")
	WebElement registerButton;

	public WebElement getHomeSignUp() {
		return homeSignUp;
	}

	public WebElement getSignUpButton() {
		return SignUpButton;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getRole() {
		return role;
	}

	public WebElement getconfirmPassword() {
		return confirmPassword;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

}
