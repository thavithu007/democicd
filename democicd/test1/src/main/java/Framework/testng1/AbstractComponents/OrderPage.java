package Framework.testng1.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents{
public WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderList;
	
	public Boolean verifyOrderList(String productName) {
		boolean match=orderList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	

}
