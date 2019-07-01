package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Constants.constant;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		this.driver = driver ; 
		
	}
	
	public void selectSiteFromDropDownList(String siteName) throws InterruptedException {
		WaitForElementToClick(constant.button_adminProfile, 20);
		 clickElement(constant.button_site);
		 waitForElementToAppear(constant.menu, 20);
		 
		 try{
			
		 List<WebElement> options = getListOfElement(constant.dropdownList_site);
		
		for (WebElement option : options)
		{
		     if (option.getText().equals(siteName))
		    {
		        option.click();
		        waitForElementToAppear(constant.menu, 20);
		        clickElement(constant.button_select);
		        		        
		        break;
		    }
		}
		}catch(Exception e ) {
			System.out.println("clickElementAction"+e.getMessage());
		}
		WaitForElementToClick(constant.button_adminProfile, 20);
	}
	public void selectProtocolItem(String protocolName) {
		try {
			
			selectTextfromDropdownList(constant.dropDownList_protocol ,protocolName);
			WaitForElementToClick(constant.button_adminProfile, 10); 
//			Thread.sleep(2000);
			 
		}catch(Exception e) {
			System.out.println("Exception in selectProtocolItem method");
		}
		
	}
	
	public String getSelectedProtocolText() {
		try {
			return getSelectedOptionText(constant.dropDownList_protocol);
			
		}catch(Exception e) {
			return "Exception in selectedProtocolOptionText method";
		}
	}
	
	public String getSelectedSiteText() {
		try {
			String optionTest =  getSelectedOptionText(constant.dropdownList_site);	
			return optionTest ;
		}
		catch(Exception e) {
			return "Exception in selectedSiteOptionText method";
		}
	}
	public By setXpathOfDashboard(String dashboard) {
		return By.xpath("//div[@class='navigation-section flex-row flex-grow-1']/ul/li/a[@ui-sref='dashboard."+dashboard+"']");
	}
	
	
	public void selectCategory(String categoryName) {
		clickElement(getDynamicPath(constant.button_category,  categoryName));
		waitForElementToAppear(getCetegoryResultPath(categoryName), 20);
	}
	
	public By getCetegoryResultPath(String categoryName) {
		return getDynamicPath(constant.text_categoryResult, categoryName);
		 
	}
	 
	public String getCategoryText(String categoryName) {
		return getElementText(getCetegoryResultPath(categoryName));
		
	} 
	
	public void selectTabFromDashboard(String tabName) {
		clickElement(getDynamicPath(constant.tabOnDashboard, tabName));
		WaitForElementToClick(constant.button_adminProfile, 20);
		
	}
	
	
	

	

	

}
