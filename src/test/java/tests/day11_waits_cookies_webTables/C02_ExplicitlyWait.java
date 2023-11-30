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
import tests.utilities.ReusableMethods;

import java.time.Duration;

public class C02_ExplicitlyWait {

    @Test
    public void explicitlyWaitTesti(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi= driver.findElement(By.xpath("//input[@type='text']"));
        //textbox elementi gorulebilir ve locate edilebilir ama kullanilamaz durumdadir.
        Assert.assertFalse(textboxElementi.isEnabled());

        //5. Enable butonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        //ve textbox etkin oluncaya kadar bekleyin.
        //burada textbox'in etkin olmasi icin bekleme yapmamiza ihtiyac var
             // 1.adim : wait objesi olustur
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
             // 2.adim : mumkunse kullanilacak webelementi locate et
             //          biz textbox'in kullanilabilir olmasini bekleyecegiz, textbox yukarda locate edildi.
             // 3.adim : wait objesi ile istenen webelement uzerinde expected condition yaparak bekle.
                    wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));
                    //textboxElementi clickable oluncaya kadar bekle.


        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledElementi= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(itsEnabledElementi.isEnabled());

        // 8.Sayfayi kapatin.
        driver.quit();








    }
}
