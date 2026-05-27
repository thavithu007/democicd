package Framework.featurefile;

import java.io.IOException;

import org.testng.Assert;

import Framework.testng1.CartPage;
import Framework.testng1.CheckoutPage;
import Framework.testng1.LandingPage;
import Framework.testng1.ProductCatalogue;
import Framework.testng1.confirmationPage;
import Framework.testng1.testcomponent.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseImplementation extends TestData{
	
	public ProductCatalogue productCatalogue;
	public LandingPage landingPage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public confirmationPage confirmationPage;
	@Given("Launch the Ecommerce Application")
	public void Launch_the_Ecommerce_Application() throws IOException {
		landingPage=launchApplication();
			}
	@Given("^Log in with email (.+) and password (.+)$")
	public void Log_in_with_email_and_password(String email,String password) {
		
		productCatalogue = landingPage.logIn(email,password);
				}
	@When("^Add product (.+) to the cart$")
	public void Add_product_to_the_cart(String productName) {
		productCatalogue.addToCart(productName);
		cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.checkProductInCart(productName);
		Assert.assertTrue(match);
	}
	@And("^checkout product (.+) and submit order$")
	public void checkout_product_and_submit_order(String countryName) {
		checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		 confirmationPage = checkoutPage.placeOrder();
	}
	@Then("Verify {string} confirmation message is displayed")
	public void Verify_confirmation_message_is_displayed(String string) {
		String confirmationMessage = confirmationPage.getConfirmMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
		driver.close();
		
	}
	@Then("Verify {string} error message is displayed")
	public void Verify_error_message_is_displayed(String string) {
		String error=landingPage.getErrorMessage();
		Assert.assertEquals(error,string );
		
	}

}
