package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C06_MoveToElement extends TestBase {

    @Test
    public void moveToElement() {

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);//gecislerden once 1-2 sn mutlaka bekletilmelidir.yoksa hata verme olasiligi cok yuksek
        WebElement kidsWearElementi = driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));
        actions.moveToElement(kidsWearElementi).perform();

        //3- “Boys” linkine basin
        //WebElement boysLinki = driver.findElement(By.xpath("(//ul[@class='submenu-link'])[2]"));
        WebElement boysLinkiElementi = driver.findElement(By.xpath("//a[text()='Boys']"));
        boysLinkiElementi.click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        //driver.findElement(By.className("product-box mb-2 pb-1")).click();
        driver.findElement(By.xpath("(//div[@class='product-box mb-2 pb-1'])[1]")).click();

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement ilkUrunYaziElementi = driver.findElement(By.xpath("//div[text()='Boys Shirt White Color']"));
        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = ilkUrunYaziElementi.getText();
        Assert.assertEquals(expectedUrunIsmi, actualUrunIsmi);


    }
}
