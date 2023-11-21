package tests.day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_Xpath {

    public static void main(String[] args) {

          /*
        1- https://testotomasyonu.com/addremove/ adresine gidin
        2- Add Element butonuna basin
        3- Remove butonu’nun gorunur oldugunu test edin
        4- Remove tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        driver.findElement(By.id("sub-btn")).click();

        //3-Remove butonu’nun gorunur oldugunu test edin.
        WebElement removeButton=driver.findElement(By.className("remove-btn"));

        if(removeButton.isDisplayed()){
            System.out.println("Remove button gorunme testi PASSED");
        }else{
            System.out.println("Remove button gorunme testi FAILED");
        }

        //4- Remove tusuna basin
       //driver.findElement(By.className("remove-btn")).click(); 1.yol
        removeButton.click();//2.yol

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElementi=driver.findElement(By.tagName("h2"));

        if(addRemoveElementi.isDisplayed()){
            System.out.println("Add/Remove gorunme testi PASSED");
        }else {
            System.out.println("Add/Remove gorunme testi FAILED");
        }

        //6-Remove butonunun gorunur olmadigini (gorunmedigini) test edin.
      /*
        Remove butonu Add'e click() yapildiginda gozukuyor ama normalde gozukmuyor.
        Oyuzden gorunur olma durumu icin =>expected olan= gorunmemesidir.
        Eger Add'e click() yapilinca alinan locate ,click() yapilmadan da calisiyorsa;testimiz FAILED olur.
        Eger Add'e click() yapilinca alinan locate ,click() yapilmadan calismiyorsa;testimiz PASSED olur.

         */

        try {
            removeButton =driver.findElement(By.className("remove-btn"));
            //Bu locate Add'e click() yapildiktan sonra alinan locate'dir.
            System.out.println("Remove butonu gorunmeme testi FAILED");
        } catch (NoSuchElementException e) {//bulamayinca bu exception'i firlaticak
            System.out.println("Remove butonu gorunmeme testi PASSED");

        }



        driver.quit();

    }
}
