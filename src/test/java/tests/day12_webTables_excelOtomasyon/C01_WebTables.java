package tests.day12_webTables_excelOtomasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01(){

        //  1) “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2) Headers da bulunan basliklari yazdirin
        List< WebElement> baslikElementleriListi = driver.findElements(By.xpath("//*[@role='hdata']"));
        //eger locate= By.xpath("//*[@role='hrow']" ile alinirsa tum elementleri tek bir hucre elemeni olarak goruyor.
        //bu liste webelementlerden olustugu icin hemen yazdiramayiz
        List<String> baslikElementleriStr=ReusableMethods.stringListeDonustur(baslikElementleriListi);
        System.out.println("Basliklar: "+ baslikElementleriStr);//[Product Name, Category, Price, Actions]


        //  3) 3.sutunun basligini yazdirin
        //burada index yapisina dikkat edilmeli.3.sutun icin 2.index
        System.out.println("3. sutun basligi : "+baslikElementleriStr.get(2));

        //  4) Tablodaki tum datalari yazdirin
        List<WebElement> tabloDataElementleriListi=driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));
        //List<WebElement> tabloDataElementleriList = driver.findElements(By.xpath("//*[@role='tdata']")); ahmet h locate
        List<String>  tabloDataElementleriStr=ReusableMethods.stringListeDonustur(tabloDataElementleriListi);
        System.out.println("Tablodaki tum datalar: "+ tabloDataElementleriStr);

        //  5) Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki data sayisi : " +tabloDataElementleriStr.size());//Tablodaki data sayisi : 20
        System.out.println("Tablodaki data sayisi : " +tabloDataElementleriListi.size());//Tablodaki data sayisi : 20


        //  6) Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriListi=driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("Tablodaki urun satirlari sayisi : "+satirElementleriListi.size());//Tablodaki urun satirlari sayisi : 5



        //  7) Tablodaki sutun sayisini yazdirin
        //sutun sayisi ayni zamanda baslik elementlerinin sayisina esittir.cunku baslik elementleri kadar sutun olusturulur.
        System.out.println("Tablodaki sutun sayisi: "+baslikElementleriListi.size());


        //  8) Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleri=driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        List<String> ucuncuSutunElementleriStr=ReusableMethods.stringListeDonustur(ucuncuSutunElementleri);
        System.out.println("3. sutun elementleri: "+ucuncuSutunElementleriStr);//3. sutun elementleri: [$399.00, $399.00, $399.00, $40.00, $15.00]


        //  9) Tabloda " Category" si "Furniture" olan urunun fiyatini yazdirin
        WebElement urunFiyatElementi= driver.findElement(By.xpath("((//*[@role='trow'])[2]/*[@role='tdata'])[3]"));
        System.out.println(urunFiyatElementi.getText());

        /*
           COZUM YOLU=
           bir loop ile her bir satiri tek tek inceleyelim
           kategori degeri (yani 2.data) Furniture olan satirdaki,
           fiyat degerini(yani 3.data) yazdiralim.

         */
        /*
           oncelikle furniture'i elde edicez sonra furniture'in fiyatini elde edicez.
           yani 2.satirin 3. datasini ulasmamiz lazim.
         */
        String satirdakiKategoriXpath ="";
        String satirdakiFiyatXpath = "";

        for (int i = 1; i <= satirElementleriListi.size(); i++) {//1.satirdan baslasin her bir satiri tek tek kontrol etsin

            // i. satirdaki kategori elementinin locate'i
            satirdakiKategoriXpath = "((//*[@role='trow'])[" + i + "]/*[@role='tdata'])[2]";
            //burda herbir satirin 2.datasini elde edicez ve bunlardan furniture olani secicez
            satirdakiFiyatXpath = "((//*[@role='trow'])[" + i + "]/*[@role='tdata'])[3]";
            //burda herbir satirin 3.datasini elde edicez ve bunlardan furniture'in fiyatini secicez

            if (driver.findElement(By.xpath(satirdakiKategoriXpath)).getText().equals("Furniture")){

                System.out.println("Istenen urunun fiyati : " +
                        driver.findElement(By.xpath(satirdakiFiyatXpath)).getText());
            }

        }


        //10) Bir method olusturun, satir ve sutun sayisini girdigimde bana datayi yazdirsin.

         istenenHucredekiDatayiYazdir(1,3);// Istenen hucredeki data : $399.00
         istenenHucredekiDatayiYazdir(2,2);// Istenen hucredeki data : Electronics

        //Tabloda " Category" si "Furniture" olan urunun fiyatini yazdirin.
       //public String istenenHucredekiDatayiDondur(int satirNo,int sutunNo){} methodu yapalim

        String satirdakiKategoriDegeri ="";
        String satirdakiFiyatDegeri="";

        for (int i = 1; i <=satirElementleriListi.size() ; i++) {

            satirdakiKategoriDegeri = istenenHucredekiDatayiDondur(i,2);
            satirdakiFiyatDegeri = istenenHucredekiDatayiDondur(i,3);

            if (satirdakiKategoriDegeri.equals("Furniture")){
                System.out.println("Kategorisi Furniture olan urun fiyati : "+ satirdakiFiyatDegeri);
            }
        }
    }


    public void istenenHucredekiDatayiYazdir(int satirNo,int sutunNo){

        // ornek= ((//*[@role='trow'])[3]/*[@role='tdata'])[3]

        String dinamikXpath = "((//*[@role='trow'])[" + satirNo + "]/*[@role='tdata'])[" + sutunNo + "]";
        System.out.println("Istenen hucredeki data : " +
                driver.findElement(By.xpath(dinamikXpath)).getText());
    }

    public String istenenHucredekiDatayiDondur(int satirNo,int sutunNo){

        // ornek= ((//*[@role='trow'])[3]/*[@role='tdata'])[3]

        String dinamikXpath = "((//*[@role='trow'])[" + satirNo + "]/*[@role='tdata'])[" + sutunNo + "]";

          return driver.findElement(By.xpath(dinamikXpath)).getText();

    }
}
