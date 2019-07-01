package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Constants.constant;
import DataProvider.ConfigFileReader;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver ; 
 
	public LoginPage loginPage ;
	public String username , password; 
	public WebDriverWait wait;
	
	public ConfigFileReader configfilereader = ConfigFileReader.getConfigFileReader();
	
	@BeforeSuite
	public void setup () {
		
		 if (configfilereader.getPropertyFromFile("browsertype").contentEquals("Chrome")) {   
			 
				System.setProperty("webdriver.chrome.driver","./src/main/resources/Driver/chromedriver.exe");
				 driver = new ChromeDriver();
		 }
		 
		 else if (configfilereader.getPropertyFromFile("browsertype").contentEquals("Firefox")){
			 
				System.setProperty("webdriver.gecko.driver","./src/main/resources/Driver/geckodriver.exe");
				 driver = new FirefoxDriver(); 
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
		 else {
			 System.out.println("Error Browser Name");
		 } 
//	 open url
	    driver.get(configfilereader.getPropertyFromFile("url"));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	}
	
	@BeforeTest
	public void validLoginTest() throws InterruptedException {
		
		username = configfilereader.getPropertyFromFile("username");
		password = configfilereader.getPropertyFromFile("password");
	    loginPage = new LoginPage(driver);
	    loginPage.Login(username,password); 
//	    wait = new WebDriverWait(driver, 20);
//	    wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(constant.button_logout)));
	    
	    ExpectedCondition<Boolean> pageLoadCondition = new
		        ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver driver) {
		            	System.out.println("Script "+((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
		                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		            }
		        };
		    wait = new WebDriverWait(driver, 10);
		    wait.until(pageLoadCondition);

	}
	
	



}
