package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C05_ManageMethods {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1)testotomasyonu.com sayfasina gidin.
        driver.get("https://www.testotomasyonu.com");

        //2)Arama kutusuna phone yazip aratin.
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

       //3)Arama yapildiktan sonra , sol tarafta cikan Categories menusundeki
       //kategori sayisinin 8 oldugunu test edin.
        List<WebElement> kategoriElementleri =driver.findElements(By.className("acc_head"));
        //WebElement'lerden olusan bir list olusturuldu.bunun icine 8 kategori basligi atandi.

        int expectedKategoriSayisi=8;
        int actualKategoriSayisi=kategoriElementleri.size();

        if(expectedKategoriSayisi == actualKategoriSayisi){
            System.out.println("Kategori sayisi testi PASSED");
        }else{
            System.out.println("Kategori sayisi testi FAILED");
            System.out.println("Actual kategori sayisi: "+actualKategoriSayisi);
        }

        //4)Kategorileri yazdirin.

        //System.out.println(kategoriElementleriListi); webelementlerinin referanslarini yazdirdik.

        /*
          Bu List webelementler'den olusuyor,
          webelementler uzerindeki yaziyi direk yazdiramayiz.
          Her bir webelementi ele alip, uzerindeki yaziyi yazdirmamiz gerekir.
          */

        /*
         Yazdirma islemini bir for-each loop ile yapabiliriz
         ama biz bu islemi cok kullanacagimiz icin
         bir method olusturup
         webelementlerden olusan listeyi
         String'lerden olusan bir listeye cevirdik.


        for (WebElement each:kategoriElementleri
             ) {
            System.out.println(each.getText());
        }

         */

        //method call yapalim.
        System.out.println(ReusableMethods.stringListeDonustur(kategoriElementleri));
        //[Grocery, Kids Wear, Travel, Shoes, Furniture, Men Fashion, Women Fashion, Electronics]






        driver.quit();

    }
}
