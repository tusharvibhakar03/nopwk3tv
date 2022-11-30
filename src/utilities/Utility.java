package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Utility extends BaseTest {

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void mouseHoverToElement(By by) {
        Actions a = new Actions(driver);
        WebElement e = driver.findElement(by);
        a.moveToElement(e).build().perform();
    }

    public void setTextOnElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        //select by value
        select.selectByIndex(index);
    }

    public void selectByTextFromVisibleDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        selectByValueFromDropDown(by, value);
    }

    public void mouseHoverAndClick(By by) {

        Actions a = new Actions(driver);
        WebElement e = driver.findElement(by);
        a.moveToElement(e).click().build().perform();
    }

    public String getTextOnElement(By by) {
        return driver.findElement(by).getText();

    }
        /**
         * This method will get text from element
         */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

//************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    // Homework 4 Method acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)

    //************************** Select Class Methods ***********************************************

    /**
     *  This method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */

    /**
     * This method will select the option by index
     */

    /**
     * This method will select the option by contains text
     */

    //***************************** Window Handle ************************************
    //***************************** Action Class *************************************
// mouseHoverToElement(By by), mouseHoverToElementAndClick(By by)
}
