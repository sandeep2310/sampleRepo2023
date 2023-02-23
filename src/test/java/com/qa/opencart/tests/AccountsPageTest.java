package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.AppConstants;
import com.qa.opencart.Utils.AppErrors;
import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNT_PAGE_TITLE);
	}
@Test
	public void accPageURLTest() {
		String actURL = accPage.getAccPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.ACC_PAGE_FRACTION_URL), AppErrors.NO_URL_MATCHED);
	}
	
	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}
	
	@Test
	public void logoutExistTest() {
		Assert.assertTrue(accPage.isLogoutExist());
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> accHeaderList = accPage.getAccountsPageSectionsHeaders();
		Assert.assertEquals(accHeaderList, AppConstants.EXPECTED_ACC_HEADERS_LIST);
	}
	
	@DataProvider
	public Object[][] getProductName() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
	@Test(dataProvider = "getProductName")
	public void productSearchTest(String productName) {
		resultsPage = accPage.performSearch(productName);
		String actTitle = resultsPage.getSearchPageTitle(productName);
		System.out.println("search page title "+actTitle);
		softAssert.assertEquals(actTitle, AppConstants.SEARCH_PAGE_TITLE+" "+productName);
		Assert.assertTrue(resultsPage.getSearchProductsCount()>0);
	}
	
	
	
	
	
	
	
	
	
	

}
