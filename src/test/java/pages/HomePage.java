package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		
		this.driver=driver;
		
	}
	@FindBy(xpath=".//*[@id='my-account']/span[1]") WebElement MyAccountLink;
	@FindBy(xpath=".//*[@id='fna_signin-new']") WebElement SignInLink;
	@FindBy(xpath=".//*[@id='fn_up_login_form_drowssap1']") WebElement Password;
	@FindBy(xpath=".//*[@id='btn_login_cont']/input[2]") WebElement Submit;
	@FindBy(xpath=".//*[@id='support']/span[2]") WebElement Support;
	@FindBy(xpath=".//*[@id='fna_newtofn-new']") WebElement NewAccount;
		
	public void myAccountLink(){
		MyAccountLink.click();
		SignInLink.click();
	}
	public void createAccountLink(){
		MyAccountLink.click();
		NewAccount.click();
	}
	public void supportLink(){
		Support.click();
	}
	
	public String getApplicationTitle(){
		
		return driver.getTitle();
	}

}
