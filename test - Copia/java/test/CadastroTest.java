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
	public void TC011_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("", "","","","");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

	@Test
	public void TC012_deveVerificarCadastroDisponivelAposLogin() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

		assertTrue(cadastroPage.buttonCadastro.isDisplayed());
	}

}
