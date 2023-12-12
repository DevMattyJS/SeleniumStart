package PageNavigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageNavigation {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://demo.nopcommerce.com/register";
		String amazonUrl = "https://www.amazon.com";
		
		driver.get(baseUrl);
		
		// navigate()to() -> functionally same as .get() (it calls the get() method behind the scenes)			  
		driver.navigate().to(amazonUrl);
		driver.navigate().back();		// navigate one page backwards
		driver.navigate().forward();	// navigate one page forward
		driver.navigate().refresh();	// refresh the actual page
		
		
	}
}
