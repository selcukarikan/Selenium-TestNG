package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TestBase {
    //abstract yaparak bu classdan obje olusturulmasinin onune geceriz
    protected WebDriver driver;
    //biz testbase class i sadece extends ile inherit ederek kullanacagiz
    //dolayisiyla olusturdugumuz driver variable icin protected acces modifier i seciyoruz

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){

      //  driver.close();
    }}
