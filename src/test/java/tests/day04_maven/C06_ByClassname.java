package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C06_ByClassname {

    public static void main(String[] args) {

        //1)Bir test class'i olusturun ve ilgili ayarlari yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2)https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3)Category bolumundeki elementleri locate edin.
          /*
        1)manuel olarak siteye gidip Category bolumundeki herhangi bir elementin html kodlari kopyalanmalidir
        2)driver.findElements() methodu ile hangi locator'u kullanacaksan icine coller yapilir
        3)WebElement'lerini icine koyacagimiz bir List<WebElement> olusturulur.
         */
        List<WebElement> kategoriElementleriListi =driver.findElements(By.className("panel-title"));


        //4)Category bolumunde 3 element oldugunu test edin.
        int expectedKategoriSayisi=3;
        int actualKategoriSayisi=kategoriElementleriListi.size();

        if(expectedKategoriSayisi == actualKategoriSayisi){
            System.out.println("Kategori sayisi testi PASSED");
        }else{
            System.out.println("Kategori sayisi testi FAILED");
            System.out.println("Actual kategori sayisi: "+actualKategoriSayisi);
        }

        //5)Category isimlerini yazdirin
        System.out.println(ReusableMethods.stringListeDonustur(kategoriElementleriListi));
        //[WOMEN, MEN, KIDS]


        //6)Sayfayi kapatin
        driver.quit();
    }
}
