package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenkartOffersPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public GreenkartOffersPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	By searchBox = By.id("search-field");
	By product = By.xpath("//span[text()='Veg/fruit name']/../../../following-sibling::tbody//td[1]");
	
	public void searchProduct(String name) {
		driver.findElement(searchBox).sendKeys(name);
	}
	
	public String getProductName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		return driver.findElement(product).getText();
	}

}
