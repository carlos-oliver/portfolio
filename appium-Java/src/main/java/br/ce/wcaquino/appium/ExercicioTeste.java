package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ExercicioTeste {
	@Test
	public void cadastroFormulario() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    //desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    //desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\carlos.oliveira\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //acessar formuário
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	    elementosEncontrados.get(1).click();
	    
	    //cadastrar nome
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("Carlos");
	    
	    //selecionar opção 
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='XBox One']")).click();
	    
	    //seleciona check box 
	    MobileElement check =  driver.findElement(By.className("android.widget.CheckBox"));
	    check.click();
	    
	    driver.findElement(By.className("android.widget.Switch")).click();
	    
	    //salvar
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	    // verificação
	    MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Carlos']"));
	    Assert.assertEquals("Nome: Carlos", nome.getText());
	    
	    MobileElement combo = driver.findElement(By.xpath("android.widget.TextView[start-with(@text, 'Console:')]"));
	    Assert.assertEquals("Console: switch", combo.getText());
	    
	    MobileElement swit = driver.findElement(By.xpath("android.widget.TextView[start-with(@text, 'Console:')]"));
	    Assert.assertTrue(swit.getText().endsWith("off"));
	    
	    MobileElement check2 = driver.findElement(By.xpath("android.widget.TextView[start-with(@text, 'CheckBox:')]"));
	    Assert.assertTrue(check2.getText().endsWith("Marcado"));
	    
	    driver.quit();
	}
}
