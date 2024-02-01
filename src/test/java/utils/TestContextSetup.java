package utils;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
//	public WebDriver driver;
//	public WebDriverWait wait;
	public String homePageActualName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public String checkoutPageProductName;
	public String offersPageActualName;
	
	public TestContextSetup() throws Exception {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.webBrowserManager(), testBase.webDriverWaitManager());
	}
	
}
