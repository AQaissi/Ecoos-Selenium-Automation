package com.test;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import DataProvider.ConfigFileReader;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.LoginPage;
import Pages.MainConstant;

public class BaseTest {
	
	public WebDriver driver ; 
 
	public LoginPage loginPage ;
	public String username , password; 
	public WebDriverWait wait;
	
	public ConfigFileReader configfilereader = ConfigFileReader.getConfigFileReader();
	
	
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup () {
		
		 if (configfilereader.getPropertyFromFile("browsertype").contentEquals("Chrome")) {   
			 
				System.setProperty("webdriver.chrome.driver","./src/main/resources/Driver/chromedriver.exe");
				 driver = new ChromeDriver();
				 driver.manage().deleteAllCookies();
		 }
		 
		 else if (configfilereader.getPropertyFromFile("browsertype").contentEquals("Firefox")){
			 
				System.setProperty("webdriver.gecko.driver","./src/main/resources/Driver/geckodriver.exe");
				 driver = new FirefoxDriver(); 
				 driver.manage().deleteAllCookies();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
		 else {
			 System.out.println("Error Browser Name");
		 } 
	    driver.get(configfilereader.getPropertyFromFile("url"));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	}
	
	@BeforeTest
	public void validLoginTest() throws InterruptedException {
		
		username = configfilereader.getPropertyFromFile("username");
		password = configfilereader.getPropertyFromFile("password");
	    loginPage = new LoginPage(driver);
	    loginPage.Login(username,password); 
	   loginPage.waitForElementToAppear(MainConstant.button_adminProfile, 20);
	   Assert.assertTrue(loginPage.isLogoutVisible());
	}
	
	



}
