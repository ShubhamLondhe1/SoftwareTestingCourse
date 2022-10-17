package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class BaseClass1 {
	
	static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		
		
		if(driver == null) {
			
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\softwares\\chromedriver.exe");
				driver = new ChromeDriver();
			}else {
				System.setProperty("webdriver.gecko.driver", "D:\\Software Testing\\softwares\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		
			driver.get("https://www.flipkart.com/");
			driver.manage().window().minimize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			
		}	
		return driver;
	}
	
	
	public static void unloadDriver() {
		driver = null;
	}
	


}
