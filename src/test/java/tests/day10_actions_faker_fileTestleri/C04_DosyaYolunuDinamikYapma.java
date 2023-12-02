package tests.day10_actions_faker_fileTestleri;

import org.junit.Test;

public class C04_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        /*
            Java dosya yolunu dinamik hale getirebilmemiz icin
            bize iki temel konuma ulasmak icin hazir method sunmus

            1-  calistigimiz projenin dosya yoluna ulasmak isterseniz
                System.getProperty("user.dir")

            2- bilgisayarin ana dosya yoluna ulasmak isterseniz
               System.getProperty("user.home")

               Eger bir takim halinde calisiyorsak
               projemizdeki bir dosya
               veya downloads'a indirdigimiz bir dosyanin varligini test etmek istiyorsak
               dosya yolunu bu iki kodu kullanarak dinamik hale getirmeliyiz
         */

        System.out.println(System.getProperty("user.dir"));//   /Users/familleyilmaz/IdeaProjects/com.team127_Junit
        //calistigimiz projenin dosyayolunu verdi
        System.out.println(System.getProperty("user.home"));//  /Users/familleyilmaz



        {

        /*
            Java dosya yolunu dinamik hale getirebilmemiz icin
            bize iki temel konuma ulasmak icin hazir method sunmus

            1-  calistigimiz projenin dosya yoluna ulasmak isterseniz;
                System.getProperty("user.dir")

            2- bilgisayarin ana dosya yoluna ulasmak isterseniz;
               System.getProperty("user.home")

               Eger bir takim halinde calisiyorsak;
               1)projemizdeki bir dosyayi
               2)veya downloads'a indirdigimiz bir dosyanin varligini test etmek istiyorsak
               dosya yolunu bu iki kodu kullanarak dinamik hale getirmeliyiz.
         */

            System.out.println(System.getProperty("user.dir"));//   /Users/familleyilmaz/IdeaProjects/com.team127_Junit
            //calistigimiz projenin dosyayolunu verdi.
            //projemiz icindeki bir dosyanin varligini test etmek icin bu kod kullanilir.
            System.out.println(System.getProperty("user.home"));//  /Users/familleyilmaz
            //Bilgisayarin ana dosya yolunu verdi.Ana dosyanin halini verdi.
            //projemizin disinda ama bilgisayarin icindeki bir dosyayi test etmek istiyorsak bu kod kullanilir.

            /*
            ("user.dir")==>burasi herkeste farkli olabilir
             */




         // /Users/familleyilmaz/IdeaProjects/com.team127_Junit/src/test/java/tests/utilities/TestBase.java
         //buda TestBase class'inin dosya yolu

        }


    }
}
