package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C07_DosyaYukleme extends TestBase {


    @Test
    public void dosyaYuklemeTesti() {

          /*
            Selenium'da webdriver ile islemlerimizi yapariz,
            ancak webdriver bizim bilgisayarimizdaki dosyalara ulasamaz ve kullanamaz.
            Dosya exists islemlerinde,Java'dan yararlanip
            dosya yolunu kullanarak islemler yapabiliriz.

            Dosya yuklemede ise, dosya sec butonuna bastigimizda,
            bilgisayarimizdaki dosya yapisi acilir.
            Biz webdriver ile bilgisayarimizdaki dosya yapisinda islem yapamayacagimiz icin,
            chooseFile(choisir un fichier) butonuna sendKeys() ile dosya yolunu yollariz.

         */

        //1)https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2)chooseFile(choisir un fichier) butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        // Testlerimizin butun takim uyelerinde calisabilmesi icin
        // dosya yolunu dinamik yapmaliyiz.
        // biz bir onceki test'de downloads'a indirdigimiz
        // logo.png'yi yukleyelim.

        String dinamikDosyaYolu = System.getProperty("user.home") +  // user.home'u kullandik cunku dosya projede deil bilgisayarin icinde.herkeste farkli olan kisim
                "/Downloads/logo.png"; // herkeste ortak-ayni olan kisim

        chooseFileButonu.sendKeys(dinamikDosyaYolu);


        // 3)Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();


        // 4)“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement uplodedYaziElementi = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(uplodedYaziElementi.isDisplayed());//1.test yolu

        String expectedYazi = "File Uploaded!";
        String actualYazi = uplodedYaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);//2.test yolu


    }
}
