package com.seleniumproject.resources.Keywords;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Keyword_KhaoulaL_K29_SupprimerCategorie {
	WebDriver driver;
	
	//declaration des Proprietes
	private Properties locatorsAccueil;
	private Properties locatorsAdmin;
	
	// Declaration des variables pour la suppression d'une categorie
	private String Link_OutilsAdmin;	
	private String Link_GestionnairesDeCategories;
	private String Popup_Supprimer;
	private String Btn_Supprimer;
	private String txt_messageDeConfirmation;
	private String Link_Accueil;
	//Constructeur de la classe
	
	public Keyword_KhaoulaL_K29_SupprimerCategorie(WebDriver driver, Properties locatorsAccueil, Properties locatorsAdmin) {
		this.driver = driver;
		this.locatorsAccueil = locatorsAccueil;
		this.locatorsAdmin = locatorsAdmin;
		
	}
	
	public void supprimer_categorie(String categorie_conteneur, String nomCategorie) throws InterruptedException {
		//Lecture de donnees des fichiers proprietes
		Link_OutilsAdmin = locatorsAccueil.getProperty("Link_OutilsAdmin");
		Link_GestionnairesDeCategories = locatorsAdmin.getProperty("Link_GestionnairesDeCategories");
		Popup_Supprimer= locatorsAdmin.getProperty("Popup_Supprimer");
		Btn_Supprimer = locatorsAdmin.getProperty("Btn_Supprimer");
		txt_messageDeConfirmation = locatorsAdmin.getProperty("txt_messageDeConfirmation");
		Link_Accueil = locatorsAccueil.getProperty("Link_Accueil");
		// Ouvrir la page Outils admin
		driver.findElement(By.linkText(Link_OutilsAdmin)).click();
		// Cliquer sur le lien Gestionnaire de Categorie
		driver.findElement(By.linkText(Link_GestionnairesDeCategories)).click();
		Thread.sleep(3000);
		if (categorie_conteneur != "Categorie racine")
			driver.findElement(By.xpath(
					"//table//span[contains(text(),'"+categorie_conteneur+"')]/ancestor::td/preceding::td[1]/a"))
					.click();
		// Pointer la souris sur Categorie Racine
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'"+nomCategorie+"')]")).click();
		Thread.sleep(3000);
		//cliquer sur supprimer
		driver.findElement(By.xpath("//span[contains(text(),'"+nomCategorie+"')]/span[3]")).click();
		
		if(driver.findElement(By.id(Popup_Supprimer)).isDisplayed())
			driver.findElement(By.xpath(Btn_Supprimer)).click();
		if(driver.findElement(By.id(txt_messageDeConfirmation)).isDisplayed())
			Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		if (categorie_conteneur != "Categorie racine")
			driver.findElement(By.xpath(
					"//table//span[contains(text(),'"+categorie_conteneur+"')]/ancestor::td/preceding::td[1]/a"))
					.click();
		Thread.sleep(3000);
		boolean resultat=driver.findElement(By.xpath("//table//span[contains(text(),'"+categorie_conteneur+"')]/ancestor::table/following::div[1]")).getText().contains(nomCategorie);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(resultat);
		//Retour e la page d'accueil
		driver.findElement(By.linkText(Link_Accueil)).click();
		sa.assertAll();
	}

}
