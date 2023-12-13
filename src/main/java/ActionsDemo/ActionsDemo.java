package ActionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement searchField = driver.findElement(By.id("small-searchterms"));
		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		Actions builder = new Actions(driver);
		Action searchForLaptop = builder.moveToElement(searchField)
								.click()
								.sendKeys("laptop")
								.moveToElement(searchButton)
								.click()
								.build();
		
		
		searchForLaptop.perform();
		
		
	}

}
