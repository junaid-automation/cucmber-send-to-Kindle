package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	 static WebDriver driver;
	 //static Properties p;
	
	 public static WebDriver initilizeBrowser()
	 {
		 driver=new ChromeDriver();
		 driver.manage().deleteAllCookies(); 
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 return driver;
	 }
	 public static WebDriver getDriver()
	 {
			return driver;
	 }

}
