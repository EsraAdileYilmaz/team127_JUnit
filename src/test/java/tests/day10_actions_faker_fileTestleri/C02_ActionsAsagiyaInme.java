package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C02_ActionsAsagiyaInme extends TestBase {

    @Test
    public void iFrameTesti(){

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        //asagiya inmek icin Actions class'ina ihtiyacimiz var
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //sayfanin altina inmek icin Keys.PAGE_DOWN yapariz. 1 veya 2 kez yapilabilir.

        //4- videoyu izlemek icin Play tusuna basin
        // play butonu iframe icinde oldugundan, once iframe'e gecis yapmaliyiz.
        ReusableMethods.bekle(2);
        WebElement iFrameElementi= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //oncelikle iframe'i locate ettik
        driver.switchTo().frame(iFrameElementi);
        //driver'i oraya gecirdik
        driver.findElement(By.xpath("//button[@title='Lire']")).click();

        //5- videoyu calistirdiginizi test edin
        WebElement pauseButton= driver.findElement(By.xpath("//*[@*='ytp-play-button ytp-button']"));
        //pause butonu ile kontrollerimizi yani testlerimizi yapacagiz.
        ReusableMethods.bekle(2);
        Assert.assertTrue(pauseButton.isDisplayed());


    }
}
