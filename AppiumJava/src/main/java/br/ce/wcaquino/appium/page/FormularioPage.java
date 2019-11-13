package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class FormularioPage extends BasePage{
	
	public void escreverNome(String nome) {
		
	    escrever(By.className("android.widget.EditText"), nome);
	}
	
	public String obterNome() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Carlos']"));
	}
	
	public void clicarCheck(){
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clicar(By.className("android.widget.Switch"));
	} 
	
	public void selecionarCombo(String valor) {
		selecionarCombo(By.className("android.widget.Spinner"), valor);
	}
	
	public void salvar() {
	    clicarPorTexto("SALVAR");
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}

	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
        

}
