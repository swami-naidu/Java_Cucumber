package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {
	
	WebDriver driver;
	WebDriverWait wait;

	public PageObjectManager(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public GreenkartHomePage getHomePage() {
		GreenkartHomePage homePage = new GreenkartHomePage(driver, wait);
		return homePage;
	}
	
	public GreenkartOffersPage getOffersPage() {
		GreenkartOffersPage offersPage = new GreenkartOffersPage(driver, wait);
		return offersPage;
	}
	
	public GreenkartCheckoutPage getCheckoutPage() {
		GreenkartCheckoutPage checkoutPage = new GreenkartCheckoutPage(driver, wait);
		return checkoutPage;
	}
	
}
