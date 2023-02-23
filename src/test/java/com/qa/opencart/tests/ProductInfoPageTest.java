package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void prodInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductDetails() {
		return new Object[][] { { "Macbook", "MacBook Pro" }, { "Macbook", "MacBook Air" }, { "iMac", "iMac" },
				{ "Samsung", "Samsung SyncMaster 941BW" }, { "Apple", "Apple Cinema 30\"" } };
	}

	@Test(dataProvider = "getProductDetails")
	public void productHeaderTest(String searchKey, String productToClick) {
		resultsPage = accPage.performSearch(searchKey);
		productInfoPage = resultsPage.selectProduct(productToClick);
		String actHeader = productInfoPage.getProductHeader();
		Assert.assertEquals(actHeader, productToClick);
	}

	@DataProvider
	public Object[][] getProductImagesCountDetails() {
		return new Object[][] { { "Macbook", "MacBook Pro", 4 }, { "Macbook", "MacBook Air", 4 }, { "iMac", "iMac", 3 },
				{ "Samsung", "Samsung SyncMaster 941BW", 1 }, { "Apple", "Apple Cinema 30\"", 6 } };
	}

	@Test(dataProvider = "getProductImagesCountDetails")
	public void productImageCountTest(String searchKey, String productToClick, int imageCount) {
		resultsPage = accPage.performSearch(searchKey);
		productInfoPage = resultsPage.selectProduct(productToClick);
		int actCount = productInfoPage.getProductImagesCount();
		System.out.println(actCount);
		Assert.assertEquals(actCount, imageCount);
		;
	}
@Test
public void productMetadataTest() {
	resultsPage = accPage.performSearch("Macbook");
	productInfoPage = resultsPage.selectProduct("MacBook Pro");
	Map<String, String> actProdInfoMap = productInfoPage.getProductInformation();
	softAssert.assertEquals(actProdInfoMap.get("Brand"), "Apple");
	softAssert.assertEquals(actProdInfoMap.get("Availability"), "In Stock");
	softAssert.assertEquals(actProdInfoMap.get("Product Code"), "Product 18");
	softAssert.assertAll();
}
	
	
	
	
	
	
}
