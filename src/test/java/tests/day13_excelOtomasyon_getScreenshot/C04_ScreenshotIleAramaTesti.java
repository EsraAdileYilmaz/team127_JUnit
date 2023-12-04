package tests.day13_excelOtomasyon_getScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C04_ScreenshotIleAramaTesti extends TestBase {

   @Test
   public void aramaTesti(){

      //1) testotomasyonu anasayfaya gidin
      driver.get("https://www.testotomasyonu.com");

      // 2)dress yazarak arama yapin
      WebElement aramaKutusu = driver.findElement(By.id("global-search"));
      aramaKutusu.sendKeys("dress" + Keys.ENTER);

      //3) arama sonucunda urun bulunabildigini test edin
      WebElement aramaSonucElementi= driver.findElement(By.className("product-count-text"));
      String expectedSonucYazisi="10 Products Found";
      String actualSonucYazisi=aramaSonucElementi.getText();
      Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

      /*
         WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();
        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
       */

      ReusableMethods.bekle(2);
      //4)tum sayfanin screenshot'ini kaydedin
      ReusableMethods.tumSayfaTakeScreenshot("aramaTesti",driver);













   }











}
