package tests.day06_JunitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertions {

   @Test
    public void test01(){

       /*
       Assert class'indan 4 method kullanilir:
       1)Assert.assertTrue(sart yazilir)==> dogru oldugunu iddia ediyorum
       2)Assert.assertFalse(sart yazilir)==> yanlis oldugunu iddia ediyorum
       3)Assert.assertEquals(sart yazilir)==> esit oldugunu iddia ediyorum
       4)Assert.assertNotEquals(sart yazilir)==> esit olmadigini iddia ediyorum

       iddia edilen ile sart uyusuyorsa test PASSED
       iddia edilen ile sart uyusmuyorsa test FAILED olur.
        */

       // Emeklilik yasi 65 olsun
       // 70 yasindaki bir kisinin emekli olabildigini test edin.

       int yas=70;
       Assert.assertTrue(yas >65);//test passed
       //assertTrue(sart=True) oldugu icin test passed



       int sayi1=20;
       int sayi2=30;
       //Assert.assertTrue(sayi1 > sayi2);//failed olur
       //dogru oldugunu iddia ediyorum(20 >30).
       //parantez ici false ama bizim iddiamiz true oldugu icin test failed olur
       //assertTrue(sart=false ) oldugu icin failed

       Assert.assertFalse(sayi1>sayi2); // PASSED cunku iddiamiz false(sart false)

       System.out.println("assertion failed olursa bu satir calismaz");

       String actualUrl = "https://testotomasyonu.com/";

       //  Url'in "testotomasyonu" icerdigini test edin

       Assert.assertTrue(actualUrl.contains("testotomasyonu")); // PASSED cunku url testotomasyonu kelimesini icerir

       // Url'in wisequarter icermedigini test edin

       Assert.assertFalse(actualUrl.contains("wisequarter"));  // PASSED cunku url wisequarter kelimesini icermez

       // Url'in https://testotomasyonu.com/ oldugunu test edin

       Assert.assertEquals("https://testotomasyonu.com/",actualUrl); // PASSED

       Assert.assertTrue("https://testotomasyonu.com/".equals(actualUrl)); // PASSED
       //'assertTrue()' can be simplified to 'assertEquals()'

       // Url'in https://www.testotomasyonu.com/ olmadigini test edin
       //String actualUrl = "https://testotomasyonu.com/"; basinda www. kismi yok

       Assert.assertNotEquals("https://www.testotomasyonu.com/",actualUrl);// PASSED

       Assert.assertFalse("https://www.testotomasyonu.com/".equals(actualUrl));//PASSED


   }

}
