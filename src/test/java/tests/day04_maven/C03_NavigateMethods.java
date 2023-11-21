package tests.day04_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_NavigateMethods {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1)testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //2)title'in Otomasyon icerdigini test edin.
        String expectedTitle="Otomasyon";
        String actualTitle=driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test title PASSED");
        }else {
            System.out.println("Test title FAILED");
        }

        //3)WiseQuarter anasayfaya gidin
        driver.navigate().to("https://www.wisequarter.com");

        //4)Url'in wisequarter icerdigini test edin
        String expectedUrl="wisequarter";
        String actualUrl=driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl)){
            System.out.println("Test URL PASSED");
        }else{
            System.out.println("Test URL FAILED");
            System.out.println("Actual URL: "+actualUrl);
        }

        //5)tekrar testotomasyonu sayfasina gidin.
        driver.navigate().back();

        //6)URL'in otomasyon icerdigini test edin
        expectedUrl="otomasyon";
        actualUrl= driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl)){
            System.out.println("Test URL PASSED");
        }else {
            System.out.println("Test URL FAILED");
            System.out.println("Actual URL: "+actualUrl);
        }






        driver.quit();
    }
}
