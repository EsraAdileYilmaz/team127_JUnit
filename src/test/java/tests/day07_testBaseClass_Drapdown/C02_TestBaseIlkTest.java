package tests.day07_testBaseClass_Drapdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C02_TestBaseIlkTest extends TestBase {

    @Test
    public void aramaTesti(){

        // testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusuElementi= driver.findElement(By.id("global-search"));
        aramaKutusuElementi.sendKeys("phone"+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String sonucYazisiStr=sonucYaziElementi.getText().replaceAll("\\D","");
        int sonucYazisiInt=Integer.parseInt(sonucYazisiStr);

        Assert.assertTrue(sonucYazisiInt >0);

    }


}
