package com.seleniumproject.scripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.seleniumproject.resources.Keywords.Keyword_Leila_K2_CreerAspect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class K2_K19_Tests {

	WebDriver driver;
	Properties locators = new Properties();
	Properties Accueil = new Properties();
	Properties OutilsAdmin = new Properties();

	String txt_modele = "ModeleK2";
	String txt_newAspect = "AspectK2";
	String txt_LibAffichage = "AspectK2";
	String txt_Description = "CreationAspectK2";

	@BeforeMethod
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		FileInputStream propfile = new FileInputStream("src/test/java/com/seleniumproject/resources/Locators/Locators.properties");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		locators.load(propfile);
		driver.manage().window().maximize();
	}

	@Test
	public void TesterCreerAspect() throws Exception {
		driver.get("http://localhost:8083/share/page");
		driver.findElement(By.name("username")).sendKeys("6180081");
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
		
		Keyword_Leila_K2_CreerAspect k2=new Keyword_Leila_K2_CreerAspect(driver, Accueil, OutilsAdmin);
		k2.creer_Aspect(txt_modele, txt_newAspect, txt_LibAffichage, txt_Description);
	}

	
	
	@Test
	public void TesterSupprimerAspect() {

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
