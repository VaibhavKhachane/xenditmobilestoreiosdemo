
package screens;

import stepDef.ServiceHooks;
import utilities.Screenshots;
import com.cucumber.listener.Reporter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginElements {

    private final IOSDriver<IOSElement> driver;

    @iOSXCUITFindBy(accessibility = "ID")
    public static MobileElement changeLang;

    @iOSXCUITFindBy(accessibility = "Privacy Policy")
    public static MobileElement homeScreenValText;

    @iOSXCUITFindBy(accessibility = "English")
    public static MobileElement english;

    @iOSXCUITFindBy(accessibility = "Login")
    public static MobileElement loginBtnonFirstScreen;

    @iOSXCUITFindBy(accessibility = "Email")
    public static MobileElement loginscreenValText;

    @iOSXCUITFindBy(accessibility = "e.g. name@email.com")
    public static MobileElement email;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Password\"]")
    public static MobileElement password;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    public static MobileElement LoginBtn;

    @iOSXCUITFindBy(accessibility = "1")
    public static MobileElement one;

    @iOSXCUITFindBy(accessibility = "2")
    public static MobileElement two;

    @iOSXCUITFindBy(accessibility = "3")
    public static MobileElement three;

    @iOSXCUITFindBy(accessibility = "4")
    public static MobileElement four;

    @iOSXCUITFindBy(accessibility = "5")
    public static MobileElement five;

    @iOSXCUITFindBy(accessibility = "6")
    public static MobileElement six;

    @iOSXCUITFindBy(accessibility = "Confirm PIN")
    public static MobileElement confirmPINScreenValText;

    @iOSXCUITFindBy(accessibility = "Create PIN")
    public static MobileElement createPINScreenValText;

    @iOSXCUITFindBy(accessibility = "Skip for now")
    public static MobileElement skipNowBtn;

    @iOSXCUITFindBy(accessibility = "Allow")
    public static MobileElement alertAccept;

    @iOSXCUITFindBy(accessibility = "Home")
    public static MobileElement homeScreenTextVal;

    @iOSXCUITFindBy(accessibility = "Account")
    public static MobileElement accountBtn;

    @iOSXCUITFindBy(accessibility = "Log out")
    public static MobileElement logout;

    @iOSXCUITFindBy(accessibility = "Log out")
    public static MobileElement alertLogout;

    //@AndroidFindBy(accessibility = "Error The email/password combination is invalid")
    //public static MobileElement emailORPasswordWrongValMsg;

    @iOSXCUITFindBy(xpath = "//android.view.View[@content-desc=\"Error The email/password combination is invalid\"]")
    public static MobileElement emailORPasswordWrongValMsg;

    @iOSXCUITFindBy(xpath = "//android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.ImageView")
    public static MobileElement backBtnAftercredentialsErrorMsg;

    public LoginElements(IOSDriver<IOSElement> driver) {
        this.driver = ServiceHooks.driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifySplashScreen() throws Exception {
        try {
            Thread.sleep(5000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_FAIL"));
        }

    }

    public void changeLanguageEnglish() throws Exception {
        try {
            WebDriverWait waitForenglish = new WebDriverWait(ServiceHooks.driver, 30);
            waitForenglish.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("ID")));
            changeLang.click();
            WebDriverWait waitForchangeLang = new WebDriverWait(ServiceHooks.driver, 30);
            waitForchangeLang.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("English")));
            english.click();
            Thread.sleep(2000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ChangeLanguage_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ChangeLanguage_FAIL"));

        }

    }

    public void clickonLoginButton() throws Exception {
        try {
            WebDriverWait waitForloginscreenValText = new WebDriverWait(ServiceHooks.driver, 30);
            waitForloginscreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Privacy Policy")));

            String homeScreenFirstText = homeScreenValText.getAttribute("name");
            System.out.println(homeScreenFirstText);
            //Reporter.addStepLog(msg);
            Assert.assertEquals(homeScreenFirstText, "Privacy Policy");

            WebDriverWait waitForloginBtnonFirstScreen = new WebDriverWait(ServiceHooks.driver, 30);
            waitForloginBtnonFirstScreen .until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login")));
            loginBtnonFirstScreen.click();

            Thread.sleep(2000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreen_FAIL"));

        }

    }


    public void login(String username, String pwd) throws Exception {
        try {
            WebDriverWait waitForloginscreenValText = new WebDriverWait(ServiceHooks.driver, 30);
            waitForloginscreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Email")));

            String loginScreenFirstText = loginscreenValText.getAttribute("name");
            System.out.println(loginScreenFirstText);
            //Reporter.addStepLog(msg);
            Assert.assertEquals(loginScreenFirstText, "Email");

            WebDriverWait waitForemailTextBox = new WebDriverWait(ServiceHooks.driver, 30);
            waitForemailTextBox.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("e.g. name@email.com")));
            email.click();
            email.clear();
            email.sendKeys(username);

            WebDriverWait waitForPasswordTextBox = new WebDriverWait(ServiceHooks.driver, 30);
            waitForPasswordTextBox.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//XCUIElementTypeTextField[@name=\"Password\"]")));
            password.click();
            password.clear();
            password.sendKeys(pwd);

            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreenUserCredentials_PASS"));

            WebDriverWait waitForSubmitBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForSubmitBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Login\"]")));
            LoginBtn.click();

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginScreenUserCredentials_FAIL"));
        }
    }

    public void createAndConfirmPIN() throws Exception {
        try {
//            WebDriverWait waitForcreatePINScreenValText = new WebDriverWait(Test_Env_Setup_AppiumController.driver, 30);
//            waitForcreatePINScreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create PIN")));
//            String createPIN = createPINScreenValText.getAttribute("name");
//            Assert.assertEquals(createPIN, "Create PIN");

            one.click();
            two.click();
            three.click();
            four.click();
            five.click();
            six.click();

//            WebDriverWait waitForconfirmPINScreenValText = new WebDriverWait(Test_Env_Setup_AppiumController.driver, 30);
//            waitForconfirmPINScreenValText.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Confirm PIN")));
//            String confirmPIN = confirmPINScreenValText.getAttribute("name");
//            Assert.assertEquals(confirmPIN, "Confirm PIN");

//            one.click();
//            two.click();
//            three.click();
//            four.click();
//            five.click();
//            six.click();

            //skipNowBtn.click();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("PIN_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("PIN_FAIL"));

        }

    }

    public boolean verifyHomeScreen() throws Exception {
        try {

//            WebDriverWait waitForalertAccept = new WebDriverWait(Test_Env_Setup_AppiumController.driver, 30);
//            waitForalertAccept.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Allow")));
//            alertAccept.click();

            WebDriverWait waitForHomeScreenMsg = new WebDriverWait(ServiceHooks.driver, 30);
            waitForHomeScreenMsg.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Home")));
            String homeScreenFirstText = homeScreenTextVal.getAttribute("name");
            Assert.assertEquals(homeScreenFirstText, "Home");
            Thread.sleep(5000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Home_Screen_Loading_PASS"));

            return true;
        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Home_Screen_Loading_FAIL"));

        }

        return false;
    }
    public void verifyLoginScreenFieldErrorMessageForInvalidEmailOrPassword() throws Exception {
        try {
            WebDriverWait waitForemailORPasswordWrongValMsg = new WebDriverWait(ServiceHooks.driver, 30);
            waitForemailORPasswordWrongValMsg.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@content-desc=\"Error The email/password combination is invalid\"]")));
            String loginErrorMsg = emailORPasswordWrongValMsg.getAttribute("content-desc");
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_PASS"));
            Assert.assertTrue(loginErrorMsg.contains("Error The email/password combination is invalid"));
            backBtnAftercredentialsErrorMsg.click();
        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_FAIL"));
        }

    }

    public void  verifyLoginORHomeScreenTextMsgForUserCredentials() throws Exception {
        try {
//            WebDriverWait waitForalertAccept = new WebDriverWait(Test_Env_Setup_AppiumController.driver, 30);
//            waitForalertAccept.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Allow")));
//            alertAccept.click();

            WebDriverWait waitForHomeScreenMsg = new WebDriverWait(ServiceHooks.driver, 30);
            waitForHomeScreenMsg.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Home")));
            String homeScreenFirstText = homeScreenTextVal.getAttribute("name");
            Assert.assertEquals(homeScreenFirstText, "Home");
            Thread.sleep(5000);
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("LoginORHome_Screen_Loading_PASS"));

            WebDriverWait waitForaccountBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForaccountBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Account")));
            accountBtn.click();

            WebDriverWait waitForLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            logout.click();

            WebDriverWait waitForalertLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForalertLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            alertLogout.click();

            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Loging_Screen_Loading_PASS"));

        } catch (Exception e) {
            e.getStackTrace();

            Thread.sleep(2000);
            String loginErrorMsg = emailORPasswordWrongValMsg.getAttribute("content-desc");
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_PASS"));
            Thread.sleep(5000);
            Assert.assertTrue(loginErrorMsg.contains("Error The email/password combination is invalid"));
            Thread.sleep(5000);
            backBtnAftercredentialsErrorMsg.click();
        }

    }

    public void verifyLoginScreenFieldErrorMessageWhenWrongEmailOrPassword() throws Exception {
        try {
            Thread.sleep(2000);
            String loginErrorMsg = emailORPasswordWrongValMsg.getAttribute("content-desc");
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_PASS"));
            Thread.sleep(5000);
            Assert.assertTrue(loginErrorMsg.contains("Error The email/password combination is invalid"));
            Thread.sleep(5000);
            backBtnAftercredentialsErrorMsg.click();
        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("ErrorMessage_FAIL"));
        }

    }

    public void logout() throws Exception {
        try {
            WebDriverWait waitForaccountBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForaccountBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Account")));
            accountBtn.click();

            WebDriverWait waitForLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            logout.click();

            WebDriverWait waitForalertLogoutBtn = new WebDriverWait(ServiceHooks.driver, 30);
            waitForalertLogoutBtn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Log out")));
            alertLogout.click();

            Thread.sleep(1000);

            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Logout_PASS"));

        } catch (Exception e) {
            e.getStackTrace();
            Reporter.addScreenCaptureFromPath(Screenshots.takeScreenShots("Logout_FAIL"));
        }
    }
}
