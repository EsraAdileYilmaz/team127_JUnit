package tests.day11_waits_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C05_Devoir_WebTables extends TestBase {

    @Test
    public void webTablesTesti(){

       //1) "https://demoqa.com/webtables" sayfasina gidin
       //2) Headers da bulunan basliklari yazdirin
       //3) 3.sutunun basligini yazdirin
       //4) Tablodaki tum datalari yazdirin
       //5)Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
       //6)Tablodaki satir sayisini yazdirin
       //7) Tablodaki sutun sayisini yazdirin
       //8) Tablodaki 3. kolonu yazdirin
       //9) Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
       //10)Page sayfasinda bir method olusturun,Test sayfasindan satir ve
       //   sutun sayisini girdigimde bana datayi yazdirsin.


        //1) "https://demoqa.com/webtables" sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2) Headers da bulunan basliklari yazdirin
        List <WebElement> baslikElementleri=driver.findElements(By.xpath("//div[@role='columnheader']"));
        List <String> baslikElementleriStr= ReusableMethods.stringListeDonustur(baslikElementleri);
        System.out.println(baslikElementleriStr);//[First Name, Last Name, Age, Email, Salary, Department, Action]

        //3) 3.sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[text()='Age']")).getText());

        //4) Tablodaki tum datalari yazdirin
        List<WebElement> tablodakiDataElementleri=driver.findElements(By.xpath("//*[@role='row']/*[@role='gridcell']"));
        List<String>  tablodakiDataElementleriStr=ReusableMethods.stringListeDonustur(tablodakiDataElementleri);
        System.out.println(tablodakiDataElementleriStr);

        //5)Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println(tablodakiDataElementleriStr.size());//70 toplam data sayisi


        //6)Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisiElementi= driver.findElements(By.xpath("//*[@role='row']"));
        System.out.println(satirSayisiElementi.size());//11


        //7) Tablodaki sutun sayisini yazdirin
        //sutun sayisi baslik elementlerinin size'i kadardir.
        System.out.println(baslikElementleriStr.size());//7


        //8) Tablodaki 3. kolonu yazdirin
        List<WebElement> ucuncuKolonElementleri=driver.findElements(By.xpath("//*[@role='row']/*[@role='gridcell'][3]"));
        List<String> ucuncuKolonElementleriStr=ReusableMethods.stringListeDonustur(ucuncuKolonElementleri);
        System.out.println(ucuncuKolonElementleriStr);//[39, 45, 29,  ,  ,  ,  ,  ,  ,  ]

        //9) Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        WebElement kierraSalaryElementi= driver.findElement(By.xpath("((//*[@role='row'])[4]/*[@role='gridcell'])[5]"));
        System.out.println(kierraSalaryElementi.getText());//2000

        //10)Page sayfasinda bir method olusturun,Test sayfasindan satir ve
        //   sutun sayisini girdigimde bana datayi yazdirsin.
        istenenHucredekiDatayiYazdir(2,4);//Istenen hucredeki data : cierra@example.com
        istenenHucredekiDatayiYazdir(3,5);//Istenen hucredeki data : 12000





    }

    public void istenenHucredekiDatayiYazdir(int satirNo,int sutunNo){

        // ornek= ((//*[@role='row'])[4]/*[@role='gridcell'])[5]


        String dinamikXpath = "((//*[@role='row'])[" + satirNo + "]/*[@role='gridcell'])[" + sutunNo + "]";
        System.out.println("Istenen hucredeki data : " +
                driver.findElement(By.xpath(dinamikXpath)).getText());
    }
}
