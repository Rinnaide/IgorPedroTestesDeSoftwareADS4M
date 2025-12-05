package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{
	
	@FindBy(name = "q")
	public WebElement inputPesquisa;
	
	@FindBy(css = "#react-layout article")
	public WebElement divResultadoPesquisa;
	
	public GooglePO(WebDriver driver) {
		super(driver);
	}
	
	public void pesquisar(String texto) {
		inputPesquisa.sendKeys(texto + Keys.ENTER);
	}
	
	public String obterResultadoDaPesquisa() {
		return divResultadoPesquisa.getText();
	}

}
