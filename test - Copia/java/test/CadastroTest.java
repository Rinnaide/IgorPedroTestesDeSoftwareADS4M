package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import pageObject.CadastroPO;
import pageObject.LoginPO;

public class CadastroTest extends BaseTest {
	public static CadastroPO cadastroPage;
	public static LoginPO loginPage;

	@BeforeClass
	public static void prepararTestes() {
		cadastroPage = new CadastroPO(driver);
		loginPage = new LoginPO(driver);
	}


	
	@Test
	public void TC010_deveVerificarCadastroDisponivelAposLogin() {
		loginPage.executarAcaoDeLogar("teste", "teste");

		assertTrue(cadastroPage.buttonCadastro.isDisplayed());
	}

	
	@Test
	public void TC011_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("", "","","","");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

		
	@Test
	public void TC012_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("", "teste","teste","teste","teste");
		
		String mensagem = cadastroPage.obterMensagemCadastro();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC013_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("teste", "","teste","teste","teste");
		
		String mensagem = cadastroPage.obterMensagemCadastro();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC014_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("teste", "teste","","teste","teste");
		
		String mensagem = cadastroPage.obterMensagemCadastro();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC015_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("teste", "teste","teste","","teste");
		
		String mensagem = cadastroPage.obterMensagemCadastro();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	@Test
	public void TC016_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("teste", "teste","teste","teste","");
		
		String mensagem = cadastroPage.obterMensagemCadastro();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

}

