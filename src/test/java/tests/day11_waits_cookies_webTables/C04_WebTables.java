package tests.day11_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {


    @Test
    public void webTableTesti() {

         /*
            Klasik HTML kodlari kullanilarak olusturulan web tablolarinda,
            istedigimiz cell(hucre)'deki data'ya ulasmak icin,
            sadece taglari kullanarak //tablo(table)/tbody/satir(tr)/data(td) siralamasi kullaniriz.

            1- Eger 1 of 1 bilgisine ulasabiliyorsak tum yolu yazmamiza gerek yok.
            2- Eger sadece child HTML taglara bakmak isteniyorsa "/" kullaniriz,
               child HTML taglarla birlikte grandChild taglara da bakmak istersek "//" kullaniriz

         */
        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table'in tum body’sini yazdirin
        WebElement tumBodyElementleri = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(tumBodyElementleri.getText());


        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedIcerik = "Comfortable Gaming Chair";
        String actualTumBodyIcerik = tumBodyElementleri.getText();
        Assert.assertTrue(actualTumBodyIcerik.contains(expectedIcerik));

        //4.Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriListesi = driver.findElements(By.xpath("//table/tbody/tr"));
        //bu locate'le tum satirlari elde ederiz ve bunlar WebElement oldugu icin List<> icine atariz.
        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriListesi.size();
        Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);


        //5.Tum satirlari yazdirin
        System.out.println("=======Tum Satirlar=======");
        // System.out.println(satirElementleriListesi);//WebElementler direk yazdirilamazlar,referanslarini yazdirir.
        //1.YOL =tum listeyi String'lerden olusan listeye cevirip yazdirabiliriz
        ReusableMethods.stringListeDonustur(satirElementleriListesi);//bunu List<String> 'e atamaliyiz.
        List<String> satirListesiStr = ReusableMethods.stringListeDonustur(satirElementleriListesi);
        System.out.println(satirListesiStr);

        //2.YOL=veya satir webelementlerini bir for loop ile yazdirip, basina aciklama da ekleyebiliriz.
        for (int i = 0; i < satirElementleriListesi.size(); i++) { //List<WebElement> satirElementleriListesi'nin size()
            System.out.println(i + 1 + ". satir : " + satirElementleriListesi.get(i).getText());
            //satirElementleriListesi'nin her bir elementinin textini getir
        }


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        /*
            Web table'da sutun yapisi yoktur,
            satirlar ve o satirlardaki datalar vardir.

            Sutun sayisini elde etmek icin,
            herhangi bir satirdaki data sayisini esas aliriz.
         */
        //bunun en kolay yolu herhangi bir satirdaki hucre sayisini bulmaktir //table/tbody/tr[1]/td
        List<WebElement> bodyElementleriListi = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        // List<WebElement> baslikElementleriListi = driver.findElements(By.xpath("//thead/tr/th"));  2.yol basliklardan elde edilir
        int expectedSutunSayisi = 4;
        int actualSutunSayisi = bodyElementleriListi.size();
        Assert.assertEquals(expectedSutunSayisi, actualSutunSayisi);


        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleriListi = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));//td[3] ile tum 3.datalari yani Price sutununu getir diyoruz
        //ucuncu sutundaki price webelementlerinin tamamini getirir.
        System.out.println("========3. Sutun Elementleri========");
        // for loop ile yazdiralim
        for (int i = 0; i < ucuncuSutunElementleriListi.size(); i++) {
            System.out.println(i + 1 + ". satirdaki 3. sutun : " + ucuncuSutunElementleriListi.get(i).getText());
            //ucuncuSutunElementleriListi'nin her bir elementinin textini getir.
        }


        //8. Tablodaki basliklari yazdirin
        //   list olarak yazdiralim.
        //1.YOL Reusable methoddaki hazirladigimiz methodu kullanma
        List<WebElement> baslikElementleriListi = driver.findElements(By.xpath("//thead/tr/th"));
        List<String> baslikElementleri = ReusableMethods.stringListeDonustur(baslikElementleriListi);
        System.out.println("Basliklar :" + baslikElementleri);


        //9.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun.

        System.out.println(getCellData(1, 3));//$399.00
        System.out.println(getCellData(2, 1));//Samsung White Smart Watch
        System.out.println(getCellData(4, 2));//Furniture


        //10.  4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedCategory = "Furniture";
        String actualCategory = getCellData(4, 2);
        Assert.assertEquals(expectedCategory, actualCategory);


    }

    public String getCellData(int satirNo, int sutunNo) {
        // ornegin==> //tbody/tr[4]/td[3]    tr[]=satir   td[]=sutun  asagida bunu dinamik olarak yazacagiz.

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenCellDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenCellDataElementi.getText();
    }
}
