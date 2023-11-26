package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import tests.utilities.TestBase;

public class C05_KontrolluCokluWindowsIleCalisma extends TestBase {

   @Test
    public void kontrolluWindowTesti(){

       /*
       ***EGER bir test'de acilan windowlar farkli tab veya window'larda aciliyorsa
           ve testimizde bu sayfalar arasinda gecis isteniyorsa
           gectigimiz her sayfanin WindowHandleDegerini(WHD) kaydetmeliyiz.
        */

       // 1)Testotomasyonu anasayfaya gidin
       driver.get("https://www.testotomasyonu.com");

       // 2)url'in testotomasyonu icerdigini test edin
       String expectedURL="testotomasyonu";
       String actualURL= driver.getCurrentUrl();
       Assert.assertTrue(actualURL.contains(expectedURL));

       String anasayfaWHD= driver.getWindowHandle();

       // 3)Yeni bir tab olarak electronics linkini acin
      driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");//bu kodla yeni bir tab actik
      driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

      String electronicsWHD= driver.getWindowHandle();

      //4) Acilan sayfanin electronics sayfasi oldugunu test edin
      // Title'da Electronics oldugunu test edelim.
      String expectedTitle="Electronics";
      String actaulTitle= driver.getTitle();
      Assert.assertTrue(actaulTitle.contains(expectedTitle));


      // 5)Yeni bir window'da acilacak sekilde menfashion linkini tiklayin
      driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.testotomasyonu.com");//bu kodla yeni bir window actik
      driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();

      String menfashionWHD= driver.getWindowHandle();

      // 6)"Men Fashion" sayfasinin acildigini test edin
      expectedTitle="Men Fashion";
      actaulTitle=driver.getTitle();
      Assert.assertTrue(actaulTitle.contains(expectedTitle));

      //7) ilk actigimiz sayfaya donun
      driver.switchTo().window(anasayfaWHD);//driver ilk acilan anasayfaya gecti

     //8) test otomasyon anasayfada oldugumuzu test edin.
       // url ile test edelim https://www.testotomasyonu.com/
       String expectedUrl="https://www.testotomasyonu.com/";
       String actualUrl= driver.getCurrentUrl();
       Assert.assertEquals(expectedUrl,actualUrl);

    //9) tekrar electronics acik olan tab'a gecin
       driver.switchTo().window(electronicsWHD);//electronics tab'ina gectik

    //10) electronics bolumunde oldugunuzu test edin
       expectedTitle="Electronics";
       actaulTitle= driver.getTitle();
       Assert.assertTrue(actaulTitle.contains(expectedTitle));

     //11) tekrar Men fashion acik olan tab'a gecin
       driver.switchTo().window(menfashionWHD);//men fashion tab'ina gectik

    //12) Men Fashion bolumunde oldugunuzu test edin
       expectedTitle="Men Fashion";
       actaulTitle= driver.getTitle();
       Assert.assertTrue(actaulTitle.contains(expectedTitle));








   }


}
