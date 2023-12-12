package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "https://demo.nopcommerce.com/register";
		driver.get(baseUrl);
		
		WebElement searchField = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		
		// isDisplayed() -> return true if element is displayed on the page, false if not
		// isEnabled() -> return true if element is currently enabled (accepts data), false if not
		boolean displayStatus = searchField.isDisplayed();
		boolean enabledStatus = searchField.isEnabled();
		
		System.out.println("Display status: " + displayStatus);
		System.out.println("Enable status: " + enabledStatus);
		
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='gender-female']"));
		// isSelected -> return true if element is selected, false if not
		//			  -> used with radio buttons, check boxes and drop downs
		boolean maleSelectedStatus = maleRadioButton.isSelected();
		boolean femaleSelectedStatus = femaleRadioButton.isSelected();
		
		buttonIsSelected(maleSelectedStatus, "Male radio button");	// false
		maleRadioButton.click();	// selects the male radio button
		maleSelectedStatus = maleRadioButton.isSelected();
		buttonIsSelected(maleSelectedStatus, "Male radio button");  // true
		
//		driver.close();
		
		
	}
	
	public static void buttonIsSelected(boolean buttonStatus, String buttonName) {
		
		if (buttonStatus == true) {
			System.out.println(buttonName + " is currently selected.");
		} else {
			System.out.println(buttonName + " is not selected.");
		}
	}

}
