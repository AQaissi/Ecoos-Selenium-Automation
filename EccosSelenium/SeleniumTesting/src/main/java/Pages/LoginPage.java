package Pages;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

	By username = By.id("Username");
	By password = By.id("Password");
	By login = By.xpath("//button[@class=\"btn-login pull-right\"]");
	public static By errorMessage = By.xpath("//div[@class='error-message ng-binding']");
	
	
	public static By logout = By.xpath("//a/img[@src='/images/icons/support.png']");
	public LoginPage(WebDriver driver) {
		this.driver = driver  ;
		
	}
	
	
	
	public void Login(String strUserName , String strPassword) {
		setElementText(username,strUserName);
		setElementText(password, strPassword);
		clickElement(login);
	}
	
	
	

}
