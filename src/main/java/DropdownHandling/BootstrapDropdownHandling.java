package DropdownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdownHandling {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		
		// Since dropdown created by bootstrap (no with select tag), we can't use Select object instance 
		WebElement primaryDrp = driver.findElement(By.xpath("//div[@class='btn-group']//button[@class='btn btn-primary dropdown-toggle']"));
		primaryDrp.click();
		
		// Get all options for product type dropdown (li elements of ul element)
		List<WebElement> primaryOptions = driver.findElements(By.xpath("//body/div[@class='container-fluid']/div[@class='row flex-xl-nowrap']/main[@class='col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content']/div[7]/div[1]/div[1]//a"));
		System.out.println("primaryOptions size: " + primaryOptions.size());
//		selectOptionFromDropdown(primaryOptions, "Action");
		for (WebElement option : primaryOptions) {
			System.out.println("Actual option: " + option.getText());
			if (option.getText().equals("Another action")) {
				option.click();
				break;
			}
		}
	}
	
	public static void selectOptionFromDropdown(List<WebElement> options, String value) {
		
		for (WebElement option : options) {
			if (option.getText().equals(value) ) {
				option.click();
				break;
			}
		}
	}
}
