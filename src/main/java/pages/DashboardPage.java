package pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
    private Page page;
    public DashboardPage(Page page) {

        this.page = page;
    }
    public String getDashboardPageTitle() {

        return page.title();
    }
    public String getDashboardPageURL() {
        String url =  page.url();
        System.out.println("page url : " + url);
        return url;
    }
}
