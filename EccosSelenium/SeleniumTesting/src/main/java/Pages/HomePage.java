package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		this.driver = driver ; 
		
	}
	
	public void selectSiteFromDropDownList(String siteName) throws InterruptedException {
		waitForElementToAppear(MainConstant.button_adminProfile, 20);
		WebElement element = driver.findElement(MainConstant.button_site);
		clickElementByJavascript(element);
		 List<WebElement> options = getListOfElement(MainConstant.dropdownList_site);
		 System.out.print("Size of List is :"+options.size());
		
		for (WebElement option : options)
		{
			
		     if (option.getText().equals(siteName))
		    {
		    	 System.out.print("Inside If"+option.getText());

		        clickElementByJavascript(option);
		        System.out.print("After Click");

		        clickElementByJavascript(driver.findElement(MainConstant.button_select));	        
		        break;
		    }
		}

	}
	public void selectProtocolItem(String protocolName) {
		try {
			
			selectTextfromDropdownList(MainConstant.dropDownList_protocol ,protocolName);
			waitForElementToBeClickable(MainConstant.button_adminProfile, 20); 			 
		}catch(Exception e) {
			System.out.println("Exception in selectProtocolItem method");
		}
		
	}
	
	public String getSelectedProtocolText() {
		try {
			return getSelectedOptionText(MainConstant.dropDownList_protocol);
			
		}catch(Exception e) {
			return "Exception in selectedProtocolOptionText method";
		}
	}
	
	public String getSelectedSiteText() {
		try {
			String optionTest =  getSelectedOptionText(MainConstant.dropdownList_site);	
			return optionTest ;
		}
		catch(Exception e) {
			return "Exception in selectedSiteOptionText method";
		}
	}
	public By setXpathOfDashboard(String dashboard) {
		return By.xpath("//div[@class='navigation-section flex-row flex-grow-1']/ul/li/a[@ui-sref='dashboard."+dashboard+"']");
	}
	
	public void selectTabFromDashboard(String tabName) {
		WebElement tab = driver.findElement(getDynamicPath(MainConstant.tabOnDashboard, tabName));
		clickElementByJavascript(tab);
		waitForElementToBeClickable(MainConstant.button_adminProfile, 20);
		
	}
	

	
	
	

	

	

}
