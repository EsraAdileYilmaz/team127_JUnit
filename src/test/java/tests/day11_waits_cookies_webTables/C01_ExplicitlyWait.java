package tests.day11_waits_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Struct;
import java.time.Duration;

public class C01_ExplicitlyWait {


    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitlyWait() , explicitlyWait()
    //	 Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin


    @Test
    public void implicitlyWaitTesti(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //WebElement itsgoneElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        WebElement itsgoneElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsgoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. "It’s back" mesajinin gorundugunu test edin
        //WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        WebElement itsbackElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsbackElementi.isDisplayed());


        //8.Sayfayi kapatin
        driver.quit();

    }

    @Test
    public void explicitlyWaitTesti(){

      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //“It’s gone!” mesajina basildigi an goruntulenemiyor.belli bir sure bekleme gerektiriyor.

         /*
            Eger kullanmak istedigimiz element locate edilebilir durumda ise yani gorunur durumda ise;
            once locate edip,
            sonra istenen condition(ExpectedConditions) icin bekleyebiliriz.
            Ama bu soruda oldugu gibi element gorunmuyorsa ve buyuzden
            locate ve bekleme kisir dongu olusturuyorsa;
            locate ve bekleme islemi birlikte yapilabilir.(2.adim ve 3.adim birlikte yapilabilir)

               1.adim : bir wait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
               2.adim : bekleyecegimiz webelement'i locate edin
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        NoSuchElementException verdi, elementi bulamadi cunku element gorunur durumda deil.
               3.adim : wait objesini kullanarak istediginiz webelement uzerinde islem yapin
        wait.until(ExpectedConditions.visibilityOf(itsGoneyaziElementi));
             */

        // 1.adim : bir wait objesi olusturun
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        // 2. adim : bekleme icin olusturdugumuz wait objesini kullanarak
        //           beklenecek webElement'in locate'ini ve beklemeyi birlikte yapariz.
        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //"WebElement By.xpath() yolu ile locate edilip gorunur oluncaya kadar bekle " demis oluyoruz.


        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();


        //7. "It’s back" mesajinin gorundugunu test edin.
        //"It’s back" mesajina basildigi an goruntulenemiyor belli bir sure beklemek gerekiyor.
        // 1.adim : bir wait objesi olusturun
        // ancak wait objesi yukarda olusturuldugu icin direk kullanacagiz ve beklenecek webElementin locate'ini ve beklemeyi birlikte yapariz.
        WebElement itsbackElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //"WebElement locate edilip gorunur oluncaya kadar bekle " demis oluyoruz.Ayni anda testimizide yapmis oluyoruz.


        //8.Sayfayi kapatin
        driver.quit();


    }

}
