package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ByLinkText_ByPartialLinkText {

    public static void main(String[] args) {

        //1)gerekli ayarlamalari yapin.
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2) testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //3) shoes linkine tiklayin
        //1.yol=driver.findElement(By.linkText("Shoes")).click();
        /*WebElement shoesLinki =driver.findElement(By.linkText("Shoes"));
          shoesLinki.click();
         */
        //driver.findElement(By.linkText("hoes")).click();
        /*
        Eger By.linkText() methodu kullanirsaniz, link uzerindeki text'i birebir ayni olarak yazmamiz gerekir.
        bosluk, ? gibi karakterler varsa onlar da mutlaka yazilmalidir.
        */

        //driver.findElement(By.partialLinkText("hoes")).click(); testPASSED oldu
        //driver.findElement(By.partialLinkText("oes")).click(); testPASSED oldu
        //driver.findElement(By.partialLinkText("ho")).click(); testPASSED oldu
        WebElement shoesLinki=driver.findElement(By.partialLinkText("oe"));
        shoesLinki.click();

        /*
         By.partialLinkText() methodu kullanildiginda;
         link uzerindeki yazinin tamamina ihtiyac yoktur.
         Yazinin, istegimiz webelementi unique olarak bulabilecegimiz
         herhangi bir parcasini kullanmamiz yeterli olur.
         */


        //4)acilan sayfada Title'in shoes icerdigini test edin
        String expectedTitleIcerik="Shoes";
        String actualTitle=driver.getTitle();
        System.out.println(driver.getTitle());//basligi yazdirarak gordum

        if(actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Shoes testi PASSED");
        }else {
            System.out.println("Shoes testi FAILED");
        }


        //5)Shoes linkinin bu sayfada da erisilebilir oldugunu test edin
        shoesLinki = driver.findElement(By.partialLinkText("oe"));//buraya linki tekrar ekledik cunku StaleElementReferenceException verdi
        if(shoesLinki.isEnabled()){
            System.out.println("Shoes linki erisim testi PASSED");
        }else System.out.println("Shoes linki erisim testi FAILED");


       /*
       "StaleElementReferenceException" verdi cunku shoes' a tiklayinca websayfasinin
       adresi degisti.senin bana verdigin adres deil diyor.o adres eski diyor.
        */
      /*
            Bir webelementi locate ettikten sonra
            sayfayi yenileme veya yeni bir sayfaya gitme gibi islemler yaparsak
            driver daha onceden yaptigimiz locate'leri KULLANAMAYABILIR
            ve bize "StaleElementReferenceException" verir.

            Bu durumda locate ve elemente kayit islemini YENIDEN YAPMALIYIZ.
            Ornegin:shoesLinki = driver.findElement(By.partialLinkText("oe"));
            bunu bir kez daha islemi yapmadan coller yapmaliyiz.
         */


        driver.quit();
    }
}
