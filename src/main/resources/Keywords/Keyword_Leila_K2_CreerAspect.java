package Keywords;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Keyword_Leila_K2_CreerAspect {

	WebDriver driver;
	// declaration des Properties
	private Properties Accueil;
	private Properties OutilsAdmin;

	// declaration des variables-CreerAspect
	private String Link_OutilsAdmin;
	private String localisateurModele1;
	private String localisateurModele2;
	private String CreerAspectK2;
	private String InputNewAspect;
	private String InputNewLibAffichage;
	private String InputNewDescription;
	private String Link_Accueil;

	// constructeur de la classe
	public Keyword_Leila_K2_CreerAspect(WebDriver driver, Properties Accueil, Properties OutilsAdmin) {
		this.driver = driver;
		this.Accueil = Accueil;
		this.OutilsAdmin = OutilsAdmin;
	}

	public void creer_Aspect(String txt_modele, String txt_newAspect, String txt_LibAffichage, String txt_Description)
			throws InterruptedException {
		// lecture des donnees des fichiers properties
		Link_OutilsAdmin = Accueil.getProperty("Link_OutilsAdmin");
		OutilsAdmin.getProperty("Link_GestionnaireDeModeles");
		localisateurModele1 = OutilsAdmin.getProperty("localisateurModele1");
		localisateurModele2 = OutilsAdmin.getProperty("localisateurModele2");
		CreerAspectK2 = OutilsAdmin.getProperty("CreerAspectK2");
		InputNewAspect = OutilsAdmin.getProperty("InputNewAspect");
		InputNewLibAffichage = OutilsAdmin.getProperty("InputNewLibAffichage");
		InputNewDescription = OutilsAdmin.getProperty("InputNewDescription");
		Link_Accueil = Accueil.getProperty("Link_Accueil");
		// ouvrir la page Outils admin
		driver.findElement(By.linkText(Link_OutilsAdmin)).click();
		// cliquer sur le modele choisi
		driver.findElement(By.xpath("//span[text()='K2:AspectK2']" + txt_modele + "//span[text()='Creer un aspect']"))
				.click();
		Thread.sleep(3000);
		// cliquer sur le bouton "Creer un aspect"
		driver.findElement(By.xpath("//span[text()='Creer un aspect']")).click();
		// saisir le Nom du nouvel aspect et les champs e completer
		driver.findElement(By.name(InputNewAspect)).sendKeys("txt_newAspect");
		driver.findElement(By.name(InputNewLibAffichage)).sendKeys("txt_LibAffichage"); // InputNewLibAffichage=title
		driver.findElement(By.xpath("//div[2]/div/textarea")).sendKeys("txt_Description");
		Thread.sleep(3000);
		// cliquer sur le bouton "Creer"
		driver.findElement(By.id("CMM_CREATE_PROPERTYGROUP_DIALOG_OK_label")).click();
		// s'assurer que l'aspect "K2:AspectK2" est visible dans la section Aspect
		boolean resultat = driver.findElement(By.id("PROPERTY_GROUPS_LIST")).getText().contains(txt_newAspect);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(resultat);
		Thread.sleep(3000);
		// Retourner e l'accueil
		driver.findElement(By.linkText(Link_Accueil)).click();

	}

}
