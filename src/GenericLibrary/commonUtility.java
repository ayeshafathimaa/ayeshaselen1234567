package GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class commonUtility {

	public void takeScreenShot(WebDriver driver,String name) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./ScreenShot/"+name+".png");
		try {
			FileHandler.copy(scr, trg);
		}
		catch (IOException e) {
// TODO: handle exception
			e.printStackTrace();
		}
		}
		
	}
