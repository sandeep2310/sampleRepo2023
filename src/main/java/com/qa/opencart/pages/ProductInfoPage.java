package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElementUtil;
import com.qa.opencart.Utils.TimeUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("a.thumbnail");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private Map<String, String> productMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeader() {
		return eleUtil.doGetElementText(productHeader);
	}

	public int getProductImagesCount() {
		return eleUtil.waitForElementsVisible(productImages, TimeUtil.DEFAULT_TIME_OUT).size();
	}

	private void getProductMetadata() {
		List<WebElement> metadataList = eleUtil.getElements(productMetaData);
		System.out.println("product metadata count " + metadataList.size());
		
		for (WebElement e : metadataList) {
			String meta = e.getText();
			String[] metadata = meta.split(": ");
			String mapKey = metadata[0].trim();
			String mapValue = metadata[1].trim();
			productMap.put(mapKey, mapValue);
		}
	}

	private void getProductPricedata() {
		List<WebElement> pricedataList = eleUtil.getElements(productPriceData);
		System.out.println("product metadata count " + pricedataList.size());
		String price = pricedataList.get(0).getText().trim();
		String exprice = pricedataList.get(1).getText().trim();
		productMap.put("actualPrice", price);
		productMap.put("actualEXprice", exprice);

	}
	
	public Map<String, String> getProductInformation() {
		productMap = new HashMap<String, String>();
		getProductMetadata();
		getProductPricedata();
		//System.out.println(productMap);
		return productMap;
			}
	
	
	
	
}
