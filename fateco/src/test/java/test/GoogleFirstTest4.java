package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import pageObject.GooglePO;

public class GoogleFirstTest4 extends BaseTest{
	
	private static GooglePO googlePage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://www.duckduckgo.com");
		googlePage = new GooglePO(driver);
	}

	@Test
	public void pesquisarNoGoogle() {
		
//		WebElement inputPesquisa = driver.findElement(By.name("q"));
//		inputPesquisa.sendKeys("receita de bolo de cenoura" + Keys.ENTER);
		
		googlePage.inputPesquisa.sendKeys("receita de bolo de cenoura" + Keys.ENTER);
		
//		String resultado = driver.findElement(By.cssSelector("#react-layout article")).getText();
		String resultado = googlePage.divResultadoPesquisa.getText();
		
		System.out.println("Texto encontrado: " + resultado);
		
		assertTrue(resultado.contains("cenoura"));
	}
	
	@Test
	public void pesquisarNoGoogle2() {
		
//		googlePage.inputPesquisa.sendKeys("receita de bolo de cenoura" + Keys.ENTER);
		googlePage.pesquisar("receita de bolo de cenoura");
		
//		String resultado = googlePage.divResultadoPesquisa.getText();
		String resultado = googlePage.obterResultadoDaPesquisa();
		
		System.out.println("Texto encontrado: " + resultado);
		
		assertTrue(resultado.contains("cenoura"));
	}

}
