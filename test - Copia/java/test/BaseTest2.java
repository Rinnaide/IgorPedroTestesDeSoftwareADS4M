package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest2 {
	protected static WebDriver driver;
	protected static final String URL_BASE = "file:///C:/Users/36129382024.1m/Documents/igor/Nova%20pasta/testes_aula_6a_28NOV25_selenium_1/fatec/sistema/produtos.html";
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
		driver.quit();
	}

}
