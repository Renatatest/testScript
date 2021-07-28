package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
/**
 * @author Renata L. on 26/07/2021
 * @project testeScript
 */
public class MagazineTest {
     //sem BDD
    
    @Test
    public void testPesquisaProduto(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

       driver.get("https://www.magazineluiza.com.br/");
       driver.findElement(By.id("inpHeaderSearch")).sendKeys("Wife, Just Let Go - Robert Briggs Associates");
       driver.findElement(By.id("btnHeaderSearch")).click();

       driver.findElement(By.className("product-li")).click();
       String status = driver.findElement(By.className("unavailable__product-title")).getText();
        Assert.assertEquals("Não disponível",status);
        driver.quit();

    }
}
