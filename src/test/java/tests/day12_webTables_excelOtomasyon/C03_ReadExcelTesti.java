package tests.day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcelTesti {

    Sheet sayfa1;

    @Test
    public void readExcelTesti() throws IOException {


        String dosyaYolu = "src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);//dosya okuma objesi
        Workbook workbook = WorkbookFactory.create(fileInputStream);//kopya excel
        sayfa1 = workbook.getSheet("Sayfa1");//hangi sayfadaki bilgileri kullanacaksak bire bir aynisini yaziyoruz "Sayfa1"

        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));//Başkent (İngilizce)
        //yazdirirken direk yazdirabiliyoruz ,
        //ancak String bir variable'a atamak istersek toString() methodu ile once stringe cevirmemiz gerekir.

        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucreStr = sayfa1.getRow(0).getCell(1).toString();
        System.out.println("String olarak istenen hucre: " + istenenHucreStr);

        //		- 2.satir 4.cell’in Afganistan’in baskenti "Kabil" oldugunu test edelim
        String expectedCell = "Kabil";
        String actualCell = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedCell, actualCell);

        //		- Satir sayisini bulalim
        int satirSayisi = sayfa1.getLastRowNum();//getLastRowNum() methodu en son satir numarasini getir demektir.
        System.out.println("Sayfa1'deki satir sayisi: " + (satirSayisi + 1));//satirSayisi+1 yaptik cunku index 0'dan basliyor

        //      - Samoa ulkesinin baskent isminin Apia oldugunu test edin
        String expectedBaskent = "Apia";
        String actualBaskent = "";

        //int satirSayisi=sayfa1.getLastRowNum();yukarda satir sayisini bulmustuk
        for (int i = 0; i <= satirSayisi; i++) {
            //oncelikle ulkenin hangi satirda oldugunu bulmamiz gerekir.
            String ulkeIsmi = sayfa1.getRow(i).getCell(0).toString();//getRow(i) her bir satira bakmasi icin.Burada ulke ismini bulmus olacagiz
            if (ulkeIsmi.equalsIgnoreCase("Samoa")) {//ulke ismi samoa oldugunda;
                actualBaskent = sayfa1.getRow(i).getCell(1).toString();
            }
        }

        Assert.assertEquals(expectedBaskent, actualBaskent);


        // - Verdigimiz ingilizce ulke ismi ve dil tercihine gore baskent ismini
        //   bize donduren bir method olusturun


        System.out.println(baskentBul("Peru", "Turkce")); // Lima
        System.out.println(baskentBul("Bangladesh", "ingilizce")); // Dhaka
        System.out.println(baskentBul("barbados", "turkce"));//Bridgetown
        System.out.println(baskentBul("Bosnia & Herzegovina","turkce"));//Saraybosna


        // - Fiziki olarak kullanilan satir sayisini bulun
        //getPhysicalNumberOfRows() methodu indexi degil, gercekten kullanilan satir sayisini verir.

        System.out.println("Fiziki olarak kullanilan satir sayisi: " + sayfa1.getPhysicalNumberOfRows());//Fiziki olarak kullanilan satir sayisi: 191


    }

    public String baskentBul(String ulkeAdi, String dilTercihi) {

        String satirdakiUlkeAdi = "";
        String baskentIsmi = "";

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            satirdakiUlkeAdi = sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiUlkeAdi.equalsIgnoreCase(ulkeAdi)) {//satirdaki ulke adi, istenen ulke adiyla ayniysa

                if (dilTercihi.equalsIgnoreCase("ingilizce")) { // ingilizce olarak baskenti getirir

                    baskentIsmi = sayfa1.getRow(i).getCell(1).toString();

                } else { // turkce olarak baskenti getirir

                    baskentIsmi = sayfa1.getRow(i).getCell(3).toString();
                }
            }

        }
        return baskentIsmi;

    }
}
