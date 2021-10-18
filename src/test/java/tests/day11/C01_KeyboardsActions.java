package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardsActions extends TestBase {
    //Bir Class olusturalim C01_KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        // todo 3- Arama kutusuna actions method’larini kullanarak JBL  Kopfhörer yazdirin ve Enter’a basarak arama yaptirin
        Actions actions=new Actions(driver);
        //  todo searchBox.click(); alternatif klikleme
        actions.click(searchBox).perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("jbl ").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("K").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("opfhörer").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys(Keys.ENTER).perform();
        // searchBox.sendKeys("jbl Kopfhörer");
        //4 todo aramanin gerceklestigini test edin

//yukaridakinini alternatifi
       // actions.click(searchBox).keyUp(Keys.SHIFT).sendKeys("jbl ").keyUp(Keys.SHIFT).perform().sendKeys("K").perform().keyUp(Keys.SHIFT).perform().sendKeys("opfhörer").keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).perform();
        String arananKelime="jbl Kopfhörer";
        String actuaalTitle=driver.getTitle();
        Assert.assertTrue(actuaalTitle.contains(arananKelime),"arama yapilamadi");

    }




}
