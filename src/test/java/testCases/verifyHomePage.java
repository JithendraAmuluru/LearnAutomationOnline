package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class verifyHomePage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException{
		driver =	BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());	
		
	}
	
	
	@Test
	public void testHomePage() throws IOException{
		
    
	
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	
	String title=home.getApplicationTitle();
	
	
	Assert.assertTrue(title.contains("Cheap Flights with Flight Network"));
	//System.out.println("My Application title is " +title);
	
	
	}
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}

}
