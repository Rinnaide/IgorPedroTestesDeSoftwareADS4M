package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import pageObject.CadastroPO;

public class CadastroTest extends BaseTest2 {
	public static CadastroPO cadastroPage;

	@BeforeClass
	public static void prepararTestes() {
		cadastroPage = new CadastroPO(driver);
	}

	@Test
	public void TC011_naoDeveCadastrarProdutoNoSistemaComCodigoNomeQuantidadeValorEDataVazios() {
		cadastroPage.CaixaCadastro("", "","","","");
		
		String mensagem = cadastroPage.obterMensagemCadastro();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
}

