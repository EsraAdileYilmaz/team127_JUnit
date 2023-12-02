package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExistsTesti extends TestBase {

    @Test
    public void dosyaIndirmeTesti(){

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        //bu dosyayi indirmek icin locate etmeli ve sonra click() yapmaliyim.
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        //oncelikle dosya yolunu manuel alip bir String variable'a atamaliyiz.
        //yeni dosya indirmek icin Desktop yerine Downloads eklemek gerekiyor
        //String dosyaYolu="/Users/familleyilmaz/Downloads/logo.png";
        String dosyaYolu="/Users/familleyilmaz/Downloads/logo.png";

        ReusableMethods.bekle(2);
        //bu kodla sunu demis oluyoruz.dosyaYolu'nu sana verdigim dosya bilgisayarda varmi?
        //bu kod sonucu boolean dondurur.Dosya varsa true,yoksa false dondurur
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//bizde true yada false verir
        Assert.assertTrue( Files.exists(Paths.get(dosyaYolu)));//buradda testimizi yapiyoruz.


        //5. spectrum-logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='spectrum-logo.png']")).click();


        //6. Dosyanın başarıyla indirilip indirilmediğini test edelim
        dosyaYolu="/Users/familleyilmaz/Downloads/spectrum-logo.png";
        ReusableMethods.bekle(2);
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//true
        Assert.assertTrue( Files.exists(Paths.get(dosyaYolu)));//burada testimizi yapiyoruz.




        //String dosyaYolu="C:\\Users\\HUAWEI\\Downloads\\logo.png"; windows larda boyle


    }
}
