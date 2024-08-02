package GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseTest1 {

	public DataUtility data_utility=new DataUtility();
	public commonUtility common_Utility=new commonUtility();
	public static WebDriver listernersDriver;
	public static WebDriver listernerDriver;
	public WebDriver driver;
	
	
	@Parameters("Browser")
  @BeforeClass(alwaysRun = true)
	public void LaunchBrowser(@Optional("Chrome")String browserName) throws IOException {
		if(browserName.equals("Chrome"))
		{
			driver=new EdgeDriver();
		}
//		else if (browserName.equals("Edge")) {
//			driver=new EdgeDriver();
//		}
//		else 
			System.out.println("Enter valid browser name");
		
		
		 driver=new ChromeDriver();
		 listernersDriver=driver;
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(data_utility.getDataFromProperties("url"));
		 
	}
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(data_utility.getDataFromProperties("email"));
	    driver.findElement(By.id("Password")).sendKeys(data_utility.getDataFromProperties("password"));
	    driver.findElement(By.xpath("//input[@value='Log in']")).click();
	    
	}
	@AfterMethod(alwaysRun = true)
	public void logout() {
	    driver.findElement(By.xpath("//a[text()='Log out']")).click();

	
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
		
	}
}