package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import tests.utilities.TestBase;

public class C07_Devoir1 extends TestBase {

    @Test
    public void windowHandle1(){

        /*
         1)Amazon anasayfa adresine gidin
         2)Sayfanin window handle degerini String bir degiskene atayin.
         3)Sayfa title'inin "Amazon" icerdigini test edin
         4)Yeni bir tab olusturup, acilan tab'da wisequarter.com adresine gidin
         5)Sayfa title'inin "wisequarter" icerdigini test edin.
         6)Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
         7)Sayfa title'inin "Walmart" icerdigini test edin.
         8)Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin.
         */

        //1)Amazon anasayfa adresine gidin
        driver.get("https://www.amazon.com");

        //2)Sayfanin window handle degerini String bir degiskene atayin.
        String amazonWHD= driver.getWindowHandle();

        //3)Sayfa title'inin "Amazon" icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //4)Yeni bir tab olusturup, acilan tab'da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");

        //5)Sayfa title'inin "Wise Quarter" icerdigini test edin.
         expectedTitle="Wise Quarter";
         actualTitle= driver.getTitle();
         Assert.assertTrue(actualTitle.contains(expectedTitle));

         //6)Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");

        //7)Sayfa title'inin "Walmart" icerdigini test edin.
        expectedTitle="Walmart";
        actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //8)Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin.
        driver.switchTo().window(amazonWHD);
        String expectedWHD=amazonWHD;
        String actualWHD= driver.getWindowHandle();
        Assert.assertEquals(expectedWHD,actualWHD);


    }
}
