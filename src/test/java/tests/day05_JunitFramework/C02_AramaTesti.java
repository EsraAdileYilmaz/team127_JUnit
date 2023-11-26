package tests.day05_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {

    public static void main(String[] args) {

        /*
        1- testotomasyonu.com anasayfasina gidelim
        2- arama kutusunu locate edelim
        3- “phone” ile arama yapalim
        4- Bulunan sonuc sayisini yazdiralim
        5- Ilk urunu tiklayalim
        6- Urunun stokta var oldugunu test edin
         */

        //Oncelikle setup yapalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- testotomasyonu.com anasayfasina gidelim
        driver.get("https://www.testotomasyonu.com");


        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.xpath("(//input[@id='global-search'])[1]"));

        //3- “phone” ile arama yapalim
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisiElementi= driver.findElement(By.className("product-count-text"));
        System.out.println(sonucSayisiElementi.getText());//4 Products Found
        String sonucSayisiStr=sonucSayisiElementi.getText().replaceAll("\\D","");//"4"
        int sonucSayisi=Integer.parseInt(sonucSayisiStr);//4


        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]")).click();

        //6- Urunun stokta var oldugunu test edin
        WebElement urunStokElementi=driver.findElement(By.xpath("(//span[@class='heading-xs '])[1]"));
        System.out.println(urunStokElementi.getText());//Availibility: In Stock
        String expectedStokDurumu="Availibility: In Stock";
        String actualStokDurumu=urunStokElementi.getText();

        if(actualStokDurumu.equals(expectedStokDurumu)){
            System.out.println("Urun Stok Testi PASSED");
        }else{
            System.out.println("Urun Stok Testi FAILED");
        }


        driver.quit();


    }
}
