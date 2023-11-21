package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C09_findElements {

    public static void main(String[] args) {

        //1-Gerekli ayarlari yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2-testotomasyonu.com adresine gidin.
        driver.get("https://www.testotomasyonu.com");

        //3-shoes linkine tiklayin.
        driver.findElement(By.partialLinkText("hoes")).click();

        //4-Cikan urunler listesinden 3.urune tiklayin.
        /*
        3.urunu ozel olarak locate edmiyorsak, tum urunleri bir list'e atip
        sonra listedeki 3.urunu secebiliriz.
         */
        //manuel olarak 6 urun buldugumuzu gorduk ve bu 6 urunu kapsayan kodun
        //html kodlarina ulastik
        List<WebElement> urunElementleriListi=driver.findElements(By.className("prod-img"));
        //3.urune tiklamak icin index olarak dusunursek 0-1-2.index 3.urune(webelementine) denk gelmis oluyor.
        urunElementleriListi.get(2).click();

        //5-urun kisa aciklamalarinda case-sensitive olmadan shoe gectigini test edin.
        WebElement urunDetaylariElementi=driver.findElement(By.className("prod-detail"));
        String expectedKelime="shoe";
        String actualKelime= urunDetaylariElementi.getText().toLowerCase();
        System.out.println("Actual detay aciklama: "+actualKelime);

        if(actualKelime.contains(expectedKelime)){
            System.out.println("Urun detay testi PASSED");
        }else{
            System.out.println("Urun detay test FAILED");

        }

        //6-sayfayi kapatin
        driver.quit();

    }
}
