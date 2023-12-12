package FindingElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingELements {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		String baseUrl = "https://demo.nopcommerce.com";
		WebDriver driver = new FirefoxDriver();
		
		driver.get(baseUrl);
		
		// findElement() -> return single WebElement (in case of more matching elements, returns the first one)
		//				 -> throws NoSuchElementException, if that element is not present on the page
		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		WebElement searchButton = driver.findElement(By.className("search-box-button"));
		
		searchStore.sendKeys("laptop");		// write "laptop" in a searchbox
		searchButton.click();				// click the search button
		
		// findElements() -> return list of all matching WebElements (List<WebElement>)
		//				  -> in case of no matching elements, returns empty list (no exception)
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='footer']//a"));
		System.out.println("Number of elements captured: " + footerLinks.size());
		
		// get the text of each link and print it into console
		for (WebElement link : footerLinks) {
			String linkText = link.getText();		// getText() -> returns an inner text of HTML element
			System.out.println(linkText);
		}
		
		
	}

}
