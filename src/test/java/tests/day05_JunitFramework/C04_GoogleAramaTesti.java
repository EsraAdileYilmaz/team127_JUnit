package tests.day05_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C04_GoogleAramaTesti {

    public static void main(String[] args) {

        //1-Oncelikle setup yapalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()='Tout accepter']")).click();

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        // WebElement googleTitle= driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        String expectedTitle="Google";
        String actualTitle= driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("Nutella"+Keys.ENTER);


        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucTexti= driver.findElement(By.id("result-stats"));
        String sonucTextiStr=sonucTexti.getText();
        System.out.println("Bulunan sonuc yazisi: "+sonucTextiStr);

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //Environ 188 000 000 résultats (0,36 secondes)
        String [] sonucYazisiArr=sonucTextiStr.split(" ");

        String sonucSayisiStr=sonucYazisiArr[1];

        sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");//"188000000" arasindaki bosluklardan kurtulmak icin

        int sonucSayisiInt=Integer.parseInt(sonucSayisiStr);

        if(sonucSayisiInt > 10000000){
            System.out.println("Arama sonuc sayisi testi PASSED");
        }else{
            System.out.println("Arama sonuc sayisi FAILED");
        }


        //8-Sayfayi kapatin
        driver.quit();

    }
}
