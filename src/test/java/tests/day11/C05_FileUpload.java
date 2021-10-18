package tests.day11;

import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    //Tests packagenin altina bir class oluşturun : C05_UploadFile

    //https://the-internet.herokuapp.com/upload adresine gidelim
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim

        //Yuklemek istediginiz dosyayi secelim.
        String pathFile = System.getProperty("user.home") + "/Desktop/wear sensors.png";

        WebElement fileUpload = driver.findElement(By.id("file-upload"));


        fileUpload.sendKeys(pathFile);
        //Upload butonuna basalim.
driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Thread.sleep(5432);
        WebElement ergebniss= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(ergebniss.isDisplayed());

    }
}