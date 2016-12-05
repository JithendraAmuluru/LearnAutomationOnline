package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		
		this.driver=ldriver;
	}
	
	@FindBy(xpath=".//*[@id='my-account']/span[1]") WebElement myAccount;
	@FindBy(xpath=".//*[@id='fna_signin-new']") WebElement signInlink;
	@FindBy(id="fn_up_login_form_email_id1") WebElement userName;
	@FindBy(id="fn_up_login_form_drowssap1") WebElement password;
	@FindBy(xpath="//input[@value='Sign In']") WebElement signInButton;
	
	By manageTrips = By.xpath(".//*[@id='manage-trips']/span[1]");

	public void loginApplication(String user, String pass){
		myAccount.click();
		signInlink.click();
		userName.sendKeys(user);
		password.sendKeys(pass);
		signInButton.click();
	}
	
	public void verifymanageTripLink(){
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(manageTrips));
		//String text = ele.getCssValue("txt-lable");
		//System.out.println("text" +ele);
		 Assert.assertEquals(manageTrips,manageTrips,"Manage my Trips link not present");
		 System.out.println("testing");
		
	}
	
}
