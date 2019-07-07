package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.MainConstant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataProvider.TabsAndCategoriesData;;

public class TestHome extends BaseTest {
	
	HomePage homePage;
	
	@Test
	@Parameters({"protocolOption"})
	public void selectProtocolFromDropDownListTest(String protocolOption) throws InterruptedException {
		homePage  = new HomePage(driver);
		homePage.selectProtocolItem(protocolOption) ;
		String actualOptionText = homePage.getSelectedProtocolText();
		Assert.assertEquals(actualOptionText, protocolOption);
		
	} 
	
	@Test
	@Parameters({"siteOption"})
	public void selectSiteFromMenuTest(String siteOption) throws InterruptedException {
		homePage  = new HomePage(driver);
		homePage.selectSiteFromDropDownList(siteOption);
		homePage.waitForElementToBeClickable(MainConstant.button_adminProfile, 20);
		Assert.assertEquals(homePage.getElementText(MainConstant.resultSite), siteOption);
	}
	
	@Test(dataProvider="TabsProvider" , dataProviderClass=TabsAndCategoriesData.class)
	public void clickOnTabTest(String tab) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.selectTabFromDashboard(tab);	
		String actualUrl = driver.getCurrentUrl();	
		homePage.waitWhileElementHasAttributeValue("//div[contains(@class, 'loading-dial')]","style","block");
		System.out.printf("Actual URL :"+actualUrl);
		Assert.assertTrue(actualUrl.contains(tab));
		
	}
	
	@AfterMethod
	public void navigateBackToHomePage() throws InterruptedException {
		homePage = new HomePage(driver);
		driver.get("http://213.6.2.241/dashboard/collect"); 
		homePage.waitForElementToBeClickable(MainConstant.button_adminProfile, 20);
		Assert.assertTrue(driver.getCurrentUrl().contains("collect"));
	} 
} 
