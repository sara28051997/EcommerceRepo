package BasePackage;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.ExcelRead;

public class BaseClass {
	public RemoteWebDriver driver = null;
	public String filename= "";
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@DataProvider(name="exread")
	public String[][] excelread()
	{
		String [][] data = ExcelRead.getExcelData(filename);
		return data;
	}
	@BeforeClass
	public void openbrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "C://Users//DELL//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		reporter = new ExtentSparkReporter("./NewReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@AfterClass
	public void closebrowser()
	{
		extent.flush();
		driver.quit();
	}

}
