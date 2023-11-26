package tests.day05_JunitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C08_Devoir extends TestBase {

    /*
      1. “https://www.saucedemo.com” Adresine gidin
      2. Username kutusuna “standard_user” yazdirin
      3. Password kutusuna “secret_sauce” yazdirin
      4. Login tusuna basin
      5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
      6. Add to Cart butonuna basin
      7. Alisveris sepetine tiklayin
      8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
      9. Sayfayi kapatin
     */

    @Test
    public void test01(){
        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameBox= driver.findElement(By.id("user-name"));
        usernameBox.sendKeys("standard_user"+ Keys.ENTER);

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce"+Keys.ENTER);

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkurun= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String ilkUrunIsim= ilkurun.getText();
        ilkurun.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement quantityBox= driver.findElement(By.xpath("//div[@class='cart_quantity']"));
       /* 1.cozum yolu:
       String quantityStr= quantityBox.getText();//"1"
       int quantity=Integer.parseInt(quantityStr);//1

        Assert.assertTrue(quantity >0); */
        Assert.assertTrue(quantityBox.isDisplayed());


    }
}
