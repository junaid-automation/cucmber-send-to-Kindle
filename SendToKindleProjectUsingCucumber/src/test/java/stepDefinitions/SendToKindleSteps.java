package stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.sendtoKindlePage;
import utilities.DataReader;

public class SendToKindleSteps {
	HomePage hp;
	sendtoKindlePage kp;
	List<HashMap<String, String>> datamap; //Data driven
	@Given("Navigate to the Send to Kindle Page login Page")
	public void navigate_to_the_send_to_kindle_page_login_page() 
	{
	  hp=new HomePage(BaseClass.getDriver()) ;
	  hp.clickSignIn();
	}

	@Then("user send all files by passing email and password with the excel {string}")
	public void user_send_all_files_by_passing_email_and_password_with_the_excel(String rows) throws InterruptedException, AWTException
	{
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\SendtoKindleExcel.xlsx", "Sheet1");

	     int index=Integer.parseInt(rows)-1;
	     String skemail= datamap.get(index).get("username");
	     String skpassword= datamap.get(index).get("password");
	     
	     //Array List for the file location
	     ArrayList pathlist=new ArrayList();
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\sample DOC file.docx");
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\Sample GIF.gif");
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\Sample JPEG file.jpeg");
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\Sample JPG file.jpg");
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\Sample pdf file.pdf");
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\Sample PNG file.png");
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\Sample txt file.txt");
			pathlist.add("C:\\Users\\ajuneeth\\Pictures\\SendtoKindle\\sample1.html");
			
			
			ArrayList filetype=new ArrayList();
			filetype.add("Enter 0 to select .docx file");
			filetype.add("Enter 1 to select .GIF file");
			filetype.add("Enter 2 to select .JPEG file");
			filetype.add("Enter 3 to select .JPG file");
			filetype.add("Enter 4 to select .PDF file");
			filetype.add("Enter 5 to select .PNG file");
			filetype.add("Enter 6 to select .txt file");
			filetype.add("Enter 7 to select .html file");
			
			for(int a=0;a<filetype.size();a++)
			{
				System.out.println(filetype.get(a));
			}
			
			//getting the user wish list 
			ArrayList user_wish=new ArrayList();
			int no_of_type = 6;
			for(int b=0;b<no_of_type;b++)
			{
				//System.out.println("Select the choice "+(b+1)+":");
				user_wish.add(b, b);
				
			}
			kp=new sendtoKindlePage(BaseClass.getDriver());
			kp.setEmail(skemail);
			kp.clickcontinuebtn();
			kp.setpwd(skpassword);
			kp.clickSignInbtn();
			Thread.sleep(1000);
			kp.draganddrop();
			kp.clickselectoption();
			
			 Robot rb=new Robot();
	           
		        for(int c=0;c<user_wish.size();c++) 
		        	{
		        	if(c!=0)
		        	{
		        	kp.clickAddMoreFiles();
		        	}
		       StringSelection str1=new StringSelection ((String) pathlist.get((int) user_wish.get(c)));
		    
		       Thread.sleep(2000);
		       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);
		      
		       rb.keyPress(KeyEvent.VK_CONTROL);
		       rb.keyPress(KeyEvent.VK_V);
		       rb.keyRelease(KeyEvent.VK_CONTROL);
		       rb.keyRelease(KeyEvent.VK_V);
		       
		       rb.keyPress(KeyEvent.VK_ENTER);
		       rb.keyRelease(KeyEvent.VK_ENTER);
		        	
		       System.out.println("printing the string selection value: "+str1);
		        	
		       Thread.sleep(2000);
		       
   }
		        kp.clicksendbtn();		
			
	}


}
