package Framework.testng1.errorvalidation;

import org.openqa.selenium.WebElement;
import Framework.testng1.testcomponent.Retry;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import Framework.testng1.testcomponent.TestData;

public class ErrorValidation extends TestData {
	
	@Test(retryAnalyzer= Retry.class)
	public void logInError()
	{
	
	landingPage.logIn("thavithwwu16@gmail.com", "10011998Ad@");
	String error=landingPage.getErrorMessage();
	Assert.assertEquals(error,"Incorrect email or password." );
		
	}
	

}
