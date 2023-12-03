package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_ProjeIcindekiDosyaTesti {


    @Test
    public void fileExistsTesti(){

        // projemiz icerisinde day10 package'i altinda
        // deneme.txt dosyasinin oldugunu test edin

        String dosyaYolu="/Users/familleyilmaz/IdeaProjects/com.team127_Junit/src/test/java/tests/day10_actions_faker_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));// bu sekilde testimizi yapiyoruz.
        //dosya yolunun icindeki dosyanin var oldugunu iddia ediyorum


        /*

        "/Users/familleyilmaz/IdeaProjects/com.team127_Junit/src/test/java/tests/day10_actions_faker_fileTestleri/deneme.txt";

        ** Herkeste farkli olan kisim ==> user.dir
                 /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/com.team127_JUnit
        ** Herkeste ayni olan kisim ==> projenin icindeki dosya yolu
               /src/test/java/tests/day10_actions_faker_fileTestleri/deneme.txt";

         */


        String dinamikDosyaYolu=System.getProperty("user.dir") +"/src/test/java/tests/day10_actions_faker_fileTestleri/deneme.txt";
        //bu sekilde verilen bir dosya yolu ile projede calisan herkeste bu kod gecerli olur.yani bu kod herkeste calisir

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));// bu sekilde testimizi yapiyoruz.
        //projede calisan herkes bu yolla testini yapabilir.









    }
}
