package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElementUtil;
import com.qa.opencart.Utils.TimeUtil;

public class ResultsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By searchProductCount = By.cssSelector("div.product-layout");
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getSearchPageTitle(String productName) {
		return eleUtil.waitForTitleContains(productName, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public int getSearchProductsCount() {
	int searchedProductCount=eleUtil.waitForElementsVisible(searchProductCount, TimeUtil.DEFAULT_TIME_OUT).size();
	System.out.println("searched product count "+searchedProductCount);
	return searchedProductCount;
	}
	
	public ProductInfoPage selectProduct(String mainProduct) {
		System.out.println("main product "+mainProduct);
		eleUtil.doClick(By.linkText(mainProduct));
		return new ProductInfoPage(driver);
	}
	
	
}
