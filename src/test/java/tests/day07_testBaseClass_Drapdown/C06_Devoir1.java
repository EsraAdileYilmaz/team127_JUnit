package tests.day07_testBaseClass_Drapdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

import java.util.List;

public class C06_Devoir1 extends TestBase{


        /**
         1)https://the-internet.herokuapp.com/dropdown adresine gidin
         2)Index kullanarak secenek1'i (option 1) secin ve yazdirin
         3)Value kullanarak secenek2'yi (option 2) secin ve yazdirin
         4)Visible text(gorunen metin) kullanarak secenek1'i (option 1) secin ve yazdirin
         5)tum dropdown degerleri (values) yazdirin
         6)dropdown'un boyutunun 4 oldugunu test edin

         */

        @Test
        public void dropDownTest(){

            // 1)https://the-internet.herokuapp.com/dropdown adresine gidin
            driver.get("https://the-internet.herokuapp.com/dropdown");

            // 2)Index kullanarak secenek1'i (option 1) secin ve yazdirin
            WebElement dropdown1= driver.findElement(By.xpath("//select[@id='dropdown']"));
            Select select1=new Select(dropdown1);
            select1.selectByIndex(1);
            System.out.println(select1.getFirstSelectedOption().getText());

            //3)Value kullanarak secenek2'yi (option 2) secin ve yazdirin
            WebElement dropdown2= driver.findElement(By.xpath("//select[@id='dropdown']"));
            Select select2=new Select(dropdown2);
            select2.selectByValue("2");
            System.out.println(select2.getFirstSelectedOption().getText());

            //4)Visible text(gorunen metin) kullanarak secenek1'i (option 1) secin ve yazdirin
            WebElement dropdown3= driver.findElement(By.xpath("//select[@id='dropdown']"));
            Select select3=new Select(dropdown1);
            select3.selectByVisibleText("Option 1");
            System.out.println(select3.getFirstSelectedOption().getText());

            // 5)tum dropdown degerleri (values) yazdirin
            List<WebElement> optionsList=select1.getOptions();
            System.out.println(ReusableMethods.stringListeDonustur(optionsList));

            //6)dropdown'un boyutunun 4 oldugunu test edin.
            int dropdownBoyut= optionsList.size();
            Assert.assertTrue(dropdownBoyut == 4);

        }


    }


