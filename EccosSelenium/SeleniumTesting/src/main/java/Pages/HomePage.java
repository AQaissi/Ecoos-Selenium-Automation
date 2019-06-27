package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
	//Locators for Site DropDown Menu
	By siteDropDownList = By.xpath("//li/div");
	By siteDropDownButton = By.xpath("/html/body/section/section/header/div/div[1]/a[1]");
	By selectButton = By.xpath("//div[@class='modal-footer']/button[@ng-click='vm.submit()']");
	public static String optionSite = "Adama Demo";
	public static By resultSite = By.xpath("/html/body/section/section/header/div/div[1]/a[1]/p[1]");
	
	//Locators for Protocol DropDown Menu
	By protocolDropDownList = By.xpath("//div[2]/div/select");
	public static String optionProtocol = "Israel Pollutant Release and Transfer Register (PRTR)";
	public static String allProtocols = "All Protocols";

	
	//Locators for Search Assets
	public By selectAsset = By.xpath("//div/div[@class='select-assets']/button");
	public By assetTypes = By.xpath("");
	
	//Locators for category
	public static String category = "//div[@class='collect-category ";
	public static String categoryResult = "//div[@class='assets-sidebar__title']/span[@class='name ";
	
	//Locators for tabs
	public static String tabOnDashboard = "//div[@class='navigation-section flex-row flex-grow-1']/ul/li/a[@ui-sref='dashboard.";
	
	// Locators for wait
	public static By adminProfile = By.xpath("//div/div/a[@ui-sref='setup.assets']");
	public By menu = By.xpath("//div/div[@class='popup ng-scope']");

	 
 	
	public HomePage(WebDriver driver) {
		this.driver = driver ; 
		
	}
	
	public void selectSiteFromDropDownList() throws InterruptedException {
	
		 clickElement(siteDropDownButton);
		 
		try {
		waitTimeForVisibilityOfElement(menu, 20);
		 List<WebElement> options = getListOfElement(siteDropDownList);
//		System.out.print("Size Of List "+options.size());
		
		for (WebElement option : options)
		{
		     if (option.getText().equals(optionSite))
		    {
		    	
		        option.click();
		        waitTimeForVisibilityOfElement(menu, 20);
		        clickElement(selectButton);
		        waitTimeForClickableElement(adminProfile, 20); 		        
		        break;
		    }
		}
		
		}catch(Exception e ) {
			System.out.println("clickElementAction"+e.getMessage());
		}
	}
	public void selectProtocolItem() {
		try {
			
			getSelectedVisibleText(protocolDropDownList , optionProtocol);
//			waitTimeForClickableElement(adminProfile , 20); 
			
			Thread.sleep(2000);
			 
		}catch(Exception e) {
			System.out.println("Exception in selectProtocolItem method");
		}
		
	}
	
	public void selectAllProtocols() {
		try {
			
			getSelectedVisibleText(protocolDropDownList , allProtocols);
//			 waitTimeForClickableElement(adminProfile,20); 
		}catch(Exception e) {
			System.out.println("Exception in selectProtocolItem method");
		}
	}
	
	public String getSelectedProtocolText() {
		try {
			return getSelectedOptionText(protocolDropDownList);
			
		}catch(Exception e) {
			return "Exception in selectedProtocolOptionText method";
		}
	}
	
	public String getSelectedSiteText() {
		try {
			String optionTest =  getSelectedOptionText(siteDropDownList);	
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
		 
		clickElement(getDynamicPath(category,  categoryName));
		waitTimeForVisibilityOfElement(getCetegoryResultPath(categoryName), 20);
	}
	
	public By getCetegoryResultPath(String categoryName) {
		return getDynamicPath(categoryResult, categoryName);
		 
	}
	 
	public String getCategoryText(String categoryName) {
		return getElementText(getCetegoryResultPath(categoryName));
		
	} 
	

	

	

}
