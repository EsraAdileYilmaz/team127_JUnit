package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_BilgisayardakiDosyayiTestEtme {

    @Test
    public void test01(){

        // Downloads'da logo.png oldugunu test edin
        String dosyaYolu="/Users/familleyilmaz/Downloads/logo.png";//bu kod dinamik deildir
        //dosya yolunu==> "Lire les informations" kismina basilinca cikan ekrandaki Emplacement kismindan aliyoruz
        ///Users/familleyilmaz/Desktop/logo.png bu sekilde bi dosya yolu elde ediyoruz,
        // bunun Desktop yazan kismini silip yerine Downloads yaziyoruz.

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



        /*
           ** Herkeste farkli olan ==> user.home
                              /Users/ahmetbulutluoz      veya
                              /Users/familleyilmaz
           ** Herkeste ayni olan
                       /Downloads/logo.png
         */


        String dinamikDosyaYolu= System.getProperty("user.home") +"/Downloads/logo.png";
        //dinamik dosya yoludur ve herkeste calisir

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
