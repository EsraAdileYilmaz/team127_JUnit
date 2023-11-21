package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ByIdLocators {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip arattirin

        /*
        Bir webelementi kullanmak istiyorsak;
        oncelikle driver'a o elementi buldurup (findElement() methodu ile)
        kullanabilecegimiz bir obje olarak kaydetmeliyiz.
        */

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));//burayi kaydetmeliyiz
        //boylece aramakutusunu WebElement olarak kaydediyoruz.
        aramaKutusu.sendKeys("phone");//boylece search cubuguna phone yazarak aratmis olucaz
        aramaKutusu.submit();//submit() methodu ile enter tusuna basmis oluyoruz.



        // bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi =driver.findElement(By.className("product-count-text"));//bulunan (4 product Found )oldugunu kaydediyoruz
        //System.out.println(sonucYaziElementi);//[[ChromeDriver: chrome on mac (a3bbb4356e8cbdcf38d64d7d4994c8b8)] -> class name: product-count-text]
        // Webelementler direk yazdirilamaz
        // Eger webelement uzerindeki yaziyi elde etmek istersek
        System.out.println(sonucYaziElementi.getText()); // 4 Products Found

        // Arama sonucunda urun bulunabildigini test edin
        String sonucSayisiStr=sonucYaziElementi.getText().replaceAll("\\D","");//"4" oldu
        int sonucSayisiInt=Integer.parseInt(sonucSayisiStr);//4

        if(sonucSayisiInt>0){
            System.out.println("Arama testi PASSED");
        }else {
            System.out.println("Arama testi FAILED");
        }


        Thread.sleep(10000);
        driver.quit();
    }
}
