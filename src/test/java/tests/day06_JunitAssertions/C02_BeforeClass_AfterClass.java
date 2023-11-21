package tests.day06_JunitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {

    // 3 farkli test methodu olusturarak
    // asagida verilen gorevi tamamlayin
    // 1- testotomasyonu.com sayfasina gidin,
    //    url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yaptirin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urune tiklayin
    //    ve urun aciklamasinda case sensitive olmadan phone gectigini test edin.

    /*
         Burada istenen test methodlarindaki gorevler birbirine bagli methodlardir.
         Herbir test methodu birbirine bagli olarak calisir.
         Bu gorevlerin saglikli olarak yapilabilmesi icin;
        1- test method'larinin dogru sirada calismasi gerekir
        2- driver objesi tum method'lardan once olusturulmali
          ve tum method'lar calistiktan sonra kapatilmalidir.

          Bunu saglayabilmek icin @BeforeClass ve @AfterClass notasyonlari kullaniriz.
          ANCAK dikkat etmemiz gereken konu
          bu notosyonlari kullanan method'lar "static" OLMAK ZORUNDADIR

          Ayrica JUnitin test methodlarini hangi sirada calistiracagini bilemedigimizden
          test methodlarina isim verirken sayi ile isimlendirme yapiyoruz.Ancak yanina
          kesinlikle bir yazi yazmiyoruz.
          Ornegin:  public void test01()
                    public void test02()
                    public void test03() gibi
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){//Class'in en basinda bu method calisir.ama sadece 1 kez calisir.

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("before calisti");
    }

    @AfterClass
    public static void teardown(){//Class'in en sonunda bu method calisir.ve sadece 1 kez calisir
        System.out.println("after calisti");
        driver.quit();
    }





    @Test
    public void test01(){

        //url testi
        // 1- testotomasyonu.com sayfasina gidin,
        driver.get("https://www.testotomasyonu.com");

        //    url'in testotomasyonu icerdigini test edin
        String expectedUrl="testotomasyonu";
        String actualUrl= driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
            throw new AssertionFailedError();
        }

    }

    @Test
    public void test02(){

        //arama testi
        // 2- phone icin arama yaptirin
        WebElement aramaKutusu= driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // ve arama sonucunda urun bulunabildigini test edin.
        WebElement sonucYazisiElementi= driver.findElement(By.className("product-count-text"));
        String sonucYazisiStr=sonucYazisiElementi.getText().replaceAll("\\D","");
        int sonucYazisiInt=Integer.parseInt(sonucYazisiStr);

        if(sonucYazisiInt > 0){
            System.out.println("Arama testi PASSED");
        }else{
            System.out.println("Arama testi FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test03(){

        //ilk urun detay testi
        // 3- ilk urune tiklayin
        driver.findElement(By.className("prod-img")).click();

        //    ve urun aciklamasinda case sensitive olmadan phone gectigini test edin.
        WebElement urunAciklamaElementi= driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedUrunIcerik="phone";
        String actualUrunIcerik=urunAciklamaElementi.getText().toLowerCase();

        if(actualUrunIcerik.contains(expectedUrunIcerik)){
            System.out.println("Ilk urun testi PASSED");
        }else {
            System.out.println("Ilk urun testi FAILED");
            throw new AssertionFailedError();
        }

    }


}
