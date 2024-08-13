package tests.day07_testBaseClass_Drapdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

public class C04_DropdownMenu extends TestBase {

    @Test
    public void dropdownTesti(){

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna “username” yazin
        WebElement loginBox= driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        //4. Password kutusuna “password” yazin
        WebElement passwordBox= driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        WebElement signinBox= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        signinBox.click();
        driver.navigate().back();

        //6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” dropdown menusunden Eurozone’u secin
        WebElement currencyElementi= driver.findElement(By.id("pc_currency"));
        Select selectCurrency=new Select(currencyElementi);
        selectCurrency.selectByValue("EUR");//<option value="EUR">Eurozone (euro)</option>

        //9. “amount” kutusuna bir sayi girin
        WebElement amountBox= driver.findElement(By.id("pc_amount"));
        amountBox.sendKeys("400");

        //10. currency olarak “US Dollars” in secilmedigini test edin
        String unexpectedValue="US Dollars";
        String actualValue=selectCurrency.getFirstSelectedOption().getText();//selectCurrency.selectByValue("EUR"); biz bunu sectik

        Assert.assertNotEquals(unexpectedValue,actualValue);

        //Radio button olarak U.S. Dollars'in secilmedigini test edin.
        WebElement usdollarRadioElementi=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usdollarRadioElementi.isSelected());

        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();


        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement aciklamaElementi=driver.findElement(By.id("alert_content"));

        String expectedAciklama="Foreign currency cash was successfully purchased.";
        String actualAciklama=aciklamaElementi.getText();

        Assert.assertEquals(expectedAciklama,actualAciklama);
    }

}
