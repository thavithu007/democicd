package Framework.testng1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.testng1.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(css="[placeholder='Select Country']")
	WebElement location;
	
	@FindBy(css="button.ng-star-inserted:nth-child(3)")
	WebElement exactLocation;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(location, countryName).build().perform();
		exactLocation.click();
		
		
		
		
	}
	
public confirmationPage placeOrder() {
	placeOrder.click();
	return new confirmationPage(driver);
		
	}

	
	//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
	//driver.findElement(By.cssSelector("button.ng-star-inserted:nth-child(3)")).click();
	//driver.findElement(By.cssSelector(".action__submit")).click();
	

}
