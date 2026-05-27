package Framework.testng1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.testng1.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="toast-container")
	WebElement errorMessage;

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;
	
	By waitLocator=By.id("toast-container");

	public ProductCatalogue logIn(String eMail, String passWord) {
		email.sendKeys(eMail);
		password.sendKeys(passWord);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTo() {
		driver.get("http://rahulshettyacademy.com/client");
	}
	
	

	public String getErrorMessage() {
		waitTillElementAppear(waitLocator);
		return errorMessage.getText();
	}


}
