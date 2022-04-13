package com.seleniumproject.resources.Keywords;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Keyword_KhaoulaL_K12_CreerCategorie {

	WebDriver driver;
	// declaration des Proprietes
	private Properties locatorsAccueil;
	private Properties locatorsAdmin;

	// Declaration des variables pour la creation d'une categorie
	private String Link_OutilsAdmin;
	private String Link_GestionnairesDeCategories;
	private String pop_up_Ajoutercategorie;
	private String Txt_NomCategorie;
	private String Btn_OK;
	private String txt_messageDeConfirmation;
	private String Link_Accueil;

	// Constructeur de la classe
	public Keyword_KhaoulaL_K12_CreerCategorie(WebDriver driver, Properties locatorsAccueil, Properties locatorsAdmin) {
		this.driver = driver;
		this.locatorsAccueil = locatorsAccueil;
		this.locatorsAdmin = locatorsAdmin;

	}

	public void creer_categorie(String categorie_conteneur, String nomCategorie) throws InterruptedException {

		// Lecture de donnees des fichiers proprietes
		Link_OutilsAdmin = locatorsAccueil.getProperty("Link_OutilsAdmin");
		Link_GestionnairesDeCategories = locatorsAdmin.getProperty("Link_GestionnairesDeCategories");
		pop_up_Ajoutercategorie = locatorsAdmin.getProperty("pop_up_Ajoutercategorie");
		Txt_NomCategorie = locatorsAdmin.getProperty("Txt_NomCategorie");
		Btn_OK = locatorsAdmin.getProperty("Btn_OK");
		txt_messageDeConfirmation = locatorsAdmin.getProperty("txt_messageDeConfirmation");
		Link_Accueil = locatorsAccueil.getProperty("Link_Accueil");
		// Ouvrir la page Outils admin
		driver.findElement(By.linkText(Link_OutilsAdmin)).click();
		// Cliquer sur le lien Gestionnaire de Categorie
		driver.findElement(By.linkText(Link_GestionnairesDeCategories)).click();
		// Pointer la souris sur Categorie Racine
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'" + categorie_conteneur + "')]")).click();
		Thread.sleep(3000);
		// Cliquer sur +
		driver.findElement(By.xpath("//span[contains(text(),'" + categorie_conteneur + "')]/span[1]")).click();
		// verifier si le popup pour l'ajout de la categorie est active
		if (driver.findElement(By.id(pop_up_Ajoutercategorie)).isDisplayed()) {
			// saisir le nom de categorie a cree
			driver.findElement(By.xpath(Txt_NomCategorie)).sendKeys(nomCategorie);
			// cliquer sur ok
			driver.findElement(By.xpath(Btn_OK)).click();
		}
		
			Thread.sleep(10000);
		driver.navigate().refresh();
		if (categorie_conteneur != "Categorie racine")
			driver.findElement(By.xpath(
					"//table//span[contains(text(),'" + categorie_conteneur + "')]/ancestor::td/preceding::td[1]/a"))
					.click();

		boolean resultat = driver.findElement(By.xpath(
				"//table//span[contains(text(),'" + categorie_conteneur + "')]/ancestor::table/following::div[1]"))
				.getText().contains(nomCategorie);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(resultat);
		// Retour à la page d'accueil
		driver.findElement(By.linkText(Link_Accueil)).click();
		sa.assertAll();
	}

}
