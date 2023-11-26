package tests.day07_testBaseClass_Drapdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class C07_Devoir2 extends TestBase {

    /*
      1)"https://www.amazon.com/" adresine gidin
      2)Test1=Arama kutusunun yanindaki kategori sayisinin 45 oldugunu test edin.
      3)Test2=-Kategori menusunden Books secenegini secin
              -Arama kutusuna "Java" yazin ve aratin
              -Bulunan sonuc sayisini yazdirin
              -Sonucun "Java" icerdigini test edin
     */

    @Test
    public void test01(){
        //1)"https://www.amazon.com/" adresine gidin
        driver.get("https://www.amazon.com/");

        //2)Test1=Arama kutusunun yanindaki kategori sayisinin 45 oldugunu test edin
        WebElement searchBox= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select1=new Select(searchBox);
        List<WebElement> optionsListi =select1.getOptions();//tum opsiyonlari alip listeledik

        int expectedKategoriSayisi=45;
        int actualKategoriSayisi= optionsListi.size();
        Assert.assertEquals(expectedKategoriSayisi,actualKategoriSayisi);

    }

    @Test
    public void test02(){

        //1)"https://www.amazon.com/" adresine gidin
        driver.get("https://www.amazon.com/");

        //-Kategori menusunden Books secenegini secin
        WebElement searchBox= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selectBooks=new Select(searchBox);
        selectBooks.selectByVisibleText("Books");//dropdown menudeki books'u sectik

        //-Arama kutusuna "Java" yazin ve aratin
        WebElement searchBox1= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox1.sendKeys("Java"+ Keys.ENTER);

        //-Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        /*
          String [] sonucYaziArr= sonucYaziElementi.getText().split(" ");
          System.out.println(Arrays.toString(sonucYaziArr));
          String sonucYaziStr=sonucYaziArr[3].replaceAll("\\D","");//burada bulunansayiyi string olarak aldik
          int sonucSayi=Integer.parseInt(sonucYaziStr); */
        System.out.println(sonucYaziElementi.getText());//1-16 of over 30,000 results for "Java"

        // -Sonucun "Java" icerdigini test edin
        String [] sonucYaziArr= sonucYaziElementi.getText().split(" ");
        String expectedsonucYaziStr=sonucYaziArr[6].replaceAll("\\W","");//
        String actualSonucYazi=sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazi.contains(expectedsonucYaziStr));


       //


    }



}
