package TestPackage;

import BasePackage.BaseClass;
import WebPagePackage.LoginClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseClass {
	

	@BeforeTest
	public void setfilename()
	{
		filename = "MyData";
	}
	
	@Test(dataProvider = "exread")
	public void testmethod(String username, String password)
	{
		
		test = extent.createTest("TC01 First Login Test Case");
		test.assignAuthor("sarathkumar");
		test.assignCategory("Progression Testing");
		LoginClass testclass = new LoginClass(driver);
        
		boolean bol1 = testclass.isUsername();
		Assert.assertTrue(bol1);
		testclass.enterusername(username);
		test.pass("Username is enterd");
		
		boolean bol2 = testclass.isPassword();
		Assert.assertTrue(bol2);
		testclass.enterpassword(password);
		test.pass("Password is entered");
		
		testclass.clickLogin();
		test.pass("Login button is clicked");
		
		testclass.clickmenu();
		test.pass("Menu for Log out is clicked");
		
		testclass.clicklogout();
		test.pass("Log Out option is clicked");
	}


}
