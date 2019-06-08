package com.walmart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.walmart.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	
	
	
	
	
	public TestBase()  {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\chira\\OneDrive\\Desktop\\Selenium_Workspace\\WalmartTest\\src\\main\\java\\com\\walmart\\qa\\config\\config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}}
	
	public void initialization() {
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\chira\\OneDrive\\Desktop\\SeleniumJars/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browsername.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\chira\\OneDrive\\Desktop\\SeleniumJars/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		List<WebElement> popup = driver.findElements(By.id("accept-privacy-policies"));
		if(popup.size()>0) {
			popup.get(0).click();
		}
	
	}
	
	
	
	
	
	
	

}
