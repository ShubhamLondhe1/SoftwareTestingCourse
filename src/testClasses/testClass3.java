package testClasses;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass1;
import graphql.Assert;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.ProfilePage;

public class testClass3 {
	
static WebDriver driver;
	
	LoginPage lp;
	HomePage hp;
	ProfilePage pp;
	
	String oldAddressCount;
	String newAddressCount;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		
		driver = BaseClass1.getDriver(browser);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}
	
	
	@Test(priority = 4)
	public void verifyUserCanOpenProfilePage() {
		
		//hover on profileName
		hp.hoverProfileName();
		
		//click on my profile
		hp.clickOnMyProfile();
		
		//check page is opened
		boolean onPage = pp.checkUserOnProfilePage();
		
		Assert.assertTrue(onPage);	
		
		oldAddressCount = String.valueOf(pp.getAddressCount());
		
	}
	
	@DataProvider(name="addressData")
	public Object[][] getData() {
		
		Object[][] k = {{"Akshay", "8956235623","413512","Nanded Road", "B-22, A pune"}, {"Sneha","7845124512", "411023", "Warje", "A-32, B shivaji nagar, near english school"}};
		return k;
	}
	
	@Test(priority = 5, dataProvider="addressData")
	public void addNewAddress(String name, String phone, String pincode, String locality, String fullAddress) {
		
		pp.clickOnManageAddress();
		
		List<String> addressDetails = Arrays.asList(name, phone, pincode, locality, fullAddress);
		
		pp.addNewAddress(addressDetails);
		
		newAddressCount = String.valueOf(pp.getAddressCount());
		
		boolean isCountMatching = newAddressCount.equals(oldAddressCount);
		
		Assert.assertFalse(isCountMatching);
		
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
		BaseClass1.unloadDriver();
		
	}
	
	
	
	
	
	

}
