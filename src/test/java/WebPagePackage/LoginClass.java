package WebPagePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {

	@CacheLookup
	@FindBy(id="user-name")
	private WebElement userName;
	
	@CacheLookup
	@FindBy(id="password")
	private WebElement passwd;
	
	@FindBy(id="login-button")
	private WebElement login;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	
	public RemoteWebDriver driver = null;
	
	
	
	public LoginClass(RemoteWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUsername()
	{
		return userName.isDisplayed();
	}
	
	public void enterusername(String username)
	{
		userName.sendKeys(username);
		
	}
	public boolean isPassword()
	{
		return passwd.isDisplayed();
	}
	
	public void enterpassword(String password)
	{
		passwd.sendKeys(password);
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public void clickmenu()
	{
	    menu.click();
	}
	
	public void clicklogout()
	{
	   logout.click();
	}
}
