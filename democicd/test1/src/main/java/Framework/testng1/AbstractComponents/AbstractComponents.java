package Framework.testng1.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.testng1.CartPage;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//By waitLocator=By.cssSelector(".mb-3");
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	

	public void waitTillElementAppear(By waitLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitLocator));
		
	}
	public void waitTillElementDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	 
	public CartPage goToCart() {
		cart.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
		
	}
	public OrderPage goToOrder() {
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
		
		
	}

}
