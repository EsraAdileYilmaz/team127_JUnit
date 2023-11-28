package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C05_DragAndDrop extends TestBase {

    @Test
    public void dragAndDropTesti(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        //once tasinacak element locate edilmeli,sonra tasinacak yer locate edilmelidir.
        WebElement acceptableElementi= driver.findElement(By.id("draggable2"));
        WebElement tasinacakHedefAlan= driver.findElement(By.id("droppable2"));

        ReusableMethods.bekle(2);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(acceptableElementi,tasinacakHedefAlan).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedAlanYazisi="Dropped!";
        String actualAlanYazisi=tasinacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazisi,actualAlanYazisi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        //sayfayi yeniledigimizde StaleElementException verebilir.bu durumda kodlarimizida yenilemek
        //adina kullandigimiz kodlari copier-coller yapmaliyiz.

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElementi= driver.findElement(By.id("draggable-nonvalid2"));
        tasinacakHedefAlan= driver.findElement(By.id("droppable2"));//copier-coller ile kodumuzu tazeledik
        ReusableMethods.bekle(2);
        actions=new Actions(driver);//copier-coller ile kodumuzu tazeledik
        actions.dragAndDrop(notAcceptableElementi,tasinacakHedefAlan).perform();

        //6- “Drop Here” yazisinin degismedigini test edin
        expectedAlanYazisi="Drop Here";
        actualAlanYazisi=tasinacakHedefAlan.getText();
        Assert.assertEquals(expectedAlanYazisi,actualAlanYazisi);






    }
}
