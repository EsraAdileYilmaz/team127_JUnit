package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTesti() throws IOException {

        //2) Yeni bir test method olusturalim writeExcelTest()
        String dosyaYolu="src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";//bu yolda bir dosya var demek
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);//FileInputStream objesi=yukarda yolu verilen dosyayi okuyor.
        Workbook workbook= WorkbookFactory.create(fileInputStream);//okunan dosya icindeki bilgileri kaydetmek ve uzerinde islem yapmak icin workbook(kopya excell) objesi olusturuyoruz
        Sheet sayfa1=workbook.getSheet("Sayfa1");//bunu yaparak direk Sayfa1'e geldik


        //3) Adimlari takip ederek Sayfa1’deki 1.satira(yani 0.indexe) kadar gidelim
        //4) 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);//1.satira 5.hucre ekledik

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");//getCell(4).setCellValue("Nufus")=> olusturulan 4.cell'in icine value olarak Nufus ekle

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        //9) Dosyayi kaydedelim
        //Biz bu degisiklikleri workbook uzerinde yaptik.oyuzden bu degisiklikleri gercek excel'e kaydetmemiz lazim
        //AMMA gercek excel'e kaydederken bilgisayarimizdaki excel aciksa onu kapatmamiz gerekir.(Quitter yapmaliyiz)
        FileOutputStream fileOutputStream=new FileOutputStream(dosyaYolu);//dosya disina dogru akis sagliyoruz.
        //dosyaYolunu verdigim, dosyaya ekledigim bilgileri disa akis sagla demis oluyoruz
        workbook.write(fileOutputStream);//disardan gelen akisi workbook'a ekle


        //10)Dosyayi kapatalim
        //Stream'ler akisi canli tutar.oyuzden dosyalari kapatip boylece kodlarimizi rahatlatiriz.
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();














    }
}
