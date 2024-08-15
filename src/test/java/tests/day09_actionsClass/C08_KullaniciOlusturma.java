package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C08_KullaniciOlusturma extends TestBase {

    @Test
    public void kullaniciOlusturmaTesti() {

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]")).click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNameBox = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);
        actions.click(firstNameBox)//Ilk kutucuga tiklanir sonrasinda tab'la devam edilir
                .sendKeys("Esra")
                .sendKeys(Keys.TAB)//TAB tusuyla yana gec
                .sendKeys("Yilmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("yilmaz@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();
        driver.findElement(By.id("btn-submit-form")).click();//SignUp butonuna bastik


        //5- Kaydin olusturuldugunu test edin
        // Kayit olusturulunca bizi signIn sayfasina yonlendiriyor
        // Kaydin olusturuldugunu test etmek icin
        // girdigimiz bilgilerle login olabildigimizi test edelim
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("yilmaz@gmail.com");
        passwordKutusu.sendKeys("12345");
        signInButonu.click();

        ReusableMethods.bekle(2);
        WebElement logoutLinki = driver.findElement(By.xpath("//span[text()='Logout']"));
        Assert.assertTrue(logoutLinki.isDisplayed());
        logoutLinki.click();

    }
}
