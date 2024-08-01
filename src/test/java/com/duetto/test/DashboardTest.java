package com.duetto.test;

import com.duetto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(priority = 1)
    public void verifyDashboardPageTitleTest() throws InterruptedException {
        duettoAdminPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        dashboardPage=duettoAdminPage.doLoginAsUnicornUser(prop.getProperty("cName").trim());
        String title = dashboardPage.getDashboardPageTitle();
        System.out.println("Dashboard page title is: " + title);
        Assert.assertEquals(title, prop.getProperty("dashboardPageTitle"));
    }
    /*@Test(priority = 2)
    public void verifyBackendPageUrlTest() {

        String pageurl = dashboardPage.getDashboardPageURL();
        System.out.println("Dashboard page URL is: " + pageurl);
        Assert.assertEquals(pageurl, AppConstant.BACKEND_PAGE_URL);
    }*/
}
