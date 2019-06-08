package com.walmart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.TestBase;
import com.walmart.qa.pages.HomePage;
import com.walmart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	 LoginPage loginPage;
	 HomePage homePage;
	 
	 
	 public LoginPageTest() {
	 super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Walmart Canada");
	}
	
	@Test (priority=2)
	public void walmartLogoImageTest() throws InterruptedException {
		boolean flag = loginPage.validateWalmartImage();
		
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
