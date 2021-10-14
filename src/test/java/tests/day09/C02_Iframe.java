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
    public void iframeTest(){

        WebElement baslikYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikYaziElementi.isEnabled(),"baslik yazisi erisebilir degil");
        //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
        System.out.println(baslikYaziElementi.getText());

        driver.switchTo().frame("mce_0_ifr");
        WebElement schreibText= driver.findElement(By.xpath("//*[@id='tinymce']"));
        //		○ Text Box’a “Merhaba Dunya!” yazin.
        schreibText.clear();
        schreibText.sendKeys("Hello Welt");
    }
    @AfterClass
    public void tearDown(){
    driver.close();
    }
}
