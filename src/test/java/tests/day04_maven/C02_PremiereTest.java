package tests.day04_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_PremiereTest {

    public static void main(String[] args) {

        // testotomasyonu anasayfaya gidin
        // URL'in https://www.testotomasyonu.com/ oldugunu
        // ve Title'in test kelimesi icerdigini test edin

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // URL'in https://www.testotomasyonu.com/ oldugunu
        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=driver.getCurrentUrl();

        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL testi PASSED");
        }else{
            System.out.println("URL testi FAILED");
        }

        // ve Title'in test kelimesi icerdigini test edin
        String expectedTitle="test";
        String actualTitle= driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
            System.out.println("Actual title: "+actualTitle);
        }

        driver.quit();




    }
}
