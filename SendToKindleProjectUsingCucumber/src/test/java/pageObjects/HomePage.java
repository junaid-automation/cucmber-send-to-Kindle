package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
    }

@FindBy(id = "nav-link-accountList") WebElement signIn;

//Action Method
 public void clickSignIn()
{
	signIn.click();
}
	
}
