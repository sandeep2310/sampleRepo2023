package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.AppConstants;
import com.qa.opencart.Utils.ElementUtil;
import com.qa.opencart.Utils.TimeUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private int i=5;

	// 1. Create Locators for the particular page:

	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPassword = By.linkText("Forgotten Password");

	// 2. Page Constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Page Actions in form of methods:
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}

	public String getLoginPageURL() {
		return eleUtil.waitForUrlContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public boolean isforgotPWDLinkExist() {
		return eleUtil.doIsDisplayed(forgotPassword);
	}
	
	//returns account page object for page chaining
	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("Entered creds "+username);
//		driver.findElement(emailID).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		eleUtil.waitForElementVisible(emailID, TimeUtil.DEFAULT_TIME_OUT).sendKeys(username);;
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
		
		
		
	}
	
	
	
	

}
