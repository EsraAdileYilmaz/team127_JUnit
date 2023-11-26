package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {

    @Test
    public void basicAuthenticationTesti(){

        /*
          1- Bir class olusturun : BasicAuthentication
          2- https://testotomasyonu.com/basicauth sayfasina gidin
          3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
          Html komutu : https://username:password@URL
        	Username     : membername
         	password      : sunflower
          4- Basarili sekilde sayfaya girildigini dogrulayin.
          expectedResult="Congratulations! You are logged in as: membername"
        */


        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        //driver.get(" https://testotomasyonu.com/basicauth");
        //bu sayfayi yoruma aliyorum cunku authentication yapmak icin url e ekleme yapmaliyim.


        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        //bu sekilde bir yazimla siteye giris yapilabiliyor.ve bilgi alimi yapilabiliyor

        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement girisYaziElementi= driver.findElement(By.tagName("h3"));
        //bu yaziyi siteye girince quit'i iptal edip inspecter ettim

        String expectedResult="Congratulations! You are logged in as: membername";
        String actualResult=girisYaziElementi.getText();
        Assert.assertEquals(expectedResult,actualResult);





    }
}
