package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor ;




public class BasePage {
	
	WebDriver driver ; 
	public WebDriverWait wait ;

	

	public void clickElement(By locator) {
		driver.findElement(locator).click();
		
	}
	
	public void setElementText(By locator , String text) {
		
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
		
	}
	
	public void clearField(By locator) {
		driver.findElement(locator).clear();
		
	}
	
	
	public boolean isElementDisplayed(By locator) throws InterruptedException {
		WaitForElementToClick(locator , 20);
		return driver.findElement(locator).isDisplayed();
		
	}
	
	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	  public void selectTextfromDropdownList(By locator , String text) {
	  WebElement element =  driver.findElement(locator);
	  Select select = new Select(element);
	  select.selectByVisibleText(text);
	  
	 }
	  
	  public String getSelectedOptionText(By locator ) {
		  WebElement element= driver.findElement(locator);
		  Select select = new Select(element);
		  String optionText = select.getFirstSelectedOption().getText();
		  return optionText ; 
		  
	  }
	  
	  public List<WebElement> getListOfElement( By locatorItem) throws InterruptedException {
		  
			List<WebElement> options = driver.findElements(locatorItem);
			
			return options ;
	  }
	  
	  public boolean isElementEnabled(By locator){
		  return driver.findElement(locator).isEnabled();
	  }
	  
	  
		public By getDynamicPath(String xpath , String name) { 
			 String locator = xpath + name + "']" ; 
			 return By.xpath(locator);
			  
		}
		
		public void waitForElementToAppear(By path , int timeout) {
			wait = new WebDriverWait(driver, timeout);
		     wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		
	} 
		
//		public  boolean  WaitForElementToClick(By path , int timeout) {
//			wait = new WebDriverWait(driver, timeout);
//			boolean isPresent = false;
//	 if(    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(path)) != null) {
//			 isPresent  = driver.findElement(path).isDisplayed(); 
//			  System.out.println("Element is clickable " + isPresent);
//			  return isPresent ;
//		 }else {
//			 
//			  System.out.println("Element is not clickable ");
//
//		 }
//		return isPresent; 
//		 
//	}
		
		public void WaitForElementToClick(By path , int timeout) {
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
