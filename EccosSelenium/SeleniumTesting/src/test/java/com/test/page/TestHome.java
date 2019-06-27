package com.test.page;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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
	public static final String  categoryName = "energy";
	public static final String tabName = "review";
	 

	
	
	@Test
	public void selectProtocolFromDropDownListTest() throws InterruptedException {
		homePage  = new HomePage(driver);
		homePage.selectProtocolItem() ;
		String actualOptionText = homePage.getSelectedProtocolText();
		Assert.assertEquals(actualOptionText, HomePage.optionProtocol);
		
	} 
	
	@Test
	public void selectSiteFromMenuTest() throws InterruptedException {
		homePage  = new HomePage(driver);
		 Thread.sleep(2000);
		homePage.selectSiteFromDropDownList();
		Assert.assertEquals(homePage.getElementText(HomePage.resultSite), HomePage.optionSite);
	}
	
	@Test(dataProvider = "CategoriesProvider" , dataProviderClass = TabsAndCategoriesData.class)
	public void selectCategoryTest(String categoryName) throws InterruptedException {
		homePage  = new HomePage(driver); 
		homePage.selectCategory(categoryName) ;
		  
		assertThat(homePage.getCategoryText(categoryName), IsEqualIgnoringCase.equalToIgnoringCase(categoryName));
	} 
	
	@Test(dataProvider="TabsProvider" , dataProviderClass=TabsAndCategoriesData.class)
	public void clickOnTabTest(String tab) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.clickElement(homePage.getDynamicPath(homePage.tabOnDashboard, tab));
		Thread.sleep(3000); 
		
		String actualUrl = driver.getCurrentUrl();	
		Assert.assertTrue(actualUrl.contains(tab));
		
	}
	
	@AfterMethod
	public void navigateBackToHomePage() throws InterruptedException {
		homePage = new HomePage(driver);
		driver.get("http://213.6.2.241/dashboard/collect"); 
		homePage.waitTimeForClickableElement(HomePage.adminProfile,20); 
		 Thread.sleep(1000);
		  
	} 
} 
