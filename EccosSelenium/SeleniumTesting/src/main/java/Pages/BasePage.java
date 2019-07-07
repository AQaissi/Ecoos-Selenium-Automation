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
			try {
			wait = new WebDriverWait(driver, timeout);
		     wait.until(ExpectedConditions.visibilityOfElementLocated(path));}
			catch(Exception e) {
				System.out.println("Element is not appeared");
			}
		
	} 
		
		public void waitForElementToBeClickable(By locator, int timeout) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.elementToBeClickable(locator));

			} catch (Exception e) {
				System.out.println("Element is not clickable,");
			}
		}

		public void waitWhileElementHasAttributeValue(String locator, String attribute, String value) {

			while (driver.findElement(By.xpath(locator)).getAttribute(attribute).contains(value)) {
				
				int timeout = 10;
				if (timeout > 0) {
					timeout--;
					try {
						System.out.println(attribute + "t" + value);
						Thread.sleep(500);
					} catch (Exception e) {
						System.out.print("Element Not Found");
						System.out.printf("Exception of wait loader", e.getMessage());

					}
				}
			}
		}
		
		
		public void clickElementByJavascript(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

		}
		
		
		

	
	  
	  
	
	
	
	

}
