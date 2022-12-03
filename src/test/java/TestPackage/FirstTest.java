package TestPackage;

import BasePackage.BaseClass;
import WebPagePackage.LoginClass;
import WebPagePackage.ProductSelection;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseClass {
	

	@BeforeTest
	public void setfilename()
	{
		filename = "MyData";
	}
	
	@Test(dataProvider = "exread",priority=1)
	public void Loginmethod(String username, String password) throws InterruptedException
	{
		
		test = extent.createTest("TC01 First Login Test Case");
		test.assignAuthor("sarathkumar");
		test.assignCategory("Progression Testing");
		LoginClass testclass = new LoginClass(driver);
        
		boolean bol1 = testclass.isUsername();
		Assert.assertTrue(bol1);
		testclass.enterusername(username);
		test.pass("Username is enterd");
		Thread.sleep(3000);
		
		boolean bol2 = testclass.isPassword();
		Assert.assertTrue(bol2);
		testclass.enterpassword(password);
		test.pass("Password is entered");
		Thread.sleep(3000);
		
		testclass.clickLogin();
		test.pass("Login button is clicked");
		Thread.sleep(3000);
		
	}

	@Test(priority=2)
	public void ProductSelectionmethod() throws InterruptedException
	{
		
		test = extent.createTest("TC02 Second Product selection Test Case");
		test.assignAuthor("sarathkumar");
		test.assignCategory("Progression Testing");
		ProductSelection testclass = new ProductSelection(driver);
        
		boolean select = testclass.selectdropdown();
		Assert.assertTrue(select);
		test.pass("Dropdown selected");
		Thread.sleep(3000);
		
		testclass.addshirt();
		test.pass("Shirt is added");
		Thread.sleep(3000);
		
		boolean[] remove = testclass.removeshirt();
		for(boolean bol:remove)
		{
		Assert.assertTrue(bol);
		}
		test.pass("remove button is present");
		Thread.sleep(3000);
		
		boolean cart = testclass.showCart();
		Assert.assertTrue(cart);
		test.pass("products added in cart");
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void LogoutMethod() throws InterruptedException
	{
		test = extent.createTest("TC03 Logout Test Case");
		test.assignAuthor("sarathkumar");
		test.assignCategory("Progression Testing");
		LoginClass testclass = new LoginClass(driver);
		testclass.clickmenu();
		test.pass("Menu for Log out is clicked");
		Thread.sleep(3000);
		
		testclass.clicklogout();
		test.pass("Log Out option is clicked");
		Thread.sleep(3000);
	}


}
