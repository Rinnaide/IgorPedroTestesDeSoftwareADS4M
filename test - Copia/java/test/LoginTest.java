package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pageObject.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
	
	public static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	
	@Test
	public void TC001_NaoDeveLogarNoSistemaComEmailESenhaVazios() {
		loginPage.executarAcaoDeLogar("", "");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC004_NaoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
		loginPage.executarAcaoDeLogar("", "teste");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC009_DeveLogarNoSistemaComEmailESenhaCorretos() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
		
		assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
	}
	
	

}
