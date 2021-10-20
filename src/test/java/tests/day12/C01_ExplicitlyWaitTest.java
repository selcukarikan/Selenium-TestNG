package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWaitTest extends TestBase {





    @Test
    public void implicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        SoftAssert softAssert=new SoftAssert();
        WebElement itsGone= driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(itsGone.isDisplayed(),"It's gone! yazisi gorulmedi");
        softAssert.assertAll();
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //7. It's back mesajinin gorundugunu test edin
     WebElement itsBack= driver.findElement(By.xpath("//p[@id='message']"));
     softAssert.assertTrue(itsBack.isDisplayed());

    }
    @Test
    public void explicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. "It's gone!" mesajinin goruntulendigini dogrulayin.

        //6. Add buttonuna basin

        //7. It's back mesajinin gorundugunu test edin

    }
}
