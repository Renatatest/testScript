package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginORM {

	WebDriver driver = null;
	
	@Given("que o usuario acessa a pagina de login")
	public void que_o_usuario_acessa_a_pagina_de_login() {
	
		String projectPath =
			System.getProperty("user.dir"); System.out.println("Project path is:"+
			projectPath); 
			System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver(); 
				driver.manage().timeouts().implicitlyWait(30,
				TimeUnit.SECONDS); driver.manage().timeouts().pageLoadTimeout(40,
				TimeUnit.SECONDS);
		
				driver.navigate().to("http://zero.webappsecurity.com/login.html");
				driver.manage().window().maximize();
	}

	@When("o usuario informa o \"(.*)\" e \"(.*)\"$")
	public void o_usuario_informa_o_login_e_senha(String login, String senha) {
		driver.findElement(By.id("user_login")).sendKeys(login);
		driver.findElement(By.id("user_password")).sendKeys(senha);	
	}

	@And("seleciona o botao login")
	public void seleciona_o_botao_login() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("o sistema autentica o usuario")
	public void o_sistema_autentica_o_usuario() {
			
		driver.findElement(By.cssSelector("#details-button")).click();
		driver.findElement(By.linkText("Ir para zero.webappsecurity.com (não seguro)")).click();
		
		  String atual = driver.findElement(By.linkText("username")).getText();
		  String esperado = "username";
		  Assert.assertEquals(esperado,atual);
		  System.err.println("Nome do usuário logado na sessão: " + esperado);
	}

	@And("navega para a pagina inicial")
	public void navega_para_a_pagina_inicial() {
	  System.out.println("Pagina inicial: " + driver.getCurrentUrl());
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	driver.close();
	}
	


}
