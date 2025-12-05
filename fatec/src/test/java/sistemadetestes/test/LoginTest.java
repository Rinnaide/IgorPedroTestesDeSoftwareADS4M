package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import sistemadetestes.pageObject.LoginPO;

public class LoginTest extends BaseTest {

    private LoginPO loginPage;

    @Before
    public void setUp() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
        loginPage.executarAcaoDeLogar("emailincorreto@teste.com", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailCorretoESenhaVazia() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("", "senhaincorreta");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailVazioESenhaCorreta() {
        loginPage.executarAcaoDeLogar("", "admin@123");
        String mensagem = loginPage.obterMensagem();
        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta() {
        loginPage.executarAcaoDeLogar("emailincorreto@teste.com", "admin@123");
        String mensagem = loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    @Test
    public void TC007_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "senhaincorreta");
        String mensagem = loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    @Test
    public void TC008_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta() {
        loginPage.executarAcaoDeLogar("emailincorreto@teste.com", "senhaincorreta");
        String mensagem = loginPage.obterMensagem();
        assertEquals("E-mail ou senha inválidos", mensagem);
    }

    @Test
    public void TC009_DeveLogarNoSistemaComEmailCorretoESenhaCorreta() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        String titulo = loginPage.obterTituloDaPagina();
        assertEquals("Controle de Produtos", titulo);
    }
}
