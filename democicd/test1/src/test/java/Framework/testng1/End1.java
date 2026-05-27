package Framework.testng1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Framework.testng1.LandingPage;

public class End1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String production="ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rahulshettyacademy.com/client");
		LandingPage lan=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("thavithu15@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("10011998Ad@");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().contains(production)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(production));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		driver.findElement(By.cssSelector("button.ng-star-inserted:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String[] oId=driver.findElement(By.xpath("//tbody/tr[@class='ng-star-inserted']")).getText().split(" ");
		String orderId=oId[1];
		System.out.println(orderId);
		
		
		
		

	}

}
