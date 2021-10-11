/**
 * Helper file for Wait
 * Currently not useful due to some technical challenges
 * @author  Vaibhav Khachane
 * @since   30/04/2020
 */

package utilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper{

    public IOSDriver<IOSElement> driver;

    public WaitHelper(IOSDriver<IOSElement> driver){

        this.driver = driver;
    }

    public void WaitForElement(WebElement element, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}