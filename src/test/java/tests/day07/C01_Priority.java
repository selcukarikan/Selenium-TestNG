package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class C01_Priority {
    // 3 test methodu olusturun
    // 1 amazin sayfasina gidiniz
    //2  techproed sayfasina gidiniz
    //3 facebook sayfasina gidiniz
    //ve sayfa title larini yazidiriniz
   WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();


    }

}
