package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C12_RelativeLocators {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://testotomasyonu.com/relativeLocators sayfasina gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        // DSLR Camera elementini locate edin
        WebElement dslrCamera=driver.findElement(By.xpath("//img[@id='pic7_thumb']"));

        // webelementin HTML kodunda src attribute'unun
        // "testotomasyonu.com/uploads/product" icerdigini test edin
        String srcAttributeValue=dslrCamera.getAttribute("src");//getAttribute() methodu ile src attribute'nun value'su elde edilir.
        String expectedHtmlIcerik="testotomasyonu.com/uploads/product";

        if(srcAttributeValue.contains(expectedHtmlIcerik)){
            System.out.println("DSLR Camera testi PASSED");
        }else {
            System.out.println("DSLR Camera testi FAILED");
        }

        /*
            Bir websayfasinda=
            bir webelementini gorebiliyor, HTML kodlarina ulasabiliyor
            ama locate edemiyorsaniz;
            Etrafindaki webelementleri kullanarak,
            locate islemini yapabilmemiz icin
            Selenium4 ile birlikte relative locator ozelligi gelmistir.

            Relative locator icin=
            - hedef elementin en az 1 ozelligi
            - hedef element etrafinda locate edip kullanabildigimiz en az 1 baska webelement
            olmalidir
         */


        // DSLR camera webelementi ve relative locator kullanarak,
        // Motor E13 telefonu locate edin
        WebElement motorE13Elementi=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(dslrCamera));

        //Motor E13 telefonunun src attribute'inde 16882639136208024 numarasinin bulundugunu test edin.
        String expectedMotorValue="16882639136208024";
        String actualMotorValue=motorE13Elementi.getAttribute("src");

        if(actualMotorValue.contains(expectedMotorValue)){
            System.out.println("Motorola E13 testi PASSED");
        }else {
            System.out.println("Motorola E13 testi FAILED");
        }

        //Hp Victus bilgisayarin src attribute'inde 1688033137 numarasinin bulundugunu test edin
        WebElement hpVictusElementi=driver.findElement(RelativeLocator.with(By.tagName("img"))
                .below(dslrCamera));

        String expectedHpvictusValue="1688033137";
        String actualHpvictusValue=hpVictusElementi.getAttribute("src");

        if(actualHpvictusValue.contains(expectedHpvictusValue)){
            System.out.println("HP Victus testi PASSED");
        }else{
            System.out.println("HP Victus testi FAILED");
        }

        //Samsung smart watch'un id attribute'nun degerinin "pic13_thumb" oldugunu test edin
        WebElement smartWatch=driver.findElement(RelativeLocator.with(By.id("pic13_thumb"))
                .below(motorE13Elementi).toRightOf(hpVictusElementi));

        String expectedWatchValue="pic13_thumb";
        String actualWatchValue=smartWatch.getAttribute("id");

        if(actualWatchValue.equals(expectedWatchValue)){
            System.out.println("Smart Watch test PASSED");
        }else{
            System.out.println("Smart Watch test FAILED");
        }


        driver.quit();

    }
}
