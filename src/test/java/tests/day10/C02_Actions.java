package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {



   @Test
   public void test(){
       //amazon anasayfaya gidin
       driver.get("https://www.amazon.com");
       //nutella icin arama yapin
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella");
       driver.findElement(By.id("nav-search-submit-button")).click();
       //9. urunu tiklayin
       driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[9]")).click();
   }

}
