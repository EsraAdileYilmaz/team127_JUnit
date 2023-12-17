package tests.day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelOtomasyonu {


    @Test
   public void excelOtomasyonTesti() throws IOException {

        /*
            Bilgisayarimizdaki fiziki bir dosyayi
            kodlarimiza direk eklememiz mumkun degildir.
            pom.xml'e yuklenen Apache poi'ler verdigimiz dosya yolundaki
            fiziki excel dosyasinda bulunan tum datalari
            fileInputStream objesi sayesinde okuyup
            o bilgileri kullanabileceginiz
            EXCEL dosyasinin KOPYASINI (workbook'u) olusturur.

            Biz de bu kopya excel uzerinde istedigimiz islemleri yapabiliriz.

            ONEMLI NOT :
            bu test methodu icinde yaptigimiz tum islemler
            excel uzerinde degil,
            olusturdugumuz Workbook objesinin bulundugu satirin (42.satirin)
            calistigi anda excel'de varolan bilgiler uzerindedir.

            satir ve sutun bilgileri index ile calisir
            yani 0'dan baslar.

            Class icinde Workbook,Sheet,Row ve Cell objelerinin 1 kez olusturulmasi YETERLIDIR.
         */
        String dosyaYolu="src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";//indirilen excel dosyasinin dosya yolu.bu yol projedeki herkeste ayni olmalidir
        //"user.dir" den sonraki kismi verdi.
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);//dosya okuma objesi olusturuyoruz
        Workbook workbook= WorkbookFactory.create(fileInputStream);//kopya excell'i olusturuyoruz
        Sheet sayfa1=workbook.getSheet("Sayfa1");//excell'in icindeki islem yapmak istedigimiz sayfayi seciyoruz.
        Row ucuncuSatir=sayfa1.getRow(3);// index=3, fiziki olarak 4.satira gider
        Cell ikinciData=ucuncuSatir.getCell(2);// index=2, fiziki olarak 3.dataya gider

        System.out.println(ikinciData);//Cezayir

        // 12.satirda bulunan ulkenin turkce isminin "Azerbaycan" oldugunu test edin
        String expectedUlkeAdi="Azerbaycan";
        String actualIstenenUlkeAdi=sayfa1.getRow(11).getCell(2).toString();
        //toString() methodu ile getirilen bilgiyi String'e cevirdik.cunku getirilen bilgi, Cell formundaydi.
        Assert.assertEquals(expectedUlkeAdi,actualIstenenUlkeAdi);
















    }


}
