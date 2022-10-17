package testClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass1;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class testClass1 {
	
	static WebDriver driver;
	
	LoginPage lp;
	HomePage hp;
	
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		driver = BaseClass1.getDriver(browser);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}
	
	
	@Test
	public void test1() throws InterruptedException {
		lp.enterEmailID();
		lp.enterPassword();
		lp.clickOnSubmitBtn();
		
		String profileName = hp.getProfileName();
		
		Assert.assertEquals(profileName, "Akshay","Profile name is not matching");
		

	}
	
	@AfterMethod
	public void afterMethod(){
		
	}
	
	
	@AfterClass
	public void afterClass() {
		
	}

	

}
