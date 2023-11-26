package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C02_iFrame extends TestBase {

  @Test
  public void  iframeTest(){

      /*
      1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
      2 ) Bir metod olusturun: iframeTest
        - “An IFrame containing….” textinin erisilebilir oldugunu test edin
        ve  konsolda yazdirin.
      3) Text Box’a “Merhaba Dunya!” yazin.
      4) TextBox’in altinda bulunan “Elemental Selenium” link textinin gorunur oldugunu dogrulayin
        ve  konsolda yazdirin.
       */

    //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    driver.get("https://the-internet.herokuapp.com/iframe");

    // 2) “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    WebElement aniframeElementi =driver.findElement(By.tagName("h3"));
    Assert.assertTrue(aniframeElementi.isEnabled());
    System.out.println(aniframeElementi.getText());

    //3)Text Box’a “Merhaba Dunya!” yazin.
    /*Text Box elementi iframe'in icinde oldugu icin once iframe'i bir webelementi gibi
      locate edip WebElemente atamak gerekir.
      Sonra iframe'in icine girmek icin driver.switchTo().frame() yapilir.
      Enson istenen islem yapilir.

    */
    /*
            Text box bir iframe'in icinde
            iframe'in icinde olan elementlere ulasabilmek icin
            once iframe'e gecis yapmalisiniz.

            iframe'e gecis yapabilmek icin=>
            - once iframe'i bir webelement olarak locate edin
            - switchTo() ile iframe'e gecin

            iframe'e gecis yaparsaniz;
            driver orada kalir
            yeniden anasayfa ile ilgili bir islem yapmak isterseniz
            driver'i yeniden anasayfaya gecirmelisiniz.
            Bununda 2 yolu vardir:
            1)driver.switchTo().parentFrame(); eger ic ice birden fazla iframe varsa
                                             bir ustteki iframe'e gecis yapar.
            2)driver.switchTo().defaultContent(); direk anasayfaya gecer.

         */

    WebElement iFrameElementi= driver.findElement(By.tagName("iframe"));//locate ettik ve bir WebElemente atadik
    driver.switchTo().frame(iFrameElementi);//iFrame'in icine gectik

    WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
    //WebElement textBoxKutusu = driver.findElement(By.tagName("p")); 2.locate yolu
    textBox.clear();
    textBox.sendKeys("Merhaba Dunya!");

    //4)TextBox’in altinda bulunan “Elemental Selenium” link textinin gorunur oldugunu dogrulayin
    //        ve  konsolda yazdirin.

    driver.switchTo().defaultContent();//iframe icindeki driver'imizi anasayfaya geri getirdik.
    //driver.switchTo().parentFrame();//iframe icindeki driver'imizi bir ust sayfaya gecirir.
    WebElement elemantalSeleniumElementi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
    Assert.assertTrue(elemantalSeleniumElementi.isDisplayed());
    System.out.println(elemantalSeleniumElementi.getText());



  }
}
