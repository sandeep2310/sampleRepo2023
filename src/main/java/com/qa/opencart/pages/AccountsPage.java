package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.AppConstants;
import com.qa.opencart.Utils.ElementUtil;
import com.qa.opencart.Utils.TimeUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	// page locators
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By logoutLnk = By.linkText("Logout");
	private By accSecheaders = By.cssSelector("div#content h2");
	
	//Constructor
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//Page methods
	
	public String getAccPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.ACCOUNT_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public String getAccPageURL() {
		return eleUtil.waitForUrlContains(AppConstants.ACC_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(search, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public boolean isLogoutExist() {
		return eleUtil.waitForElementVisible(logoutLnk, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccountsPageSectionsHeaders() {
		List<WebElement> secHeadersList = eleUtil.waitForElementsVisible(accSecheaders, TimeUtil.DEFAULT_TIME_OUT);
		List<String> secHeadersValueList = new ArrayList<>();
		for (WebElement e : secHeadersList) {
			String text = e.getText();
			secHeadersValueList.add(text);
		}
		return secHeadersValueList;
	}

	public ResultsPage performSearch(String productName) {
System.out.println("product searched for "+productName);
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doClick(searchIcon);
			return new ResultsPage(driver);
		}
		return null;
	}
	
	
	
	
	
}
