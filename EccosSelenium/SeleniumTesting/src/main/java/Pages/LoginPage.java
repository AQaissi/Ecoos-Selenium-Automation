package Pages;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constants.constant;

public class LoginPage extends BasePage {


	
	public LoginPage(WebDriver driver) {
		this.driver = driver  ;
		
	}
	
	
	
	public void Login(String strUserName , String strPassword) {
		setElementText(constant.textField_username,strUserName);
		setElementText(constant.textField_password, strPassword);
		clickElement(constant.button_login);
	}
	
	public boolean isLogoutVisible() throws InterruptedException {
		return isElementDisplayed(constant.button_logout);
		
	}
	
	

}
