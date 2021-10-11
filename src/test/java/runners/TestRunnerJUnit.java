/*
This file help to run test cases via JUnit
Author:- Vaibhav Khachane
*/

package runners;

import com.cucumber.listener.ExtentProperties;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        reportPrefix="KASH-Report",
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        excludeCoverageTags = {"@flaky"},
        includeCoverageTags = {"@passed"},
        //screenShotLocation = "./report/extent-report/StepScreenshots",
        //outputFolder = "report/extent-report/other-extent-report",
        systemInfoReport = true,
        formats = {"pdf", "png"},
        outputFolder = "report/JUnit_Report/Other_Report/DATE(dd-MM-yyyy)"
)
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:",
                "html:target/cucumber-pretty",
                "html:target/cucumber-html-report",
                "html:target/cucumber.xml",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml",
                "json:target/cucumber.json",
        },
        features = {"src/test/java/features/"},
        glue = {"stepDef"},
        // tags= {"@Notes"},

        monochrome = true
)
public class TestRunnerJUnit {

    @BeforeClass
    public static void setup() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("report/JUnit_Report/" +"KASH_iOS_Testing_Report_"+ timeStamp.replace(":", "_").replace(".", "_") + ".html");

    }


    @AfterClass
    public static void writeExtentReport() {
//
//        String rootPath = System.getProperty("user.dir");
//        // Reporter.loadXMLConfig(new File("D:\\Coinca\\CoincaAutomation\\BitBucketCode\\kash_automated_testing\\src\\test\\resources\\extentconfig.xml"));
//        Reporter.loadXMLConfig(new File(rootPath + "src/resources/extentconfig.xml"));
//        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
//        Reporter.setSystemInfo("Selenium", "3.141.59");
//        Reporter.setSystemInfo("Maven", "3.6.3");
//        Reporter.setSystemInfo("Java Version", "1.8.0_241");
    }
}