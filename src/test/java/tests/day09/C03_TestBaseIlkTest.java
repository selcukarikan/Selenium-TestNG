package tests.day09;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {
   @Test
   public void test(){
      driver.get("https://amazon.com");
      System.out.println(driver.getTitle());


   }
}
