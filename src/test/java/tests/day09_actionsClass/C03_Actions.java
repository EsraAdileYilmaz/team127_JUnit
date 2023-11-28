package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void sagClickTesti(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(3);//driver'in o sayfayi (actions'i) bulmasi icin bekletme yapmak gerekiyor
        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions=new Actions(driver);//1.adim
        WebElement droneElementi= driver.findElement(By.id("pic2_thumb"));//2.adim
        actions.contextClick(droneElementi).perform();//3.adimda WebElement'i verip onun uzerine click yaptiriyoruz.
        ReusableMethods.bekle(2);

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAlertYazi="Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazi=driver.switchTo().alert().getText();//driver alert'e gecip oradaki yaziyi bize dondurur.
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);

        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();//driver alert'e gecip cikan yaziti kabul etti

    }
}
