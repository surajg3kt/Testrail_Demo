package base;


import org.eclipse.sisu.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.testRailManager.testRailManager;

import io.cucumber.java.ParameterType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest 
{
	protected String testcaseid;
    public static WebDriver driver;
    
    
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.youtube.com");
		String url = null;
		
	}
	
	@AfterTest
	public void teardown() 
	{
		//driver.quit();
	}
	
    @AfterMethod
    public void addresultstotestrail(ITestResult result)
    {
    	if(result.getStatus()==ITestResult.SUCCESS)
    	{testRailManager.addResultsForTestcase(testcaseid, testRailManager.test_case_pass_status, "");}
    	
    	else if(result.getStatus()==ITestResult.FAILURE)
    	{testRailManager.addResultsForTestcase(testcaseid, testRailManager.test_case_fail_status, "test got failed"+ result.getTestName()+":Failed");}
    	
    }
}
