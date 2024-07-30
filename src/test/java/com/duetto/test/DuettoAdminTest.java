package com.duetto.test;

import com.duetto.base.BaseTest;
import com.duetto.constants.AppConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DuettoAdminTest extends BaseTest {

    @Test(priority = 1)
    public void verifyBackendPageTitleTest() throws InterruptedException {
        duettoAdminPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        String title = duettoAdminPage.getBackendPageTitle();
        System.out.println("Backend page title is: " + title);
        Assert.assertEquals(title, AppConstant.BACKEND_PAGE_TITLE);
    }
    @Test(priority = 2)
    public void verifyBackendPageUrlTest() {

        String pageurl = duettoAdminPage.getBackendPageURL();
        System.out.println("Backend page URL is: " + pageurl);
        Assert.assertEquals(pageurl, AppConstant.BACKEND_PAGE_URL);
    }
    @Test(priority = 3)
    public void verifyNavigatePageHeader() {

        String sideMenuPageHeaderTxt = duettoAdminPage.getHeaderTitle();
        System.out.println("Side menu page header Text is: " + sideMenuPageHeaderTxt);
        Assert.assertEquals(sideMenuPageHeaderTxt, prop.getProperty("headerText"));
    }
    @Test(priority = 4)
    public void verifyUnicornLoginTest() throws InterruptedException {
        dashboardPage = duettoAdminPage.doLoginAsUnicornUser(prop.getProperty("cName").trim());
       // Assert.assertEquals(duettoAdminPage.getLoggedAccountName(),"Hello" + " "+prop.getProperty("accountname"));
    }
}
