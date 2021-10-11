/**
 * This file start and stop APPIUM session
 *
 * @author  Vaibhav Khachane
 * @since   30/04/2020
 */

package stepDef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ServiceHooks {

    // Variables Initialization
    public static IOSDriver<IOSElement> driver;
    private static String Appium_Node_Path;
    private static String Appium_JS_Path;
    private static String platformName;
    private static String deviceName;
    private static String platformVersion;
    private static String automationName;
    private static String newCommandTimeout;
    private static String autoGrantPermissions;
    private static String unicodeKeyboard;
    private static String resetKeyboard;
    private static String fastReset;
    static String service_url;
    private String appiumPort;
    private String serverIp;

    // Variable to set system default path
    public static String rootPath = System.getProperty("user.dir");

    // Variable to start APPIUM service through Java code
    AppiumDriverLocalService service;

    // Set Kash iOS build build Path
    File filePath = new File(System.getProperty("user.dir"));
    File appDir = new File(filePath, "/app/21-09-2021");
    File app = new File(appDir, "Runner-2.app");


    /**
     * This method used to start APPIUM session
     * Read data from config.properties file
     * Init Session using desired capabilities
     * Start APPIUM session
     */
    @Before
    public IOSDriver<IOSElement> start() throws MalformedURLException {

        // Variable to access properties file ex. config.properties
        Properties pro = new Properties();

        try {
            // Load config.properties file
            //InputStream input = new FileInputStream(rootPath + "\\src\\test\\java\\Config\\config.properties"); // Syntax used only for Windows Machine
            InputStream input = new FileInputStream(rootPath + "/src/test/java/config/config.properties");  // Syntax used only for for mac machine
            pro.load(input);

            // Read data from config.properties file
            Appium_Node_Path = pro.getProperty("Appium_Node_Path");
            Appium_JS_Path = pro.getProperty("Appium_JS_Path");
            platformName = pro.getProperty("platformName");
            deviceName = pro.getProperty("deviceName");
            platformVersion = pro.getProperty("platformVersion");
            automationName = pro.getProperty("automationName");
            newCommandTimeout = pro.getProperty("newCommandTimeout");
            autoGrantPermissions = pro.getProperty("autoGrantPermissions");
            unicodeKeyboard = pro.getProperty("unicodeKeyboard");
            resetKeyboard = pro.getProperty("resetKeyboard");
            fastReset = pro.getProperty("fastReset");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Start APPIUM Session
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().   //Start Appium implementation 1
                usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
                withAppiumJS(new File(Appium_JS_Path)));

        service.start();
        service_url = service.getUrl().toString();


        // Setup APPIUM Session according target device capabilities and test automation ENV
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.SUPPORTS_ALERTS, "true");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20000");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("autoGrantPermissions", "autoGrantPermissions");

        String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";  //Start appium providing dynamic url
        driver = new IOSDriver<>(new URL(service_url), capabilities);

        // Implicit wait used to wait all Mobile Elements
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // This variable returns for each test case execution
        return driver;
    }

    /**
     * This method used to stop APPIUM session
     * capture screenshot for reports
     * Reset App
     */
    @After
    public void stop(Scenario scenario) {

       // Capture screenshot of PASS and FAIL
        if (scenario.isFailed()) {

            System.out.println(scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.embed(screenshot, "image/png");
        } else {
            System.out.println(scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.embed(screenshot, "image/png");

        }

        // Stop APPIUM session
        if (driver != null) {

            driver.resetApp(); // Reset app
            driver.quit(); // Close APPIUM session
        }
    }
}

