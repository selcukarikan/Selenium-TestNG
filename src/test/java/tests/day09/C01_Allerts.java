package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class C01_Allerts {

    //Bir class olusturun: C01_Alerts




    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
   @Test
   //● Bir metod olusturun: acceptAlert
   public void accepAllert(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
       //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
       WebElement resultYazisi=driver.findElement(By.xpath("//p[@id='result']"));
       //“You successfully clicked an alert” oldugunu test edin.

       String expectedResult="You successfully clicked an alert";
       String actualResult=resultYazisi.getText();
     assertEquals(actualResult,expectedResult,"sonuc yazisi istenen ile ayni degil");

   }

   @Test
   //● Bir metod olusturun: dismissAlert
   public void dismissAlert(){
       //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
       driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
       //“successfuly” icermedigini test edin.
    driver.switchTo().alert().dismiss();
    String istenmeyenKelime="successfuly";
    WebElement resultYazisi=driver.findElement(By.xpath("//p[@id='result']"));

    String actualResult=resultYazisi.getText();
    assertFalse(actualResult.contains(istenmeyenKelime),"result yazisi istenmeyen kelimeyi icerir");


   }


   @Test
   //● Bir metod olusturun: sendKeysAlert
   public void sendKeysAllert() throws InterruptedException {

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1345);
        String isim="selcuk";
        driver.switchTo().alert().sendKeys(isim);
        driver.switchTo().alert().accept();

       //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
       //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
       WebElement resultYazisi= driver.findElement(By.id("result"));
       String actualResult=resultYazisi.getText();

       SoftAssert softAssert=new SoftAssert();
       softAssert.assertTrue(actualResult.contains(isim));
       softAssert.assertAll();

   }

@AfterClass
    public void tearDown(){
       // driver.close();
}
}
