package Pages;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {


	
	public LoginPage(WebDriver driver) {
		this.driver = driver  ;
		
	}
	public void Login(String strUserName , String strPassword) {
		setElementText(MainConstant.textField_username,strUserName);
		setElementText(MainConstant.textField_password, strPassword);
		clickElement(MainConstant.button_login);
	}
	
	public boolean isLogoutVisible() throws InterruptedException {
		
		return isElementDisplayed(MainConstant.button_logout);
		
	}
	public void clickLogout(By locator) {
		waitForElementToBeClickable(MainConstant.button_logout, 20);
		driver.findElement(locator).click();
		
	}
	
	

}
