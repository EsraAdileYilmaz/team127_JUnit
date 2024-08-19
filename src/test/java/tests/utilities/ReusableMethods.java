package tests.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods extends TestBase{

    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi){

        List<String> stringlerListesi=new ArrayList<>();
        for (WebElement each:elementlerListesi
             ) {
         stringlerListesi.add(each.getText());
        }
        return stringlerListesi;
    }//WebElementlerden olusan listeyi Stringlerden olusan listeye cevirme metodu
     //List<String> baslikElementleri =ReusableMethods.stringListeDonustur(baslikElementleriListi);




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
             ) {//each her bir Whd degerini getirecek sirayla
            String eachTitle=driver.switchTo().window(each).getTitle();
            //driver'imiz each'in getirdigi herbir yeni tab/window'a sirasiyla gecip oranin title'ini getirecek.bizde bunu String bir variable'a atayacagiz.

            if(eachTitle.equals(hedefSayfaTitle)){//each'in getirdigi title,
                                                  //bizim hedef title'imiza esit oldugunda
                                                  // driver direk o window'a gececek.
                return driver;
            }
        }

        return driver;

    } //Bu methodla istenilen kadar whd verilse bile icinden hedefSayfaTitle'ini bulup
      //driver direk o window'a gecer. driver = ReusableMethods.titleIleSayfaDegistir(driver,"yenititle")



    public static String ilkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {

        Set<String > tumWhdSeti = driver.getWindowHandles();

        tumWhdSeti.remove(ilkSayfaWhd);//Set'te bulunan iki whd degerinden,kaydedilen ilk sayfa whd'yi silip
                                       //kalan ikinci whd'yi kullaniyoruz.

        for (String each:tumWhdSeti
        ) {
            return each;
        }

        return null; //Bu satirin hic calismayacagini biliyoruz.sadece javanin endiselerini gidermek icin yazdik.

    } //Bu methodla sadece 2 whd degeri uzerinden secim yapilabilir
      //String ikinciWhd = ReusableMethods.ilkSayfaWhdIleIkinciSayfaWhdBul(driver, ilkSayfaWhd); yapilarak kullanilir



    public static void tumSayfaTakeScreenshot(WebDriver driver){
        // tum sayfanin fotografini cekip kaydedin

        // 1.adim tss objesi olustur

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        //   her yeni kaydedilen resmin oncekinin ustune kaydedilmemesi icin
        //   kaydedilecek dosya yolunu dinamik yapabiliriz
        //   dinamik yapmak icin dosya yoluna tarih etiketi ekleyelim

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/tumSayfaScreenshot" +
                localDateTime.format(istenenFormat)+
                ".jpg";

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asil-kalici dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(5);
    }





    public static void tumSayfaTakeScreenshot(String testAdi,WebDriver driver){
        //tum sayfanin fotografini cekip kaydedin

        //1.adim takesScreenShot(tss) objesi olusturun
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        //   her yeni kaydedilen resmin oncekinin ustune kaydedilmemesi icin
        //   kaydedilecek dosya yolunu dinamik yapabiliriz.
        //   dinamik yapmak icin dosya yoluna tarih etiketi ekleyelim.buna timestep denir.

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/"+
                testAdi
                +
                localDateTime.format(istenenFormat)+
                ".jpg";


        //File tumSayfaScreenshot=new File("target/screenshots/tumSayfaScreenshot.jpg");//bu dosya yolu dinamik deildir
        File tumSayfaScreenshot=new File(dinamikDosyaYolu);


        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim.
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        //bu dosya gecici kaydedilen dosyadir.ve burda screenshot yapmis olduk

        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);//eger burayi try-catch icine almazsak,her class'a throw exception eklememiz gerekir.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(5);

    }



    public static void istenenWebelementScreenshot(WebElement istenenWebelement){

        // 1.adim screenshot alacagimiz webelementi locate et

        // 2.adim scrennshot'i kaydedecegimiz file'i olusturalim
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/istenenWebelementScreenshot" +
                localDateTime.format(istenenFormat)+
                ".jpg";


        File istenenWebelementScreenshot = new File(dinamikDosyaYolu);

        // 3.adim webelement uzerinden screenshot'i alip gecici bir dosyaya kaydedin

        File geciciDosya = istenenWebelement.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya,istenenWebelementScreenshot);
        } catch (IOException e) {
            System.out.println("Screenshot kopyalanamadi");
            throw new RuntimeException(e);
        }
    }

    public String getCellData(int satirNo, int sutunNo) {
        // ornegin==> //tbody/tr[4]/td[3]    tr[]=satir   td[]=sutun  asagida bunu dinamik olarak yazacagiz.

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenCellDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenCellDataElementi.getText();
    }//Bu method klasik html kodlari ile yazilmis olan tablolarda satir sutun sayisi verilen hucrenin bilgisini dondurur



}
