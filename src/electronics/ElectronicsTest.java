package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
    mouseHoverToElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
    clickOnElement(By.xpath("//a[@href=\"/cell-phones\"]"));
    String actualmessage =getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
    Assert.assertEquals("Cell phones",actualmessage);


    }

    @Test

    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws StaleElementReferenceException {
        //2.1
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2
        mouseHoverAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //2.3
        String exMsg = "Cell phones";
        Assert.assertEquals(exMsg, getTextOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")));
        //2.4
        //clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //2.5
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]")).click();
        //2.6
        String verT = "Nokia Lumia 1020";
        Assert.assertEquals(verT, getTextOnElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")));
        //2.7
        String verTX = "$349.00";
        Assert.assertEquals(verTX, getTextOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[6]/div[1]/span[1]")));
        //2.8
        driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/div[1]/input[1]")).clear();
        setTextOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/div[1]/input[1]"), "2");
        //2.9
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/div[1]/button[1]"));
        //2.10
        String exM = "The product has been added to your shopping cart";
        Assert.assertEquals(exM, getTextOnElement(By.xpath("//body[1]/div[5]/div[1]/p[1]")));

        clickOnElement(By.xpath("//body[1]/div[5]/div[1]/span[1]"));
        //2.11
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.12
        String xMsg="Shopping cart";
        Assert.assertEquals(xMsg,getTextOnElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.13
        String qty="";
        //2.14
        Assert.assertEquals(qty,getTextOnElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]")));
         String xTotal="$698.00";
        Assert.assertEquals(xTotal,getTextOnElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]")));
        //2.15
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17
        String xMessage="Welcome, Please Sign In!";
        Assert.assertEquals(xMessage,getTextOnElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        //2.18
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19
        String xReg="Register";
        Assert.assertEquals(xReg,getTextOnElement(By.xpath("//h1[contains(text(),'Register')]")));
        //2.20
        driver.findElement(By.xpath("//input[@id='FirstName']")).clear();
        setTextOnElement(By.xpath("//input[@id='FirstName']"),"Tushar");
        driver.findElement(By.xpath("//input[@id='LastName']")).clear();
        setTextOnElement(By.xpath("//input[@id='LastName']"),"Vibhakar");
        driver.findElement(By.id("Email")).clear();
        setTextOnElement(By.xpath("//input[@id='Email']"),"tusharvibhakar35@yahoo.com");
        setTextOnElement(By.xpath("//input[@id='Password']"),"Hii369");
        setTextOnElement(By.xpath("//input[@id='ConfirmPassword']"),"Hii369");
        //2.21
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22
        String xVer="Your registration completed";
        Assert.assertEquals(xVer,getTextOnElement(By.xpath("//div[contains(text(),'Your registration completed')]")));
        //2.23
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24
        String xShopCar="Shopping cart";
        Assert.assertEquals(xShopCar,getTextOnElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.25
        clickOnElement(By.id("termsofservice"));
        //2.26
        clickOnElement(By.id("checkout"));
        //2.27
        clickOnElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        selectByTextFromVisibleDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
      //  clickOnElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
    //    selectByTextFromVisibleDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"harrow)");
        setTextOnElement(By.id("BillingNewAddress_City"),"wealdstone");
        setTextOnElement(By.id("BillingNewAddress_Address1"),"44,cecil road");
        setTextOnElement(By.id("BillingNewAddress_ZipPostalCode"),"HA3 5RA");
        setTextOnElement(By.id("BillingNewAddress_PhoneNumber"),"0208621196");
        //2.28
        clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button'and @name='save']"));
        //2.29
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/input[1]"));
        //2.30
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.31
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/input[1]"));
        //2.32
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        selectByTextFromVisibleDropDown(By.xpath("//select[@id='CreditCardType']"),"Visa");
        //2.33
        setTextOnElement(By.xpath("//input[@id='CardholderName']"),"Tvibhakar");
        setTextOnElement(By.xpath("//input[@id='CardNumber']"),"1234 4564 2521 123");
        clickOnElement(By.xpath("//select[@id='ExpireMonth']"));
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"),4);
        clickOnElement(By.xpath("//select[@id='ExpireYear']"));
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"),5);
        setTextOnElement(By.xpath("//input[@id='CardCode']"),"902");
        //2.34
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.35
        String vCredit="Credit Card";
        Assert.assertEquals(vCredit,getTextOnElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        //2.36
        String vShipM="2nd Day Air";
        Assert.assertEquals(vShipM,getTextOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]")));
        //2.37
        String vTotal="$698.00";
        Assert.assertEquals(vTotal,getTextOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]")));
        //2.38
        //String vConfirm="CONFIRM";
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39
        String vThank="Thank you";
        Assert.assertEquals(vThank,getTextOnElement(By.xpath("//h1[contains(text(),'Thank you')]")));
        //2.40
        String vYourOrder="Your order has been successfully processed!";
        Assert.assertEquals(vYourOrder,getTextOnElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        //2.41
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42
        String vWelcome="Welcome to our store";
        Assert.assertEquals(vWelcome,getTextOnElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
        //2.43
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44
        String s=driver.getCurrentUrl();
        Assert.assertEquals(baseUrl,s);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}

