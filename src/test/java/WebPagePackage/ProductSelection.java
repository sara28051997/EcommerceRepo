package WebPagePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductSelection {
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement dropdown;
	
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement addshirt1;
	
	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
	private WebElement addshirt2;
	
	@FindBy(id = "remove-sauce-labs-bolt-t-shirt")
	private WebElement removeshirt1;
	
	@FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
	private WebElement removeshirt2;
	
	@FindBy(xpath="//span[text()='2']")
	private WebElement cart;
	
	public RemoteWebDriver driver = null;
	
	public ProductSelection(RemoteWebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean selectdropdown()
	{
		Select sel = new Select(dropdown);
		sel.selectByValue("hilo");
		WebElement ele = sel.getFirstSelectedOption();
		return ele.isSelected();
	}
	
	public void addshirt()
	{
		addshirt1.click();
		addshirt2.click();
	}
	
	public boolean[] removeshirt()
	{
		boolean[] bol = new boolean[2];
		bol[0]= removeshirt1.isDisplayed();
		bol[1] = removeshirt2.isDisplayed();
		
		return bol;
		
	}
	
	public boolean showCart()
	{
		return cart.isDisplayed();
	}

}
