package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import pageObject.GooglePO;

public class GoogleFirstTest3 extends BaseTest{
	
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

}
