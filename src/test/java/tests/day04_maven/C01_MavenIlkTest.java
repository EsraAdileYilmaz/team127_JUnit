package tests.day04_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        /*
        Mahserin 4 atlisindan ilki webdriver ayarlarini yapmakti.
        Ama bu adim mecburi degildir.
        Selenium 4.8 ile kendi webdriver'ini olusturdugundan,
        biz disardan webdriver tanimlamasak da
        Selenium kendi driver'ini kullanacaktir.
         */

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //sayfayi kapatin
        driver.quit();
    }
}
