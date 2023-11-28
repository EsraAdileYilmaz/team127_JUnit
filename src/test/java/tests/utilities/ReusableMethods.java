package tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi){

        List<String> stringlerListesi=new ArrayList<>();
        for (WebElement each:elementlerListesi
             ) {
         stringlerListesi.add(each.getText());
        }
        return stringlerListesi;
    }

    public  static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static WebDriver titleIleSayfaDegistir(WebDriver driver, String hedefSayfaTitle) {

        Set<String> tumWhdSeti=driver.getWindowHandles();
        for (String each:tumWhdSeti
             ) {
            String eachTitle=driver.switchTo().window(each).getTitle();
            //driver'imiz each'in getirdigi herbir yeni window'a sirasiyla gecip oranin title'ini getirecek.bizde bunu String bir variable'a atayacagiz.

            if(eachTitle.equals(hedefSayfaTitle)){//each'in getirdigi title'lardan biri
                                                  //bizim hedef title'imiza esit oldugunda driver direk o window'a gececek.
                return driver;
            }
        }
     //bu methodla istenilen kadar whd verilse bile icinden hedefSayfaTitle'ini bulup
     //driver direk o window'a gecer
        return driver;

    }

    public static String ilkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {

        Set<String > tumWhdSeti = driver.getWindowHandles();

        tumWhdSeti.remove(ilkSayfaWhd);//Set'te bulunan iki whd degerinden, ilk kaydedilen whd'yi silip
                                       //kalan whd'yi String bir variable'a atayip donduruyor.

        for (String each:tumWhdSeti
        ) {
            return each;
        }
     //bu methodla sadece 2 whd degeri uzerinden secim yapilabilir
        return null; // bu satirin hic calismayacagini biliyoruz
        // sadece javanin endiselerini gidermek icin yazdik.
    }
}
