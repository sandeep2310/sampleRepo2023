package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.Utils.AppConstants;
import com.qa.opencart.Utils.AppErrors;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 3)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("login page title " + actualTitle);
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE, AppErrors.NO_TITLE_MATCHED);
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		System.out.println("login page URL " + actualURL);
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), AppErrors.NO_URL_MATCHED);
	}

	@Test(priority = 1)
	public void forgotPasswordLinkExists() {
		Assert.assertTrue(loginPage.isforgotPWDLinkExist());
	}

	@Test(priority = 4)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutExist(), AppErrors.LOGIN_UNSUCCESSFUL);
	}

}
