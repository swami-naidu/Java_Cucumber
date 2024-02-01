package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenkartHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public GreenkartHomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public By searchBox = By.xpath("//input[@type = 'search']");
	public By product = By.xpath("//h4[@class='product-name']");
	public By topDeals = By.linkText("Top Deals");
	public By incrementBtn = By.className("increment");
	public By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");
	
	public void searchProduct(String productName) {
		driver.findElement(searchBox).sendKeys(productName);
	}
	
	public String getProductName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		return driver.findElement(product).getText();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public void switchToChildWindow() {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		String parentWindow = driver.getWindowHandle(), childWindow = null;
		Set<String> windows = driver.getWindowHandles();
		for(String i: windows) {
			if(!i.equals(parentWindow))
				childWindow = i;
		}
		driver.switchTo().window(childWindow);
	}
	
	public void increaseItemCount(String num) {
		int n = Integer.parseInt(num);
		for(int i = 1; i < n; i++) {
			driver.findElement(incrementBtn).click();
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}
	
}
