/**
 * Login Runner File
 *
 * @author  Vaibhav Khachane
 * @since   30/04/2020
 *
 */


package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/java/features/Login.feature",    // Feature file location
        glue = {"stepDef"},                                  // Step Def file location
        tags = {"~@Ignore"},
        dryRun = false,                                             //checking the complete implementation of all the mentioned steps present in the Feature file.
        monochrome = true,                                          //True=the console output for the Cucumber test are much more readable

        // Following code for Extent Report and Cucumber JVM Report Generation
        format = {
                "com.cucumber.listener.ExtentCucumberFormatter:report/maven-JVM-report/Maven-Extent-Reports/XenditMobileStore-Extent-Report.html",
                "html:report/cucumber-html-report/cucumber-pretty",
                "html:target/cucumber-html-report",
                "html:target/cucumber.xml",
                "json:target/cucumber1.json",
                "json:jsonReports/TC_001_LoginFeatureRunner.json",
                "pretty:target/cucumber-pretty.txt",
                "junit:target/cucumber-results.xml"
        })

// Following Code is for TestNG execution
public class LoginRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
    }

}
