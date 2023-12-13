package DropdownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropdownsHandling {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		WebElement drp = driver.findElement(By.id("justAnInputBox"));
		drp.click();
		
//		selectChoiceValues(driver, "choice 3");
//		selectChoiceValues(driver, "choice 4", "choice 5", "choice 7");
		selectChoiceValues(driver, "selectAll");	
		
	}
	
	public static void selectChoiceValues(WebDriver driver, String... values) {
		
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if (values[0].equalsIgnoreCase("selectAll")) {
			
			for (WebElement choice : choiceList) {
				try {
					choice.click();
				} catch (ElementNotInteractableException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		} else {
			
			for (WebElement choice : choiceList) {
				String text = choice.getText();
				for (String value : values) {
					if (value.equalsIgnoreCase(text)) {
						choice.click();
					}
				}
			}
		}	
	}
}
