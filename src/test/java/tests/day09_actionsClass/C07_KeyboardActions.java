package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C07_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        //2- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
        //   ve Enter’a basarak arama yaptirin
        WebElement searchBox= driver.findElement(By.id("global-search"));
        ReusableMethods.bekle(2);
        Actions actions=new Actions(driver);
         actions.click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .perform();
        actions.sendKeys(Keys.ENTER).perform();

        //4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"));
        String expectedUrunisim="DELL Core I3";
        String actualUrunisim=urunIsimElementi.getText();
        Assert.assertTrue(actualUrunisim.contains(expectedUrunisim));







    }
}
