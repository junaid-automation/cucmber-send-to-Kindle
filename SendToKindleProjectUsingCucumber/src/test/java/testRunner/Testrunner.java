package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		 
		features= {".//Features/SendToKindle.feature"},
		glue={"stepDefinitions","hooks"},
		
				plugin= {"pretty", "html:reports/myreport.html",   
						},
				dryRun=false,    // checks mapping between scenario steps and step definition methods
				monochrome=true   // to avoid junk characters in output
				//publish=true  
		)

public class Testrunner {

}
