package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ExercicioTeste {
	
	public AndroidDriver<MobileElement> driver;
	
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage(); 
	
	@Before
	public void inicializarAppium() {
		driver = DriverFactory.getDriver();
	    menu.acessarFormulario();
	}
	
	@Test
	public void cadastroFormulario() throws MalformedURLException {
      
	    //preencher campos
		page.escreverNome("Carlos");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		
	    //salvar
		page.salvar();
	    
	    //verificacoes
	    Assert.assertEquals("Nome: Carlos", page.obterNome());   
	    Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());    
	    Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));
	    Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));    
	    
	}


}
