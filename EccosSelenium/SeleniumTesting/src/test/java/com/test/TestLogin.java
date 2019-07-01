package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Constants.constant;
import Pages.HomePage;
import Pages.LoginPage;



public class TestLogin extends BaseTest {

	@Test
	@Parameters({"username","password"})
	public void validLoginTest(String username,String password) throws InterruptedException {
	
	    loginPage = new LoginPage(driver);
	    loginPage.Login(username,password);
	    By logout = By.xpath("//a/img[@src='/images/icons/support.png']");
	    Assert.assertTrue(loginPage.isLogoutVisible());
	    
	}
	
	
	@Test (dataProvider="LoginProvider")
	public void invalidLoginTest(String invUserName , String invPassword) throws InterruptedException {
		
		
	    loginPage = new LoginPage(driver);
		loginPage.Login(invUserName, invPassword);
		
		String errorMessage = loginPage.getElementText(constant.textField_errorMessage);
		
		Assert.assertEquals(errorMessage, constant.text_expectedMessage);
	}
	
	@DataProvider(name="LoginProvider") 
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "ablaqaissi@ecoos.com", "ecoos6" },
            { "admin@ecoos.co", "test1" },
            { "", "" } 
            
        };

    }
	
	
	
}
