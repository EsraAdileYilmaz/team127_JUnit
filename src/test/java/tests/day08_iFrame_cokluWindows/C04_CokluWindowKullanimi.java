package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import tests.utilities.TestBase;

public class C04_CokluWindowKullanimi extends TestBase {

    @Test
    public void handleWindowsTest(){

        /**
         Biz bir driver ile yaptigimiz tum islemlerde ayni windowda calistik.
         driver bu sebeple yaptigimiz her islemi ayni window icinde arastirir.
         Isterseniz siz yeni bir tab (sekme) veya window olusturabilirsiniz
         */

        driver.get("https://www.testotomasyonu.com");
        System.out.println(driver.getWindowHandle());

        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());

        driver.navigate().back();
        System.out.println(driver.getWindowHandle());

        //yeniden test otomasyonu sayfasindayiz ve electronics linkini tiklayalim
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        System.out.println(driver.getWindowHandle());

       //tum islemler ayni TAB icinde yapildigi icin handle degerleri degismedi.
    }
}
