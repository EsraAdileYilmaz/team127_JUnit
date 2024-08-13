package tests.day07_testBaseClass_Drapdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
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
    public void radioButtonKutuTesti() {
        //	a. Verilen web sayfasına gidin."https://testotomasyonu.com/form"
        driver.get("https://testotomasyonu.com/form");

        //	b. Cinsiyet Radio button elementlerini locate edin ve
        //    radio buttonu isaretleyerek size uygun olani secin
        WebElement radioButtonElementi = driver.findElement(By.xpath("//*[text()='Cinsiyet']"));//yazidan locate alindi


        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        kadinRadioButton.click();

        //c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());


    }

    @Test
    public void radioButtonYaziTesti() {

        //	a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //	b. Cinsiyet Radio button elementlerini locate edin ve
        //    yaziyi click ederek size uygun olani secin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // Secimi yazi ile yapabilirim yani tiklama isini yaziya click yapinca da tikliyor,
        // ama assertion'lar icin yazi uzerinden click yapilamiyor, radio button'larin locate'lerine ihtiyacimiz var
        WebElement kadinRadioButtonYaziElementi = driver.findElement(By.xpath("//*[text()='Kadın']"));//yazidan locate alindi
        kadinRadioButtonYaziElementi.click();

        //c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin.
        // secimi yazi ile yapabilirim
        // ama assertion'lar icin radio button'lara ihtiyacimiz var
        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
        //Testleri yapmak icin radioButtonlarinin locate'ine ihtiyacimiz var.
        //cunku yazi secilmis mi? diye test yapamayiz.
        //Button secilmis mi? diye test yapabiliriz.

    }
}
