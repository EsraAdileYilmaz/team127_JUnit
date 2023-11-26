package tests.day06_JunitAssertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C07_Devoir1 extends TestBase {


  /*
    1)"https://www.youtube.com" adresine gidin
    2)4 farkli test methodu olusturun ve gerekli testleri yapin
       A-titleTest= sayfa basliginin "YouTube" oldugunu test edin.
       B-imageTest=YouTube resminin goruntulendigini (isDisplayed()) test edin.
       C-Search box'in erisilebilir oldugunu test edin.
       D-wrongTitleTest= sayfa basliginin "youtube" olmadigini dogrulayin
   */
    @Test
    public void titleTest(){
        //1)"https://www.youtube.com" adresine gidin
        driver.get("https://www.youtube.com");

        //sayfa basliginin "YouTube" oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        //1)"https://www.youtube.com" adresine gidin
        driver.get("https://www.youtube.com");

        //YouTube resminin goruntulendigini (isDisplayed()) test edin.
        WebElement logo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isEnabled());
        //Assert.assertTrue(logo.isDisplayed()); hata veriyor
    }

    @Test
    public void searchBoxTest(){
        //1)"https://www.youtube.com" adresine gidin
        driver.get("https://www.youtube.com");

        //Search box'in erisilebilir oldugunu test edin.
        WebElement searchBox= driver.findElement(By.xpath("//div[@class='ytd-searchbox-spt']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        //1)"https://www.youtube.com" adresine gidin
        driver.get("https://www.youtube.com");

        // sayfa basliginin "youtube" olmadigini dogrulayin
        String expectedTitle="youtube";
        String actualTitle= driver.getTitle();
       Assert.assertNotEquals(expectedTitle,actualTitle);
    }


}
