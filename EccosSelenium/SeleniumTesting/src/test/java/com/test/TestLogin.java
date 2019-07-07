package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MainConstant;



public class TestLogin extends BaseTest {
	
	@BeforeMethod
	public void navigateToLoginPage() throws InterruptedException {
		loginPage = new LoginPage(driver); 
		try {
		if (loginPage.isLogoutVisible()) {
			loginPage.clickLogout(MainConstant.button_logout);
		}}
		catch(Exception e) {
			System.out.printf("Exception in navigateToLoginPage method",e.getMessage());
		}
	}

	@Test
	@Parameters({"username","password"})
	public void validLoginTest(String username,String password) throws InterruptedException {
	
	    loginPage = new LoginPage(driver);
	    loginPage.Login(username,password);
	    Assert.assertTrue(loginPage.isLogoutVisible());
	    
	}
	
	
	@Test (dataProvider="LoginProvider")
	public void invalidLoginTest(String invUserName , String invPassword) throws InterruptedException {
		
		
	    loginPage = new LoginPage(driver);
		loginPage.Login(invUserName, invPassword);
		
		String errorMessage = loginPage.getElementText(MainConstant.textField_errorMessage);
		
		Assert.assertEquals(errorMessage, MainConstant.text_expectedMessage);
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
