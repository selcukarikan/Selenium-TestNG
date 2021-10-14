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

//    ● Bir class olusturun: C02_IframeTest
public class C02_Iframe {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //    ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");


        //		○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //		dogrulayin ve  konsolda yazdirin.

    }
    //    ● Bir metod olusturun: iframeTest
    @Test
    public void iframeTest()  {

        WebElement baslikYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikYaziElementi.isEnabled(),"baslik yazisi erisebilir degil");
        //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
        System.out.println(baslikYaziElementi.getText());
        //		○ Text Box’a “Hello Welt!!” yazin.
        WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        // driver.switchTo().frame(0); index numarasi ile de yazilabilir
        WebElement schreibText= driver.findElement(By.xpath("//*[@id='tinymce']"));

        schreibText.clear();
        schreibText.sendKeys("Hello Welt!");

        //bir iframe e gecis yaptiktan sonra yeniden anasayfa ile ilgili islem yapmak istersek
        //gecis yaptigimiz Iframe e geri donmeliyiz

        driver.switchTo().defaultContent();

        //	TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //	dogrulayin ve  konsolda yazdirin.
        WebElement elemantalLink= driver.findElement(By.linkText("Elemantal Selenium"));
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(elemantalLink.isDisplayed());
        softAssert.assertAll();
        System.out.println(elemantalLink.getText());

    }
    @AfterClass
    public void tearDown(){
    driver.close();
    }
}
