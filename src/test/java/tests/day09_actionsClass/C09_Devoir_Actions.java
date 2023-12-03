package tests.day09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C09_Devoir_Actions extends TestBase {

    @Test
    public void actionsTesti(){

      //1) "https://webdriveruniversity.com/Actions" sayfasina gidin
      //2)"Hover over Me First" kutusunun ustune gelin
      //3) "Link 1"e tiklayin
      //4)Popup mesajini yazdirin
      //5)Popup'i tamam diyerek kapatin
      //6)"Click and hold" kutusuna basili tutun
      //7)"Click and hold" kutusunda cikan yaziyi yazdirin
      //8)"Double click me" butonuna cift tiklayin

        //1) "https://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("https://webdriveruniversity.com/Actions");

        //2)"Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);//bu objeyi 1kez olusturmak yeterli oluyor.
        WebElement hoverOvermeElementi= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOvermeElementi).perform();

        //3) "Link 1"e tiklayin
        ReusableMethods.bekle(3);
       WebElement link1=driver.findElement(By.xpath("(//a[text()='Link 1'])[1]"));
       link1.sendKeys(Keys.ENTER);

        //4) Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5)Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6)"Click and hold" kutusuna basili tutun
        WebElement clickHoldElementi= driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickHoldElementi).perform();


        //7)"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHoldElementi.getText());


        //8)"Double click me" butonuna cift tiklayin
        WebElement doubleClickmeElementi= driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickmeElementi).perform();



    }
}
