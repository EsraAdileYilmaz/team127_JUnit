package tests.day07_testBaseClass_Drapdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C05_JsAlert extends TestBase {

    //3 test method'u olusturup asagidaki gorevi tamamlayin

    @Test
    public void jsBasicAlert(){

        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // driver.findElement(By.xpath("//*[@onclick = 'jsAlert()']")).click();

        //-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazi="I am a JS Alert";
        String actualAlertYazi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);

        //-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirmAlert(){

        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //- 2.alert'e tiklayalim jsConfirm()
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        //- Cancel'a basip,
        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        //WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualYazi= sonucYaziElementi.getText();
        String expectedYazi="You clicked: Cancel";

        Assert.assertEquals(expectedYazi,actualYazi);
    }

    @Test
    public void jsPromptTesti(){

        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();


        //- Cikan prompt ekranina "Selenyum" yazdiralim.
        driver.switchTo().alert().sendKeys("Selenyum");

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin "Selenyum" icerdigini test edelim
        WebElement resultElementi= driver.findElement(By.xpath("//p[@id='result']"));

        String expectedIcerik="Selenyum";
        String actualIcerik=resultElementi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }


}
