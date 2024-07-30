package com.duetto.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;

import pages.DashboardPage;
import pages.DuettoAdminPage;
import pages.LoginPage;
import util.PlaywrightFactory;

public class BaseTest{
	PlaywrightFactory pf;
	Page page;
	public Properties prop;
 

	public LoginPage loginPage;
	public DuettoAdminPage duettoAdminPage;
	public DashboardPage dashboardPage;
 
	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlaywrightFactory();
 
		prop = pf.init_prop();
 
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
 
		page = pf.initBrowser(prop);
		loginPage = new LoginPage(page);
	}
 
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
