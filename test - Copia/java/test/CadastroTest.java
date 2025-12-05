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
	public void TC010_deveVerificarSeUsuarioCriouUmProduto() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

		cadastroPage.CaixaCadastro("001", "Produto Teste", "10", "100.00", "2025/12/05");

		assertTrue(cadastroPage.verificarProdutoCriado("001"));
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

