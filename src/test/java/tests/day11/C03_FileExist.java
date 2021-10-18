package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist extends TestBase {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));

        ///Users/selcuk/Desktop/wear sensors.png

        //Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin
        //dosya yolunu ikiye ayiracagiz
        //1. herkesin bilgisayarindan farkli olan kisim
        //bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz
        // 2. kisim herkes icin ayni olan kisim
        // bu kisim 1.madde deki yolun devami seklinde olur

        // ornek masaustumuzdeki picture dosyasi icin yol kaydedelim

        String pathFile=System.getProperty("user.home")+ "/Desktop/wear sensors.png";
        System.out.println("dosya yolumuz :"+pathFile);

        System.out.println(Files.exists(Paths.get(pathFile)));
        Assert.assertTrue(Files.exists(Paths.get(pathFile)));

        System.out.println(System.getProperty("user.dir")); // icinde oldugumuz dosyanin yolunu verir


    }

}
