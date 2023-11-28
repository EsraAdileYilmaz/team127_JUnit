package tests.day10_actions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C01_FacebookKullaniciOlusturma extends TestBase {

    @Test
    public void facebookTesti(){

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Cookies kabul edin
        driver.findElement(By.xpath("//button[@title='Autoriser tous les cookies']")).click();

        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@*='open-registration-form-button']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement prenomBox= driver.findElement(By.xpath("//*[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();//rastgele veriler atamak icin Faker class'indan obje olusturulur.
        ReusableMethods.bekle(2);

        String email=faker.internet().emailAddress();
        //faker class ile aldigimiz fake-mail adresini buraya kaydediyoruz cunku
        //sonrasinda ayni maille bir onay bekliyor.
        actions.click(prenomBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("jan")
                .sendKeys(Keys.TAB)
                .sendKeys("1982")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)//cinsiyet seceneklerine TAB'la gecmedigi icin sag veya sok okla secim yapiyoruz
                .sendKeys(Keys.LEFT)//once Keys.ARROW_RIGHT yapip masculin click()leniyor sonra Keys.LEFT yapincada feminin click() leniyor
                .perform();

        //5- Kaydol tusuna basalim
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[@name='websubmit']")).click();


    }



}
