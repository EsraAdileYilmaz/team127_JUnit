package tests.day07_testBaseClass_Drapdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C03_DropdownMenu extends TestBase {

    @Test
    public void dropdownTesti(){

        // https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        // - ilk adim : kullanacagimiz ddm locate edip kaydedelim
        WebElement gunElementi = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        // - ikinci adim : bir select objesi olusturalim
        //                 parametre olarak locate etttigimiz ddm'yu yazalim
        Select selectGun=new Select(gunElementi);
        // -ucuncu adim : olusturdugumuz select objesi ile istenen islemleri yapin
        selectGun.selectByIndex(5);//Gun yazisi 0.index oluyor


        //	2. Dogum tarihi ay seçeneğinden visibleText kullanarak Nisan’i secin
        WebElement ayElementi= driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy=new Select(ayElementi);
        selectAy.selectByVisibleText("Nisan");


        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilElementi= driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil=new Select(yilElementi);
        selectYil.selectByVisibleText("1990");


        //  4. Secilen degerleri konsolda yazdirin
        //     Dropdown menude secim yaptiktan sonra
        //     yapilan secimi yazdirmak isterseniz=>select.getFirstSelectedOption().getText() kullaniriz.
        System.out.println("Secilen tarih: "+ selectGun.getFirstSelectedOption().getText()+
                           " "+selectAy.getFirstSelectedOption().getText()+
                           " "+selectYil.getFirstSelectedOption().getText());


        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayElementleriListesi= selectAy.getOptions();
        System.out.println(ReusableMethods.stringListeDonustur(ayElementleriListesi));
        //[Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

        //	6. Ay Dropdown menusunun boyutunun 30 olduğunu test edin
        Assert.assertEquals(30,ayElementleriListesi.size());
        //expected=30, actual=ayElementleriListesi.size(); listenin uzunlugu kadar

    }

}
