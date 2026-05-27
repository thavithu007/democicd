package Framework.testng1;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.testng1.AbstractComponents.OrderPage;
import Framework.testng1.testcomponent.TestData;

public class End1C extends TestData {
	//String productName = "ZARA COAT 3";

	@Test(dataProvider="getDataa",groups= {"Purchase"})
	public void Ecom(HashMap<String,String> input) throws IOException, InterruptedException{
		// TODO Auto-generated method stub

		
		String countryName = "ind";

		ProductCatalogue productCatalogue = landingPage.logIn(input.get("email"), input.get("password"));

		// List<WebElement> listproduct=prod.getProductList();
		productCatalogue.addToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.checkProductInCart(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		confirmationPage confirmationPage = checkoutPage.placeOrder();
		String confirmationMessage = confirmationPage.getConfirmMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		

	}
	@Test(dependsOnMethods= {"Ecom"})
	public void verifyOrderHistory() {
    ProductCatalogue productCatalogue = landingPage.logIn("thavithu15@gmail.com", "10011998Ad@");
    OrderPage orderPage=productCatalogue.goToOrder();
    Assert.assertTrue(orderPage.verifyOrderList("ZARA COAT 3"));
    
		
		
	}
	@DataProvider
	public Object[][] getData() {
		return new Object[][]  {{"thavithu15@gmail.com","10011998Ad@","ZARA COAT 3"},{"thavithu15@gmail.com","10011998Ad@","ADIDAS ORIGINAL"}};
	}
	@DataProvider
	public Object[][] getDataa() throws IOException {
		/*HashMap<String,String> map=new HashMap<String,String>();
		map.put("email","thavithu15@gmail.com");
		map.put("password", "10011998Ad@");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email","thavithu15@gmail.com");
		map1.put("password", "10011998Ad@");
		map1.put("product", "ADIDAS ORIGINAL");
		return new Object[][] {{map},{map1}};*/
		//List<HashMap<String,String>> data=getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Framework\\testng1\\dataprovider\\data.json");
		//return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
		List<HashMap<String,String>> data=getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Framework\\testng1\\dataprovider\\data.json");
		return new Object[][] {{data.get(0)}};
	}
	

}
