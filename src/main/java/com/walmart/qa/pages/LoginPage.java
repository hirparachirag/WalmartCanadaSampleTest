/**
 * 
 */
package com.walmart.qa.pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.walmart.qa.base.TestBase;

/**
 * @author chira
 * @param <JavascriptExecutor>
 *
 */
public class LoginPage extends TestBase {
	
	//Page Factory or Object Repository:
	
	@FindBy(id="login-form-email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="account-signin-btn")
	WebElement loginButton;
	
	@FindBy(xpath="//img[@id='logo'][1]")
	WebElement loginPageLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateWalmartImage() {
		 Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", loginPageLogo);
		 return ImagePresent;
	}
	
	
	
	public HomePage login(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		loginButton.click();
		
		return new HomePage(); 
	}
	
	
	
	
	

	
}
