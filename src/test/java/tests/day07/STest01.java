package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class STest01 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/");
        //1. http://zero.webappsecurity.com/ Adresine gidin
        WebElement signin= driver.findElement(By.xpath("//button[@id='signin_button']"));
        signin.click();
        //2. Sign in butonuna basin
        WebElement userName= driver.findElement(By.xpath("//input[@id='user_login']"));
        userName.sendKeys("username");
        //3. Login kutusuna “username” yazin
        WebElement userPass= driver.findElement(By.xpath("//input[@id='user_password']"));
        userPass.sendKeys("password");
        //4. Password kutusuna “password.” yazin
        WebElement sign= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        sign.click();
        //5. Sign in tusuna basin
        Thread.sleep(2990);
        WebElement payBills= driver.findElement(By.linkText("Pay Bills"));
        payBills.click();
        //6. Pay Bills sayfasina gidin
        WebElement PurchaseForeignCurrency= driver.findElement(By.linkText("Purchase Foreign Currency"));
        PurchaseForeignCurrency.click();
        //7. “Purchase Foreign Currency” tusuna basin
WebElement currency=driver.findElement(By.xpath("//select[@id='pc_currency']"));

        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. “amount” kutusuna bir sayi girin
        //10. “US Dollars” in secilmedigini test edin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol
        //edin.

    }
}
