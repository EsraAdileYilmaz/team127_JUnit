package tests.day06_JunitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_CheckBox {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkBoxTesti() {

        /*
         a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
         b. Sirt Agrisi ve Carpinti checkbox’larini secin
         c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
         d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin.
    */

        //a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiElementi = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiElementi.click();

        WebElement carpintiElementi = driver.findElement(By.id("gridCheck4"));
        //WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        carpintiElementi.click();

        // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assert.assertTrue(sirtAgrisiElementi.isSelected());
        Assert.assertTrue(carpintiElementi.isSelected());

        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));
        carpintiCheckBox.sendKeys(Keys.PAGE_DOWN);
        //sayfanin asagisina inmek icin bu kismi ekledik.WebElementi gorunur yaptik boylece

        //  d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin.
        WebElement sekerElementi = driver.findElement(By.id("hastalikCheck2"));
        Assert.assertFalse(sekerElementi.isSelected());

        WebElement epilepsiElementi = driver.findElement(By.id("hastalikCheck7"));
        Assert.assertFalse(epilepsiElementi.isSelected());

    }


}
