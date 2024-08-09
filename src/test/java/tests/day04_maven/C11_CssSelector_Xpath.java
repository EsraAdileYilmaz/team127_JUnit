package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_CssSelector_Xpath {

    public static void main(String[] args) {

           /*
        Xpath link olmasa bile yazisi olan webelementlerini
        yazi ile locate etmemize imkan tanir.
        Ornegin:By.xpath("//button[text()='Remove']")
           */

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu.com anasayfasina gidin.
        driver.get("https://www.testotomasyonu.com");

        //electronics linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        //kenarda bulunan fiyat filtresine min 10, max 200 yazarak
        WebElement minElementi=driver.findElement(By.xpath("//input[@class='form-control minPrice']"));
        WebElement maxElementi= driver.findElement(By.xpath("//input[@class='form-control maxPrice']"));

        minElementi.clear();
        minElementi.sendKeys("10");
        maxElementi.clear();
        maxElementi.sendKeys("200");

        //filtreleme yapin.
        driver.findElement(By.className("price-range-button")).sendKeys(Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin.
        WebElement aramaSonucElementi=driver.findElement(By.className("product-count-text"));
        System.out.println(aramaSonucElementi.getText());

        String aramasonucStr=aramaSonucElementi.getText().replaceAll("\\D","");//"11"
        int aramaSonucSayisi=Integer.parseInt(aramasonucStr);//11

        if(aramaSonucSayisi > 0){
            System.out.println("Filtreleme testi PASSED");
        }else{
            System.out.println("Filtreleme testi FAILED");
        }




        driver.quit();


    }
}
