package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class verifyLoginPageWithReports {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		report = new ExtentReports("./Reports/LoginPageReport.html",true);
		
		logger = report.startTest("Verify Test Login");
		
		//logger = new ExtentTest("Verify Test Login","This page will verify manage mytrips link");
		
		driver =	BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
		
		
	}
		
	@Test
	public void testHomePage() throws IOException{
	//the home page object
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("Cheap Flights with Flight Network"));
	logger.log(LogStatus.PASS, "HomePage verified successfully and verified");
	
	//the login page object
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);

	//login.loginApplication("amit.kumar@flightnetwork.com", "password");
	login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
	logger.log(LogStatus.PASS, "Login to Application");
	login.verifymanageTripLink();
	logger.log(LogStatus.PASS,"My Trips link Found");
	
	}
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
