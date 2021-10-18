package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

//Bir Class olusturalim C02_KeyboardActions2
public class C02_KeyBoardsActions2 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        Thread.sleep(3000);

        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe= driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iframe);

     WebElement playTusu= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
       actions.click(playTusu).perform();
        Thread.sleep(3000);
        //5- videoyu calistirdiginizi test edin
        Assert.assertFalse(playTusu.isDisplayed());

    }







}
