package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenkartCheckoutPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public GreenkartCheckoutPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	By cartBag = By.xpath("//a[@class='cart-icon']/img");
	By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoCodeTestBox = By.xpath("//input[@placeholder='Enter promo code']");
	By promoCodeButton = By.xpath("//button[text()='Apply']");
	By placeOrderButton = By.xpath("//button[text()='Place Order']");
	By product = By.className("product-name");
	
	public void checkoutItems() throws Exception {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(checkoutButton));
//		Thread.sleep(2000);
	}
	
	public String getProductName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		return driver.findElement(product).getText();
	}
	
	public boolean verifyPromoCode() {
		boolean res = driver.findElement(promoCodeTestBox).isDisplayed();
		res = res && driver.findElement(promoCodeButton).isDisplayed();
		return res;
	}
	
	public boolean verifyPlaceOrder() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
}
