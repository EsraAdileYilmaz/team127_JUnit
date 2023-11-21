package tests.day06_JunitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {

    // 3 farkli test method'u olusturarak
    // asagidaki testleri yapin
    // 1- test otomasyonu.com sitesine gidin
    // 2- phone, shoes ve dress icin arama yapin
    // 3- arama sonucunda urun bulunabildigini test edin
    // 4- sayfayi kapatin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void phoneTesti(){//Once @Before public void setup() bu method calisacak
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://testotomasyonu.com");

        // 2- phone icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // 3- arama sonucunda urun bulunabildigini test edin
        WebElement sonucYazisiElementi= driver.findElement(By.className("product-count-text"));

        String sonucYazisiStr= sonucYazisiElementi.getText().replaceAll("\\D","");//"4"
        int sonucYazisiInt=Integer.parseInt(sonucYazisiStr);

        if(sonucYazisiInt > 90){
            System.out.println("Phone testi PASSED");
        }else{
            System.out.println("Phone testi FAILED");
            throw new AssertionFailedError();
        }
        // @After  public void teardown() enson bu method calisacak.
    }

    @Test
    public void shoesTesti(){//Once @Before public void setup() bu method calisacak

        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://testotomasyonu.com");

        // 2- shoes icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes"+ Keys.ENTER);

        // 3- arama sonucunda urun bulunabildigini test edin
        WebElement sonucYazisiElementi= driver.findElement(By.className("product-count-text"));

        String sonucYazisiStr= sonucYazisiElementi.getText().replaceAll("\\D","");//"4"
        int sonucYazisiInt=Integer.parseInt(sonucYazisiStr);

        if(sonucYazisiInt > 0){
            System.out.println("Shoes testi PASSED");
        }else{
            System.out.println("Shoes testi FAILED");
            throw new AssertionFailedError();
        }
        // @After  public void teardown() enson bu method calisacak.
    }

    @Test @Ignore
    public void dressTesti(){//Once @Before public void setup() bu method calisacak
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://testotomasyonu.com");

        // 2- dress icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress"+ Keys.ENTER);

        // 3- arama sonucunda urun bulunabildigini test edin
        WebElement sonucYazisiElementi= driver.findElement(By.className("product-count-text"));

        String sonucYazisiStr= sonucYazisiElementi.getText().replaceAll("\\D","");//"10"
        int sonucYazisiInt=Integer.parseInt(sonucYazisiStr);//10

        if(sonucYazisiInt > 0){
            System.out.println("Dress testi PASSED");
        }else{
            System.out.println("Dress testi FAILED");
            throw new AssertionFailedError();
        }
        // @After  public void teardown() enson bu method calisacak.
    }



}
