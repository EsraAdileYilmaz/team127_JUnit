package tests.day11_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void cookieTestleri(){

        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        ReusableMethods.bekle(2);
        Set<Cookie> cookieSeti=driver.manage().getCookies();
        int siraNo=1;
        for (Cookie each:cookieSeti
             ) {
            System.out.println(siraNo + "==>" + each);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookieSayisi=5;
        int actualCookieSayisi=cookieSeti.size();
        Assert.assertTrue(actualCookieSayisi > expectedCookieSayisi);

        //4- ismi "i18n-prefs" olan cookie degerinin "USD" oldugunu test edin
        String expectedCookieValue="USD";
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        //"i18n-prefs" isimli cookie'nin valuesunu alip String bir variable 'a atadik.
        Assert.assertEquals(expectedCookieValue,actualCookieValue);


        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin.
        //1.adim : Cookie objesi olusturulur
        Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        //2.adim :  driver.manage().addCookie();
        driver.manage().addCookie(yeniCookie);


        //6- Ekledigimiz cookie’nin sayfaya eklendigini test edin.
        cookieSeti=driver.manage().getCookies();//bu kodu burada refresh yapinca yeni olusturulan cookies Set'in icine burada ekleniyor.
        siraNo=1;
        for (Cookie each:cookieSeti
             ) {
            System.out.println(siraNo +"==>" +each);
            siraNo++;
        }

        expectedCookieValue="cikolatali";
        actualCookieValue=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);


        //7- ismi "skin" olan cookie’yi silin ve silindigini test edin.
        // olmayan bir cookie'nin degerini yazdirsak==> null dondurur.
        System.out.println(driver.manage().getCookieNamed("Boyle bir cookie yok")); // null

        driver.manage().deleteCookieNamed("skin");
        Assert.assertTrue(driver.manage().getCookieNamed("skin") == null);
        //yani silinen cookie'yi bulamayacagi icin value'sunu null dondurur.


        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSeti=driver.manage().getCookies();//eger Set<>'in ici bossa silinmistir.
        Assert.assertTrue(cookieSeti.size() == 0);









    }
}
