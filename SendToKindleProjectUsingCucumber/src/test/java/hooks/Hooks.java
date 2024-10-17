package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks 
{
	 WebDriver driver;
     Properties p;
	     
		@Before
	    public void setup() throws IOException
	    {
	    	driver=BaseClass.initilizeBrowser();
	    	    	
	    //	p=BaseClass.getProperties();
	    	driver.get("https://www.amazon.com/sendtokindle");
	    	driver.manage().window().maximize();
		}
	    @After
	    public void tearDown() {
	       driver.quit();
	    }
}
