package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.util.Set;

public class C08_Devoir2 extends TestBase {

    @Test
    public void windowHandle2(){

        /*
          1)"https://the-internet.herokuapp.com/windows" adresine gidin.
          2)Sayfadaki textin "Opening a new window" oldugunu dogrulayin.
          3)Sayfa basliginin(title) "The Internet" oldugunu dogrulayin.
          4)Click Here butonuna basin
          5)Acilan yeni pencerenin  sayfa basliginin(title) "New Window" oldugunu dogrulayin
          6)Sayfadaki textin "New Window" oldugunu dogrulayin
          7)Bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugunu dogrulayin.
         */

        //1)"https://the-internet.herokuapp.com/windows" adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //2)Sayfadaki textin "Opening a new window" oldugunu dogrulayin.
        WebElement textElementi= driver.findElement(By.tagName("h3"));
        String expectedTitle="Opening a new window";
        String actualTitle= textElementi.getText();
        Assert.assertEquals(expectedTitle,actualTitle);

        // 3)Sayfa basliginin(title) "The Internet" oldugunu dogrulayin.
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //4)Click Here butonuna basin
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //5)Acilan yeni pencerenin  sayfa basliginin(title) "New Window" oldugunu dogrulayin
        /*
        oncelikle driver'i yeni acilan pencereye gecirmemiz gerekir
         */
        String anasayfaWHD= driver.getWindowHandle();
        Set<String> whdSeti=driver.getWindowHandles();//acilan tum handle degerleri kaydettik
        String yenisayfaWHD="";

        for (String each:whdSeti
             ) {
            if( ! each.equals(anasayfaWHD)){
                yenisayfaWHD=each;
            }
        }
        //simdi driver'imizi acilan yeni tab'a gonderebiliriz.
        driver.switchTo().window(yenisayfaWHD);

        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


        //6)Sayfadaki textin "New Window" oldugunu dogrulayin
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        String expectedBaslik="New Window";
        String actualBaslik=yaziElementi.getText();
        Assert.assertEquals(expectedBaslik,actualBaslik);

        //7)Bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugunu dogrulayin.
        driver.switchTo().window(anasayfaWHD);//driver anasayfaya geri dondu.
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


    }
}
