package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class verifyLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException{
		driver =	BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());	
		
	}
		
	@Test
	public void testHomePage() throws IOException{
	//the home page object
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Cheap Flights with Flight Network"));
	
	//the login page object
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);

	//login.loginApplication("amit.kumar@flightnetwork.com", "password");
	login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1)); 
	login.verifymanageTripLink();
	
	}
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}

}
