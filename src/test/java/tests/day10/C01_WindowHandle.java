package tests.day10;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;


public class C01_WindowHandle extends TestBase {
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


            System.out.println("ilk sayfanin handle degeri : "+driver.getWindowHandle());
            //1-window handle ederken ilk adim 1 sayfa acik iken o sayfanin handle degerini alip bir Stringe atamak

            String ilkSayfaHandle=driver.getWindowHandle();
            //● Click Here butonuna basın.
            //bu satirda 2.window acildi
            driver.findElement(By.linkText("Click Here"));
            //2- adim iki sayfa acildiginda her iki saayfanin handle degerlerini koymak icin bir set olusturup
            // getwindowhandle  methodu ile degerleri elde etmek
             Set<String> tumWindowHandleri= driver.getWindowHandles();
            System.out.println("tum handler :"+tumWindowHandleri);

            //3. set icerisinde 1 sayfanin handle degerine esit olmayan ,
            // handle degerini bulup bir string degiskene atamak
            String ikinciWindowHandle="";
            for (String each:tumWindowHandleri
                 ) {
                if (!each.equals(ilkSayfaHandle)){
                    ikinciWindowHandle=each;
                }
            }

            //bu satira geldigimizde elimizde 2. sayfanin handle degeri var olacak
            System.out.println("ikinci sayfa handle degeri : " + ikinciWindowHandle);
            //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            driver.switchTo().window(ikinciWindowHandle);
            //switch to ile window degistireceksek gidecegimiz windowun handle degerine ihtiyacimiz var...
            String actualNeueTitle= driver.getTitle();
            String expectedNeueTitle="New Window";
            softAssert.assertEquals(actualNeueTitle,expectedNeueTitle,"yeni titel beklenenden farkli");
            softAssert.assertAll();
            //● Sayfadaki textin “New Window” olduğunu doğrulayın.
            WebElement yeniSayfa= driver.findElement(By.tagName("h3"));
            String expectedNeue="New Window";
            String actualNeue= yeniSayfa.getText();
            softAssert.assertEquals(actualNeue,expectedNeue,"istenilen sayfadaki yazi farkli");
            //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
            driver.switchTo().window(ilkSayfaHandle);
        }
    }


