package stepDefinitions;

//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.GreenkartHomePage;
import utils.TestContextSetup;

public class GreenkartHomePageStepDefinitions {
	
//	public WebDriver driver;
//	public WebDriverWait wait;
//	public String homePageActualName;
	TestContextSetup testContextSetup;
	GreenkartHomePage homePage;
	
	public GreenkartHomePageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.homePage = testContextSetup.pageObjectManager.getHomePage();
	}

	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
//		WebDriverManager.edgedriver();
//		testContextSetup.driver = new EdgeDriver();
//		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//		testContextSetup.driver.manage().window().maximize();
//		testContextSetup.wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(30));
	}

	@When("User search with shortname {string} in Homepage and extracted actual name of the product")
	public void user_search_with_shortname_in_homepage_and_extracted_actual_name_of_the_product(String shortName) throws Exception {
//		testContextSetup.driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys(shortName);
//		GreenkartHomePage homePage = new GreenkartHomePage(testContextSetup.driver, testContextSetup.wait);
		
		homePage.searchProduct(shortName);
		Thread.sleep(2000);
//		testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='product-name']")));
//		testContextSetup.homePageActualName = testContextSetup.driver.findElement(By.xpath("//h4[@class='product-name']")).getText();
		testContextSetup.homePageActualName = homePage.getProductName();
//		System.out.println("Homepage Actual Name - \"" + testContextSetup.homePageActualName + "\"");
		if(!testContextSetup.homePageActualName.equals("Capsicum")) {
			testContextSetup.homePageActualName = testContextSetup.homePageActualName.split(" -")[0];
		}
		System.out.println("Homepage Actual Name - \"" + testContextSetup.homePageActualName + "\"");
	}
	
	@When("Increase to {string} items of selected product")
	public void increase_to_items_of_selected_product(String number) {
		homePage.increaseItemCount(number);
	}
	
	@When("Add to cart")
	public void add_to_cart() {
		homePage.addToCart();
	}

}
