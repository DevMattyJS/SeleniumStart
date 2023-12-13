package DropdownHandling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedDropdown {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.twoplugs.com");
		
		WebElement livePostingLink = driver.findElement(By.xpath("//a[text()='Live Posting']"));
		livePostingLink.click();
		
		WebElement categoryElement = driver.findElement(By.name("category_id"));
		Select categoryDrp = new Select(categoryElement);
		List<WebElement> categories = categoryDrp.getOptions();
		categories.remove(0);			// remove "all" option to check if happy path works as well
		
		boolean areCategoriesSorted = isSorted(categories);
		
		if(areCategoriesSorted) {
			System.out.println("Categories dropdown options are sorted");
		} else {
			System.out.println("Categories dropdown options are not sorted.");
		}

	}
	
	public static boolean isSorted(List<WebElement> options) {
		
		List<String> optionsOriginal = new ArrayList();
		List<String> optionsTemp = new ArrayList();
		
		for (WebElement option : options) {
			
			optionsOriginal.add(option.getText());
			optionsTemp.add(option.getText());
		}
		
		optionsTemp.sort(Comparator.naturalOrder());
		
		return optionsOriginal.equals(optionsTemp);
	}

}
