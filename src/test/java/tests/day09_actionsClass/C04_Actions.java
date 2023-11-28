package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C04_Actions extends TestBase {

    @Test
    public void sagClickTesti(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ReusableMethods.bekle(2);

        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement ciziliAlanElementi=driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();
        //contextClick(ciziliAlanElementi) parantez icine yazilan(ciziliAlanElementi) yere gidip click() yap demis oluyoruz
        ReusableMethods.bekle(2);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazi="You selected a context menu";
        String actualAlertYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        //burada yeni bir tab acildigi icin driver'i oraya gondermemiz gerekir.
        //bunuda yeni olusturdugumuz titleIleSayfaDegistir() methodu ile yapacagiz.
        //bu method bize return driver; dondurdugu icin bizim driver'imiza atamamiz gerekir.
        ReusableMethods.bekle(2);
        driver=ReusableMethods.titleIleSayfaDegistir(driver,"Elemental Selenium | Elemental Selenium");
        //acilan yeni sayfanin title'ini elde etmek icin sayfanin herhangi bir yerine inspecter yapilarak
        //acilan html kodlarinda ( ctrl+F yapilarak) //title yazip aranmalidir.

        WebElement h1TagYaziElementi= driver.findElement(By.className("home-header"));
        String expectedYazi="Make sure your code lands";
        String actualYazi=h1TagYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);





    }




}
