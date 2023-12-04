package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C01_Devoir1 extends TestBase {

     /*
        Kontrolsuz bir tab/window acildiginda
        eger yeni acilan tab/window'un title degeri biliniyorsa
        driver'i acilan sayfaya geciren bir method olusturun

        input : yeniTitle , Test Otomasyonu - Electronics

     */

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkSayfaWHD= driver.getWindowHandle();

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi= driver.findElement(By.tagName("h2"));
        String expectedYazi="Add/Remove Elements";
        String actualYazi=yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle="Test Otomasyonu";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();

        //● Electronics sayfasinin acildigini test edin
        //yeni bir tab acildigi icin driver'i o tab'a gonderen bir method yapacagiz.
        //Ancak bunun icin oncesinde manuel olarak o siteye gidip sitenin title'ini (ctrl+F)"//title" locate'i ile
        //locate etmeliyim ve hedefSayfaTitle'i kismina parametre olarak atamaliyim.
        driver= ReusableMethods.titleIleSayfaDegistir(driver,"Test Otomasyonu - Electronics");


        //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi= driver.findElement(By.className("product-count-text"));
        String sonucYaziStr=sonucYaziElementi.getText().replaceAll("\\D","");//"16"
        int actualSonucSayi=Integer.parseInt(sonucYaziStr);//16
        int expectedSonucSayi=16;
        Assert.assertEquals(expectedSonucSayi,actualSonucSayi);
        ReusableMethods.bekle(2);

        //● Ilk actiginiz addremove sayfasina donun
        //switchTo() ile driver'a "gec" emri veriyoruz.
        driver.switchTo().window(ilkSayfaWHD);//ilkSayfaWHD'nin oldugu window'a gec

        //● Url’in addremove icerdigini test edin
        String expectedURL="addremove";
        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));






    }

}
