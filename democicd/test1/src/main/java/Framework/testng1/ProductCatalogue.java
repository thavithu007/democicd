package Framework.testng1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.testng1.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
    WebElement spinner;

	By waitLocator1 = By.cssSelector(".mb-3");
	By addCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	

	public List<WebElement> getProductList() {
		waitTillElementAppear(waitLocator1);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().contains(productName)).findFirst()
				.orElse(null);
		return prod;
	}
	public void addToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addCart).click();
		waitTillElementAppear(toastMessage);
		waitTillElementDisappear(spinner);
		

		
		}
}
