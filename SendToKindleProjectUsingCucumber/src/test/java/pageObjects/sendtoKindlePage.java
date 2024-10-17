package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class sendtoKindlePage extends BasePage
{

	public sendtoKindlePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "email") WebElement emailtxt;
	@FindBy(id = "continue") WebElement contiuebtn;
	@FindBy(id = "ap_password") WebElement pwdtxt;
	@FindBy(id = "signInSubmit") WebElement signInBtn;
	@FindBy(xpath = "//span[@id='s2k-dnd-rsf-heading-text']") WebElement dragdrop;
	@FindBy(xpath = "//button[@id='s2k-dnd-add-your-files-button']") WebElement select_files_device;
	@FindBy(xpath = "//span[normalize-space()='add more files']") WebElement add_more_files;
	@FindBy(xpath = "//button[@id='s2k-r2s-send-button']") WebElement sendbtn;
	
	
	//Actions Method
	public void setEmail(String email)
	{
		emailtxt.sendKeys(email);
	}
	public void clickcontinuebtn()
	{
		contiuebtn.click();
	}
	public void setpwd(String pwd)
	{
		pwdtxt.sendKeys(pwd);
	}
	public void clickSignInbtn()
	{
		signInBtn.click();
	}
	
	Actions act=new Actions(driver);
	public void draganddrop()
	{
		act.moveToElement(dragdrop);
        act.perform();
	}
	
	//selectOptionfromdevice
	public void clickselectoption()
	{
		select_files_device.click();
	}
	
	public void clickAddMoreFiles()
	{
		add_more_files.click();
	}
	public void clicksendbtn()
	{
		sendbtn.click();
	}
	
	
}
