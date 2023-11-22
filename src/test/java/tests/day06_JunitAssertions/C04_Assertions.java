package tests.day06_JunitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.utilities.ReusableMethods;

import java.time.Duration;

public class C04_Assertions {

    //  https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkinin görüntülendiğini test edin

    //bu test de tum adimlar birbirine bagli oldugu icin @BeforeClass ve @AfterClass kullanilmalidir.
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void teardown(){

        driver.quit();
    }

    @Test
    public void urlTesti(){

        // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void titleTesti(){

        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unexpectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unexpectedTitle));
    }

    @Test
    public void logoTesti(){

        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        ReusableMethods.bekle(1);
        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void francaisLinkTesti(){
        // FrancaisLinkTest => Fransizca Linkinin görüntülendiğini test edin

        WebElement francaisLinkElementi= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisLinkElementi.isDisplayed());
    }



}
