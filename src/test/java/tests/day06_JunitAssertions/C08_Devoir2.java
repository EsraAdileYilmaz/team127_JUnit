package tests.day06_JunitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Devoir2 {


        /*
       Gerekli yapiyi olusturun ve asagidaki gorevi tamamlayin.
       1)Verilen web sayfasina gidin.https://the-internet.herokuapp.com/checkboxes
       2)checkbox1 ve checkbox2 elementlerini locate edin
       3)checkbox1 secili deilse onay kutusunu tiklayin
       4)checkbox1 ve checkbox2 'nin secili oldugunu test edin.
       */
        WebDriver driver;
        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @After
        public void teardown(){
            driver.quit();
        }

        @Test
        public void checkBoxTest(){

            //1)Verilen web sayfasina gidin.https://the-internet.herokuapp.com/checkboxes
            driver.get("https://the-internet.herokuapp.com/checkboxes");

            //2)checkbox1 ve checkbox2 elementlerini locate edin
            WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
            WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

            //3)checkbox1 secili deilse onay kutusunu tiklayin
            checkBox1.click();


            // 4)checkbox1 ve checkbox2 'nin secili oldugunu test edin.
            Assert.assertTrue(checkBox1.isSelected());
            Assert.assertTrue(checkBox2.isSelected());

            driver.quit();


        }
    }


