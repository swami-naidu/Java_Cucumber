package stepDefinitions;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import pageObjects.GreenkartCheckoutPage;
import utils.TestContextSetup;

public class GreenkartCheckoutPageStepDefinitions {
	
	TestContextSetup testContextSetup;
	GreenkartCheckoutPage checkoutPage;

	public GreenkartCheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("User proceeds to checkout page and validate the items in checkout page")
	public void user_proceeds_to_checkout_page_and_validate_the_items_in_checkout_page() throws Exception {
		checkoutPage.checkoutItems();
		testContextSetup.checkoutPageProductName = checkoutPage.getProductName();
		System.out.println("Checkout page Product name - \"" + testContextSetup.checkoutPageProductName + "\"");
		assertTrue(testContextSetup.checkoutPageProductName.contains(testContextSetup.homePageActualName));
	}
	
	@Then("Verify the ability of user to enter the promocode and place the order")
	public void verify_the_ability_of_user_to_enter_the_promocode_and_place_the_order() {
		assertTrue(checkoutPage.verifyPromoCode());
		assertTrue(checkoutPage.verifyPlaceOrder());
	}
	
}
