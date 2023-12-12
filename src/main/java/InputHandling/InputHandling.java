package InputHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputHandling {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement pwdField = driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement rememberMe = driver.findElement(By.xpath("//input[@id='RememberMe']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		System.out.println(emailField.getAttribute("value"));	// gets the value of input field (text)
		emailField.clear();							// clear the actual value in the field
		emailField.sendKeys("admin123@gmail.com");	// input text into an email input field
		System.out.println(emailField.getAttribute("value"));
		
		pwdField.clear();
		pwdField.sendKeys("admin12345");
		rememberMe.click();
		loginButton.click();		
	
	}

}
