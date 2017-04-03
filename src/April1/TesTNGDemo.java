package April1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TesTNGDemo {
	FirefoxDriver driver;

	@Test
	public void FirstTest() throws IOException
	{
		driver=new FirefoxDriver();
		driver.get("http://www.google.co.in");
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		
		Assert.assertTrue(driver.getTitle().contains("Gmail"),"Google Page is displayed");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("C:\\raiAutomation\\Tutorial\\src\\Pass_ScreenShot\\screenshot.png"));
		
	}
	
	@AfterTest
	public void truncket()
	{
		System.out.println("Successful Complete the Test Case");
		driver.close();
	}
}
