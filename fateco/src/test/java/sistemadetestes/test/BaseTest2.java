package sistemadetestes.test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest2 {
	protected static WebDriver driver;
	protected static final String URL_BASE = "file:///C:/Users/biblioteca.sl/Downloads/IgorPedroTestesDeSoftwareADS4M/fatec/sistema/login.html";
	protected static final String PATH_DRIVE = "src/test/resources/chromedriver1420744459.exe";

    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(URL_BASE);
    }


	@AfterClass
	public static void finalizar() {
		// driver.quit();
	}

}
