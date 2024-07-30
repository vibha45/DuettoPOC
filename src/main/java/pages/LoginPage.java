package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;

	// 1. String Locators - OR
	private String email = "//input[@name='username']";
	private String continueBtn="//input[@class='continue blueButton']";
	private String password = "//input[@name='password']";
	private String submitBtn = "//input[@type='submit']";

	// 2. page constructor:
	public LoginPage(Page page) {

		this.page = page;
	}
	
	// 3. page actions/methods:
	public String getLoginPageTitle() {

		return page.title();
	}

	public String getLoginPageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}
	/*
	 * public boolean isForgotPwdLinkExist() { return page.isVisible(forgotPwdLink);
	 * }
	 */
	public DuettoAdminPage doLogin(String appUserName, String appPassword) throws InterruptedException {
		System.out.println("App creds: " + appUserName + ":" + appPassword);
		page.fill(email, appUserName);
		page.click(continueBtn);
		page.fill(password, appPassword);
		page.click(submitBtn);
		Thread.sleep(2000);
		return new DuettoAdminPage(page);
	}

}
