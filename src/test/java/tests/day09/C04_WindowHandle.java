package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {
    @Test
    public void test(){
        // ● Tests package’inda yeni bir class olusturun: C04_WindowHandle



        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actual=driver.findElement(By.tagName("h3")).getText();
        String expected="Opening a new window";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected,"yazi istenilen sekilde degil");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
       String actualTitle= driver.getTitle();
       String expectedTitle="The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"istenilen yazidan farkli title");

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here"));
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window("");
        String actualNeueTitle= driver.getTitle();
        String expectedNeueTitle="New Window";
        softAssert.assertEquals(actualNeueTitle,expectedNeueTitle,"yeni titel beklenenden farkli");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    }
}
