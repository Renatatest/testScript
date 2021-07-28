package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Renata L. on 26/07/2021
 * @project testeScript
 */
public class LoginTest {
    @Test
    public void testLoginSistema(){
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        //instanciar o chrome para abrir o navegador
        WebDriver driver = new ChromeDriver();
        //getText leva mais que 1 segundo para aparecer
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://www.juliodelima.com.br/taskit/");
        driver.findElement(By.cssSelector(".right > li:nth-child(1) > a:nth-child(1)")).click();
        driver.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("testeLogin1");
        driver.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.linkText("SIGN IN")).click();

        //capturar o elemento do texto
        String saudacao = driver.findElement(By.className("me")).getText();

        //a classe assert compara 2 valores
        Assert.assertEquals("Hi, Teste", saudacao);

    }
}
