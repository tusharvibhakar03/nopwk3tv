package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
     }

     @Test

    public void verifyPageNavigation(){
        String m=getTextOnElement(By.xpath("//body/div[6]/div[2]"));
        selectM(m);
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    public void selectM(String m){
        String s=getTextOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]")) ;

        if(m.contains(s)){
            clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        }
    }

}


