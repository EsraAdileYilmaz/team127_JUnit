package tests.day05_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebappTesti {

    public static void main(String[] args) {

        //Setup yapalim
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3. Login alanina  “username” yazdirin
        WebElement loginBox=driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        //4. Password alanina “password” yazdirin
        WebElement passwordBox=driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@*='btn btn-primary']")).click();
        // driver.findElement(By.xpath("//*[@*='Sign in']")).click(); 2.locate yolu

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();//Online Banking menusune gidildi
        driver.findElement(By.id("pay_bills_link")).click();//Pay Bills e gidildi

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountBox=driver.findElement(By.id("sp_amount"));
        amountBox.sendKeys("1000");

        //9. tarih kismina “2023-09-10” yazdirin
        WebElement dateBox=driver.findElement(By.id("sp_date"));
        dateBox.sendKeys("2023-09-10");
        //driver.findElement(By.id("sp_date")).sendKeys("2023-09-10"); 2.Yol

        //10. Pay buttonuna tiklayin
        WebElement payButton=driver.findElement(By.id("pay_saved_payees"));
        payButton.click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement mesajElementi= driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        //WebElement mesajElementi = driver.findElement(By.id("alert_content")); 2.yol

        String expectedResult="The payment was successfully submitted.";
        String actualResult=mesajElementi.getText();//elementin icerdigi texti getirecek

        if(expectedResult .equals(actualResult)){
            System.out.println("Payment test PASSED");
        }else{
            System.out.println("Payment test FAILED");
        }


        driver.quit();
    }
}
