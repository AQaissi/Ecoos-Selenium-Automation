package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Constants.constant;
import Pages.HomePage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataProvider.TabsAndCategoriesData;;

public class TestHome extends BaseTest {
	
	HomePage homePage;
	
	@Test
	public void selectProtocolFromDropDownListTest() throws InterruptedException {
		homePage  = new HomePage(driver);
		homePage.selectProtocolItem(constant.text_optionProtocol) ;
		String actualOptionText = homePage.getSelectedProtocolText();
		Assert.assertEquals(actualOptionText, constant.text_optionProtocol);
		
	} 
	
	@Test
	public void selectSiteFromMenuTest() throws InterruptedException {
		homePage  = new HomePage(driver);
		homePage.selectSiteFromDropDownList();
		
		Assert.assertEquals(homePage.getElementText(constant.resultSite), constant.text_optionSite);
	}
	
	@Test(dataProvider = "CategoriesProvider" , dataProviderClass = TabsAndCategoriesData.class)
	public void selectCategoryTest(String categoryName) throws InterruptedException {
		homePage  = new HomePage(driver); 
		homePage.WaitForElementToClick(constant.button_adminProfile, 20);
		homePage.selectCategory(categoryName) ;
		  
		assertThat(homePage.getCategoryText(categoryName), IsEqualIgnoringCase.equalToIgnoringCase(categoryName));
	} 
	
	@Test(dataProvider="TabsProvider" , dataProviderClass=TabsAndCategoriesData.class)
	public void clickOnTabTest(String tab) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.clickElement(homePage.getDynamicPath(constant.tabOnDashboard, tab));	
		String actualUrl = driver.getCurrentUrl();	
		Assert.assertTrue(actualUrl.contains(tab));
		
	}
	
	@AfterMethod
	public void navigateBackToHomePage() throws InterruptedException {
		homePage = new HomePage(driver);
		driver.get("http://213.6.2.241/dashboard/collect"); 
		homePage.WaitForElementToClick(constant.button_adminProfile,20); 
		Thread.sleep(2000);
		 
		  
	} 
} 
