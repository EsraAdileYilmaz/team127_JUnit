package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumsayfaScreenshot extends TestBase {

    @Test
    public void aramaTesti() throws IOException {

        // 1) test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //2) Nutella icin arama yapin
        WebElement searchBox= driver.findElement(By.id("global-search"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        //3) Arama sonucunda urun bulunamadigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.className("product-count-text"));
        String expectedAramaSonucu="0 Products Found";
        String actualAramaSonucu=sonucYaziElementi.getText();
        Assert.assertEquals(expectedAramaSonucu,actualAramaSonucu);


        ReusableMethods.bekle(2);
        // 4) tum sayfanin fotografini cekip kaydedin

        //1.adim takesScreenShot(tss) objesi olusturun
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        File tumSayfaScreenshot=new File("target/screenshots/tumSayfaScreenshot.jpg");
        //bu bizim kalici kaydedecegimiz dosyamiz.fotografimizi enson tumSayfaScreenshot icine kaydedicez

        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim.
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        //bu dosya gecici kaydedilen dosyadir.ve burda screenshot yapmis olduk

        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        ReusableMethods.bekle(5);

















    }


}
