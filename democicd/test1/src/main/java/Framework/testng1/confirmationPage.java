package Framework.testng1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.testng1.AbstractComponents.AbstractComponents;

public class confirmationPage extends AbstractComponents{
	WebDriver driver;
	

	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmMessage() {
		return confirmationMessage.getText();
		
	}
	
	
	

}
