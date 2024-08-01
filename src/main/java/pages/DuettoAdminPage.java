package pages;

import com.microsoft.playwright.Page;

public class DuettoAdminPage {
    private Page page;
    private String loggedInUser="//div[@class='login']";
    private String sideLink="//a[text()='Companies']";
    private String headerTitle="//span[@class='title']";
    private String searchText="//input[@placeholder='Name']";
    private String ctbledata="//table[@id='company_list_179']";
    private String unicornBtn="(//button[text()='Login as Unicorn'])[1]";

    public DuettoAdminPage(Page page) {

        this.page = page;
    }
    public boolean verifyLoggedAccountName() {
        return page.isVisible(loggedInUser);
    }
    public String getLoggedAccountName() {
        return page.textContent(loggedInUser);
    }
    public String getBackendPageTitle() {

        return page.title();
    }
    public String getBackendPageURL() {
        String url =  page.url();
        System.out.println("page url : " + url);
        return url;
    }

    public String getHeaderTitle()
    {
        page.click(sideLink);
        String headerTitleTxt=page.textContent(headerTitle);
        System.out.println("Page header Title : "+headerTitleTxt);
        return headerTitleTxt;
    }
    public DashboardPage doLoginAsUnicornUser(String cName) throws InterruptedException {
        page.fill(searchText,cName);
        page.press(searchText,"Backspace");

       page.isVisible(ctbledata);
        page.click("//a[text()='"+cName+"']");
        page.click(unicornBtn);
        Thread.sleep(2000);

        return new DashboardPage(page);


    }

}
