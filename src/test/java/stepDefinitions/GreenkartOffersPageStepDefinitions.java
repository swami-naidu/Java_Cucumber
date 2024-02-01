package stepDefinitions;

import static org.testng.Assert.assertEquals;

//import java.util.Set;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GreenkartHomePage;
import pageObjects.GreenkartOffersPage;
import utils.TestContextSetup;

public class GreenkartOffersPageStepDefinitions {
	
//	public WebDriver driver;
//	public WebDriverWait wait;
//	public String homePageActualName, offersPageActualName;
//	public String offersPageActualName;
	TestContextSetup testContextSetup;
	
	public GreenkartOffersPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@When("User search for shortname {string} in Offerspage and extracted actual name of the product")
	public void user_search_for_shortname_in_offerspage_and_extracted_actual_name_of_the_product(String shortName) {
		switchToOffersPage();
//		GreenkartOffersPage offersPage = new GreenkartOffersPage(testContextSetup.driver, testContextSetup.wait);
		GreenkartOffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchProduct(shortName);
//		testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
		testContextSetup.offersPageActualName = offersPage.getProductName();
//		testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Veg/fruit name']/../../../following-sibling::tbody//td[1]")));
//		offersPageActualName = testContextSetup.driver.findElement(By.xpath("//span[text()='Veg/fruit name']/../../../following-sibling::tbody//td[1]")).getText();
		System.out.println("Offerspage Actual Name - \"" + testContextSetup.offersPageActualName + "\"");
	}
	
	public void switchToOffersPage() {
		GreenkartHomePage homePage = testContextSetup.pageObjectManager.getHomePage();
//		GreenkartHomePage homePage = new GreenkartHomePage(testContextSetup.driver, testContextSetup.wait);
		homePage.selectTopDealsPage();
//		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
//		testContextSetup.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//		String parentWindow = testContextSetup.driver.getWindowHandle(), childWindow = null;
//		Set<String> windows = testContextSetup.driver.getWindowHandles();
//		for(String i: windows) {
//			if(!i.equals(parentWindow))
//				childWindow = i;
//		}
//		testContextSetup.driver.switchTo().window(childWindow);
		homePage.switchToChildWindow();
	}

	@Then("Check if the actual product name is same in both Homepage and Offerspage")
	public void check_if_the_actual_product_name_is_same_in_both_homepage_and_offerspage() {
		assertEquals(testContextSetup.offersPageActualName, testContextSetup.homePageActualName);
	}
	
}
