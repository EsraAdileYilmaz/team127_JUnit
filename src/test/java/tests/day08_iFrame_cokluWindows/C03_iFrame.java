package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C03_iFrame extends TestBase {

    @Test
    public void iFrameTest(){

        /*
        1)http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        2) Cookies kabul edin
        3) sayfadaki iframe sayısını bulunuz ve yazdiriniz.
        4) ilk iframe’deki (Youtube) play butonuna tıklayınız.
        5) ilk iframe’den çıkıp ana sayfaya dönünüz
        6) ikinci iframe’deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız

         */

        //1)http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2)Cookies kabul edin
        // cookies de iframe icinde oldugundan once o iframe'e gecis yapalim
        //WebElement cookiesIframeElementi= driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));//cookies iframe elementi
        //driver.switchTo().frame(cookiesIframeElementi);//iframe'e gectik
        //driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]")).click();//cookies'i kabul ettik

        //3) sayfadaki iframe sayısını bulunuz ve yazdiriniz.
        //iframe'leri locate edip bir List<> icine atamaliyim
        driver.switchTo().defaultContent();//once anasayfaya gectik
        List<WebElement> iframeListesi =driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi: "+iframeListesi.size());

        // 4) ilk iframe’deki (Youtube) play butonuna tıklayınız.
        //iframe'e gecmek gerekir.iframe'i locate edelim.
        // WebElement playIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        WebElement playIframe= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(playIframe);

        driver.findElement(By.xpath("//button[@title='Lire']")).click();//burada iframe icindeki play tusu locate edildi ve click yapildi

        // 5) ilk iframe’den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //6) ikinci iframe’deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframeTwo= driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));//iframe locate ettik
        driver.switchTo().frame(iframeTwo);//iframe'e  gectik

        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

    }

}
