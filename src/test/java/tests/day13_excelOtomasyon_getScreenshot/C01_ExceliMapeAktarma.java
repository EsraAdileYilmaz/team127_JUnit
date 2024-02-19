package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExceliMapeAktarma {

    @Test
    public void readExcelTesti() throws IOException {
        //Excel'e ulasmak icin gereken ayarlar;
        String dosyaYolu="src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";//bu yolda bir dosya var demek
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //FileInputStream objesi=yukarda yolu verilen dosyayi okuyor.
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //okunan dosya icindeki bilgileri kaydetmek ve uzerinde islem yapmak icin workbook(kopya excell) objesi olusturuyoruz

        // 1) Ulkeler excel'indeki Turkce ulke isimleri ve Turkce baskent isimlerini bir Map olarak kaydedin
        // Ulke isimleri key, baskent isimleri value olsun.

        Map<String,String> ulkelerMap=new TreeMap<>();//suan map'imiz bos
        String satirdakiUlkeIsmi;
        String satirdakiBaskentIsmi;
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();//sayfa1'in son satirini getir

        for (int i = 0; i <=sonSatirIndex ; i++) {

            satirdakiUlkeIsmi=workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
            satirdakiBaskentIsmi=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);//bu satirda" Ülke (Türkçe),	Başkent (Türkçe)" nin tamamini map'e yukledik
        }
        //System.out.println(ulkelerMap);//{Afganistan=Kabil, Almanya=Berlin, Amerika Birleşik Devletleri=Washington DC, Andorra=Andorra la Vella, Angola=Luanda, Antigua ve Barbuda=Saint John’s, Arjantin=Buenos Aires, Arnavutluk=Tiran, Avustralya=Canberra, Avusturya=Viyana, ....}


        //2) Rusya'nin baskentinin Moskova oldugunu test edelim
        String expectedBaskentIsmi="Moskova";
        String actualBaskentIsmi=ulkelerMap.get("Rusya");//burda key verilmis value'su getir diyoruz
        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);


        //3) Listede baskenti San Marino olan bir ulke oldugunu test edelim
        Assert.assertTrue(ulkelerMap.containsValue("San Marino"));

        //4) Listede Filipinler ulkesinin oldugunu test edelim
        Assert.assertTrue(ulkelerMap.containsKey("Filipinler"));

    }
}
