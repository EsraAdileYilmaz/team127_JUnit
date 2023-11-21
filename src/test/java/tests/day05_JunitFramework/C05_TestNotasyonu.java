package tests.day05_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_TestNotasyonu {

    // Bir class'in icinde birden fazla bagimsiz calisabilen test olur mu ?
    // JUnit ile calisirken,class'da birden fazla test oldugunda
    // toplu calistirdigimiz zaman hangi sira ile calisacagini BILEMEYIZ ve KONTROL EDEMEYIZ.


    @Test
    public void testOtomasyonuTest(){// test method'lari static olmamalidir
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        // title'in "Test Otomasyon" icerdigini test edin
        String expectedTitle="Test Otomasyon";
        String actualTitle= driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test otomasyonu testi PASSED");
        }else{
            System.out.println("Test otomasyonu test FAILED");
        }

        driver.quit();

    }

    @Test
    public void wisequarterTest(){// test method'lari static olmamalidir
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //wisequarter.com adresine gidin
        driver.get("https://www.wisequarter.com");

        // title'in "Wise" icerdigini test edin
        String expectedTitle="Wise";
        String actualTitle= driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("wisequarter test PASSED");
        }else{
            System.out.println("wisequarter test FAILED");
        }

        driver.quit();

    }

    @Test
    public void googleTest(){// test method'lari static olmamalidir
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //google.com adresine gidin
        driver.get("https://www.google.com");

        // url'in "google" @icerdigini test edin
        String expectedUrl="google";
        String actualUrl= driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl)){
            System.out.println("Google Url testi PASSED");
        }else{
            System.out.println("Google Url testi FAILED");
        }

        driver.quit();

    }

}
