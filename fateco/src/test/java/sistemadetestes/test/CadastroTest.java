package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.CadastroPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroTest extends BaseTest {
	public static CadastroPO cadastroPage;

	@BeforeClass
	public static void prepararTestes() {
		cadastroPage = new CadastroPO(driver);


        driver.get(URL_BASE);
	}


	@Test
	public void TC010_0_DeveCadastrarProdutoNoSistemaComCodigoPreenchidoNomePreenchidoQuantidadePreenchidaValorPreenchidoEDataPreenchida() {
		cadastroPage.CaixaCadastro("002","Produto Teste 2", "5", "50.00", "2025/12/06");

		// Assuming no message means success, or check if modal closes
	}

	@Test
	public void TC010_1__DeveCadastrarProdutoNoSistemaComCodigoPreenchidoNomePreenchidoQuantidadePreenchidaValorPreenchidoEDataPreenchida() {
		assertTrue(cadastroPage.verificarProdutoCriado("002"));
	}

	@Test
	public void TC010_2_DeveCadastrarProdutoNoSistemaComCodigoPreenchidoNomePreenchidoQuantidadePreenchidaValorPreenchidoEDataPreenchida() {
		assertFalse(cadastroPage.verificarProdutoCriado("001"));
	}
	
	@Test
	public void TC011_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("","","","","");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

	@Test
	public void TC012_naoDeveCadastrarProdutoNoSistemaComCodigoVazioNomePreenchidoQuantidadePreenchidaValorPreenchidoEDataPreenchida() {
		cadastroPage.CaixaCadastro("","teste","teste","teste","teste");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

	@Test
	public void TC013_naoDeveCadastrarProdutoNoSistemaComCodigoPreenchidoNomeVazioQuantidadePreenchidaValorPreenchidoEDataPreenchida() {
		cadastroPage.CaixaCadastro("teste","","teste","teste","teste");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

	@Test
	public void TC014_naoDeveCadastrarProdutoNoSistemaComCodigoPreenchidoNomePreenchidoQuantidadeVaziaValorPreenchidoEDataPreenchida() {
		cadastroPage.CaixaCadastro("teste","teste","","teste","teste");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

	@Test
	public void TC015_naoDeveCadastrarProdutoNoSistemaComCodigoPreenchidoNomePreenchidoQuantidadePreenchidaValorVazioEDataPreenchida() {
		cadastroPage.CaixaCadastro("teste","teste","teste","","teste");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	@Test
	public void TC016_naoDeveCadastrarProdutoNoSistemaComCodigoPreenchidoNomePreenchidoQuantidadePreenchidaValorPreenchidoEDataVazia() {
		cadastroPage.CaixaCadastro("teste","teste","teste","teste","");

		String mensagem = cadastroPage.obterMensagemCadastro();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}


}
