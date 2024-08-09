package tests.day05_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_BoniGarciaWebdriver {

    public static void main(String[] args) {

        //Bir class'ta test islemlerine baslamadan once
        //ilk olarak Webdriver objemizi olusturmali
        //ve gerekli ayarlari yapmaliyiz.

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        driver.quit();
    }
}
