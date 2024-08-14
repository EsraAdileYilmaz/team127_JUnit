package tests.day08_iFrame_cokluWindows;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.Set;

public class C06_KontrolsuzCokluWindowKullanimi extends TestBase {

    @Test
    public void kontrolsuzWindowTest() {

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement addRemoveElement = driver.findElement(By.tagName("h2"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = addRemoveElement.getText();
        Assert.assertEquals(expectedYazi, actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//a[text()='Electronics Products']")).click();
        //ama buraya tiklayinca kontrolsuz olarak yeni bir tab'da acti.bunu da manuel olarak kontrol edince gorduk

        /*
            Driver,bir webelement'e click yapildiginda
            ayni sayfada acilacagini varsayar.

            Eger tiklanan element yeni bir tab veya window aciyorsa
            bu durumda driver'i yeni acilan tab/window'a bizim gondermemiz gerekir.

            Bizim driver'i baska bir tab/window'a yollamak icin 2 yolumuz var:
            1- ya kontrollu yeni bir tab/window acarak
            2- yada kontrolsuz acilan tab/window'un Window handle degerini kullanarak
               driver'i o tab'a gonderebiliriz.

            Burada Java'dan yaralanarak mini bir bulmaca cozmeliyiz.
         */

        //suanda driver'imiz ilksayfada oldugu icin ilk sayfanin WHD'sini alabiliriz

        String ilksayfaWHD = driver.getWindowHandle();
        Set<String> whdSeti = driver.getWindowHandles();//burada acilan tum sayfalarin handle degerlerini alip,bir set'e atadik
        String ikinciSayfaWHD = "";
        for (String each : whdSeti
        ) {
            if (!each.equals(ilksayfaWHD)) {//each'in getirdigi deger ilksayfaWHD degerine esit deilse,esit olmayan degeri

                ikinciSayfaWHD = each;//each'in getirdigi 2.whd degerini, String ikinciSayfaWHD="";ye atayarak,bulmus oluyoruz
            }
        }

        //simdi driver'imizi acilan ikinci tab'a gonderebiliriz.
        driver.switchTo().window(ikinciSayfaWHD);

        //● Electronics sayfasinin acildigini test edin
        expectedTitle = "Electronics";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));
        String sonucSayiStr = sonucYaziElementi.getText().replaceAll("\\D", "");//"16"
        int actualSonucSayi = Integer.parseInt(sonucSayiStr);//16
        int expectedSonucSayi = 16;
        Assert.assertEquals(expectedSonucSayi, actualSonucSayi);

        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilksayfaWHD);//driver ilk anasayfaya gecti

        //● Url’in addremove icerdigini test edin
        String expectedUrl = "addremove";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        System.out.println(whdSeti);


    }
}
