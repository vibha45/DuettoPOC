package com.duetto.test;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.duetto.base.BaseTest;
import com.duetto.constants.AppConstant;
import pages.LoginPage;

public class LoginTest extends BaseTest {


	@Test(priority = 1)
	public void loginPageNavigationTest() {
		 //loginPage.navigateToLoginPage();
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstant.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void verifyLoginTest() throws InterruptedException {
		duettoAdminPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		//Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		Assert.assertEquals(duettoAdminPage.getLoggedAccountName(),"Hello" + " "+prop.getProperty("accountname"));
	}


}
