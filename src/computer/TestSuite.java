package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
@Test

   public void verifyProductArrangeInAlphaBaticalOrder(){
    // Find Computers & Desktop  links and click on both  links
    WebElement ComputersLink = driver.findElement(By.linkText("Computers"));
    ComputersLink.click();
    clickOnElement(By.linkText("Computers"));
    clickOnElement(By.linkText("Desktops"));
    WebElement dropDown = driver.findElement(By.name("products-orderby"));
    Select select = new Select(dropDown);
    select.selectByValue("6"); // Z to A
    List<WebElement> manageBookingList= driver.findElements(By.xpath("//span[contains(text(),'Sort by')]"));
    List<String> h = new ArrayList<String>();
    for(WebElement p:manageBookingList){
        h.add(p.getText());
    }
    selectByTextFromVisibleDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
    List<WebElement> manageBookingList1= driver.findElements(By.xpath("//span[contains(text(),'Sort by')]"));
    List<String> t = new ArrayList<String>();
    for(WebElement q:manageBookingList){
        t.add(q.getText());
    }
    Collections.sort(h);
    Assert.assertEquals(h,t);

}

@Test
    public void verifyPrductAddedToShoppingCartSuccessFully ()throws StaleElementReferenceException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers ')]")); //2.1
        clickOnElement(By.partialLinkText("Desktops"));//2.2
        clickOnElement(By.name("products-orderby"));
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");//2.3
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Build your own computer", expectedMessage, actualMessage); //2.5

        clickOnElement(By.name("product_attribute_1"));//2.4
        driver.findElement(By.xpath("//select[@id='product_attribute_1']")).click();

    WebElement dropDown = driver.findElement(By.name("product_attribute_1"));
    Select select = new Select(dropDown);
    select.selectByValue("1");

    WebElement dropdown1 = driver.findElement(By.name("product_attribute_2"));
    Select select1 = new Select(dropdown1);
    select1.selectByValue("5");

  driver.findElement(By.xpath("//input[@id=\"product_attribute_3_7\"]")).click();
  driver.findElement(By.xpath("//input[@id=\"product_attribute_4_9\"]")).click();
  driver.findElement(By.xpath("//input[@id=\"product_attribute_5_12\"]")).click();

    String actualMessage1 = getTextFromElement(By.xpath("//span[@id='price-value-1'and contains(text(),'$1,475.00')]"));
    Assert.assertEquals("$1,475.00", actualMessage1);

    driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-1\"]")).click();

    String actualMessage2 = getTextFromElement(By.xpath("//p[@class='content']"));
    Assert.assertEquals("The product has been added to your shopping cart", actualMessage2);

  driver.findElement(By.xpath("//span[@class=\"close\"]")).click();

    //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
    //2.15 Verify the message "Shopping cart"
    String actual="Shopping cart";
    Assert.assertEquals(actual,getTextOnElement(By.xpath("//span[contains(text(),'Shopping cart')]")));
    clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
    // clickOnElement(By.xpath("//input[@id='itemquantity11253' and @class='qty-input']"));

    driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[5]"));

    driver.findElement(By.xpath("//td[@class='quantity']//input[@value='1']")).clear();
    sendTextToElement(By.xpath("//td[@class='quantity']//input[@value='1']"),"2");
    clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));

    String actualMessage4= getTextFromElement(By.xpath("//span[@class='product-subtotal' and contains(text(),'$2,950.00')]"));
    Assert.assertEquals("$2,950.00", actualMessage4);

    driver.findElement(By.name("termsofservice")).click();
    driver.findElement(By.name("checkout")).click();

    String actualMessage5 = getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1"));
    Assert.assertEquals("Welcome, Please Sign In!",actualMessage5);

//    driver.findElement(By.xpath("//button[@class=\"button-1 checkout-as-guest-button\"]"));

    clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
    setTextOnElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"TUSHAR");
    setTextOnElement(By.xpath("//input[@id=\"BillingNewAddress_LastName\"]"),"VIBHAKAR");
    setTextOnElement(By.xpath("//input[@id=\"BillingNewAddress_Email\"]"),"tvibhaker@gmail.com");
    clickOnElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
    selectByIndexFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),1);
    clickOnElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
    selectByTextFromVisibleDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"AA (Armed Forces Americas)");
    setTextOnElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
    setTextOnElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Harrow");
    setTextOnElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA3 5RA");
    setTextOnElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"01234567");
    clickOnElement(By.xpath("//button[@class=\"button-1 new-address-next-step-button\"]"));
    clickOnElement(By.xpath("//label[@for=\"shippingoption_1\"]"));
    clickOnElement(By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]"));
    clickOnElement(By.xpath("//*[@id=\"payment-method-block\"]/li[2]/div/div[2]/label "));
    clickOnElement(By.xpath("//button[@class=\"button-1 payment-method-next-step-button\"]"));
    clickOnElement(By.xpath("//select[@id='CreditCardType']"));
    selectByTextFromVisibleDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
    setTextOnElement(By.xpath("//input[@id='CardholderName']"),"T VIBHAKAR");
    setTextOnElement(By.xpath("//input[@id='CardNumber']"),"4235 7889 1234  6789");
    clickOnElement(By.xpath("//select[@id='ExpireMonth']"));
    selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"),3);
    clickOnElement(By.xpath("//select[@id='ExpireYear']"));
    selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"),3);
    setTextOnElement(By.xpath("//input[@id='CardCode']"),"369");
    clickOnElement(By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]"));
    clickOnElement(By.xpath("//span[@class=\"label\"]"));
    mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
    String ex="$2,950.00";
    Assert.assertEquals(ex,getTextOnElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong")));
    clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
    String eX="Thank you";
    Assert.assertEquals(eX,getTextOnElement(By.xpath("//h1[contains(text(),'Thank you')]")));
    //2.36 Verify the message “Your order has been successfully processed!”
    String eX1="Your order has been successfully processed!";
    Assert.assertEquals(eX1,getTextOnElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
    //2.37 Click on “CONTINUE”
    clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
    //2.37 Verify the text “Welcome to our store”
    String eXM="Welcome to our store";
    Assert.assertEquals(eXM,getTextOnElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));

}
    @After
   public void tearDown(){
         closeBrowser();
    }










}



