package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C10_Devoir_Iframe_Alert extends TestBase {

    @Test
    public void iframeTesti(){

        //1) "https://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        //2)"Our Products" butonuna basin
        //3)"Cameras product" i tiklayin
        //4)Popup mesajini yazdirin
        //5)"close" butonuna basin
        //6)"WebdriverUniversity.com(IFrame)" linkini tiklayin
        //7)"https://webdriveruniversity.com/index.html" adresine gittigini test edin.


        //1) "https://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("https://webdriveruniversity.com/IFrame/index.html");

        //2)"Our Products" butonuna basin
        WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElementi);//iframe'in icine gectik

        WebElement ourProductElementi= driver.findElement(By.xpath("//a[text()='Our Products']"));
        ourProductElementi.click();


        //3)"Cameras product" i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();

        //4)Popup mesajini yazdirin
        WebElement alertElementi= driver.findElement(By.xpath("//*[@*='modal-title']"));
        //bu alert html alerttir.inspecter yapiliyor.
        System.out.println(alertElementi.getText());

        //5)"close" butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        //6)"WebdriverUniversity.com(IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();//driver iframe'den cikip ana sayfaya gecti
        WebElement webdriverlinkElementi= driver.findElement(By.xpath("(//a[@id='nav-title'])[1]"));
        webdriverlinkElementi.click();


        //7)"https://webdriveruniversity.com/index.html" adresine gittigini test edin.
        /*
        WebElement baslikYaziElementi=driver.findElement(By.xpath("//h1[text()='My Courses & Promo Codes']"));
        String actualBaslikYazisi= baslikYaziElementi.getText();
        String expectedBaslikYazisi="My Courses & Promo Codes";
        Assert.assertEquals(expectedBaslikYazisi,actualBaslikYazisi);
        */

        String expectedUrl="https://webdriveruniversity.com/index.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
