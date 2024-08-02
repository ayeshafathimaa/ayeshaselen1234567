package GenericLibrary;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
DataUtility data_utility=new DataUtility();
public WebDriver driver;
//public static WebDriver listernerDriver;
	public void LaunchBrowser() throws FileNotFoundException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get(data_utility.getDataFromProperties("url"));
		// driver.get("https://demowebshop.tricentis.com/");
	  }
	
	listenerDriver=driver;
	public void Login() throws FileNotFoundException {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys(data_utility.getDataFromProperties("email"));
		driver.findElement(By.id("Password")).sendKeys(data_utility.getDataFromProperties("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
}
	public void Logout() {
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	public void closeBrowser() {
		driver.close();
	}
	
}
