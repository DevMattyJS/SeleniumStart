package OpenBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class OpenBrowser {
	
	public static void main(String[] args) {
		
		// Chrome driver
//		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		// Firefox driver
//		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		// Using Web Driver Manager
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.facebook.com";
		
		driver.get(baseUrl);
		
		String pageTitle = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		
		System.out.println("Current page title: " + pageTitle);
		System.out.println("CUrrent page URL: " + currentUrl);
//		System.out.println("Current page source: " + pageSource);
		driver.close();
		
	}
}
