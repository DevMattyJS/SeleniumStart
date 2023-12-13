package DropdownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandling {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/register");
		
		WebElement dayOfBirth = driver.findElement(By.name("DateOfBirthDay"));
		WebElement monthOfBirth = driver.findElement(By.name("DateOfBirthMonth"));
		WebElement yearOfBirth = driver.findElement(By.name("DateOfBirthYear"));
		
		// To handle dropdown we need to use WebElement to initialize an appropriate Select object
		// Now we can use a methods to control dropdowns
		Select dayOfBirthDrp = new Select(dayOfBirth);
		Select monthOfBirthDrp = new Select(monthOfBirth);
		Select yearOfBirthDrp = new Select(yearOfBirth);
		
		dayOfBirthDrp.selectByVisibleText("25");		// selects an option based on visible text
		monthOfBirthDrp.selectByValue("6");				// selects an option based on value attribute
		yearOfBirthDrp.selectByIndex(12);				// selects an option based on index (starts from 0)
		
		// Selecting option without using a methods (own implementation)
		List<WebElement> allOptions = monthOfBirthDrp.getOptions(); 
		for (WebElement option : allOptions) {
			if (option.getText().equals("October")) {
				option.click();
				break;
			}
		}
		
		
		
	}
}
