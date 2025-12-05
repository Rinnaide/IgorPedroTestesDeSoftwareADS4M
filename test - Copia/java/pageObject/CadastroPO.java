package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroPO extends BasePO {

	public CadastroPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement inputData;
	
	@FindBy(id = "mensagem")
	public WebElement spanMensagemCadastro;
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonCadastro;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	public String obterMensagemCadastro() {
		return this.spanMensagemCadastro.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public void CaixaCadastro(String codigo, String nome, String quantidade, String valor, String data) {
		buttonCadastro.click();
		buttonCadastro.click();
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);

		buttonSalvar.click();
		
	}
}
