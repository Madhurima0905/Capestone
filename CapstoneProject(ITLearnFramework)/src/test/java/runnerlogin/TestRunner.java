package runnerlogin;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	
		
		                                        features="src/test/java/featurepage/login.feature",
	                                                glue={"logincondition","com.itlearn.hooks" },
	plugin= {"pretty",
			"html:CReports/cucumberReport.html",
			"json:CReports/cucumberReport.json",
			"junit:CReports/cucmberReport.xml"
	         },
	
	tags="@all"
	//publish=true
	
	
		)

public class TestRunner {
}
