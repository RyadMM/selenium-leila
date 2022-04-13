package Keywords;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keyword_Haykel_k13_Creer_Liste_donnees {
	WebDriver driver;
	Properties locators = new Properties();
	
	//creation du constructeur de la  class
	public Keyword_Haykel_k13_Creer_Liste_donnees(WebDriver driver, Properties locators) {
		this.driver = driver;
		this.locators = locators;
	}
	//creation de la methode Creation liste de donnee
	public void CreationListeDeDonnees(String vSiteName, String vTitre, String vDescription) {
		//locators.getProperty: recupere la valeur de la cle a partir du fichier externe
		//stocker cette valeur dans une variable de type string 
		  String Sites_HeaderMenu = locators.getProperty("Div_HeaderMenu");
		  String Lnk_MesSites = locators.getProperty("Lnk_MesSites");
		  String Lnk_SiteRecherchePart1 = locators.getProperty("Lnk_SiteRecherchePart1");
		  String Lnk_SiteRecherchePart2 = locators.getProperty("Lnk_SiteRecherchePart2");
		  String PlusButton = locators.getProperty("Span_PlusBtn");
		  String ListesDesDonnees = locators.getProperty("Link_ListesDesDonnees");
		  String NouvelleListe = locators.getProperty("Btn_NouvelleListe");
		  String AgendaDenvenement = locators.getProperty("Link_AgendaDenvenement");
		  String Titre = locators.getProperty("Txt_Titre");
		  String Description = locators.getProperty("Txt_Description");
		  String Btn_Enregistrer = locators.getProperty("Btn_Enregistrer");
		  String ElementListeDonnees = locators.getProperty("Link_ElementListeDonnees");
		  String HeaderHome = locators.getProperty("Div_HeaderHome");
		  String ElementListe = locators.getProperty("List_ElementListe");
		  
		  //cliquer sur le bouton Sites du menu
		  driver.findElement(By.id(Sites_HeaderMenu)).click();
		  //cliquer sur le bouton Mes sites
		  driver.findElement(By.xpath(Lnk_MesSites)).click();	  
		  //cliquer sur le nom du site
		  driver.findElement(By.xpath(Lnk_SiteRecherchePart1+vSiteName+Lnk_SiteRecherchePart2)).click();
		  //cliquer sur le bouton Plus
		  driver.findElement(By.id(PlusButton)).click();
		  //cliquer sur le lien Liste des donnees
		  driver.findElement(By.xpath(ListesDesDonnees)).click();
		  //cliquer sur le bouton liste
		  driver.findElement(By.id(NouvelleListe)).click();
		  //cliquer sur agenda d'evenement
		  driver.findElement(By.xpath(AgendaDenvenement)).click();
		  //ecrire le titre de la liste
		  driver.findElement(By.id(Titre)).sendKeys(vTitre);
		  //ecrire la description de la liste
		  driver.findElement(By.id(Description)).sendKeys(vDescription);
		  //cliquer sur le bouton Enregisrer
		  driver.findElement(By.id(Btn_Enregistrer)).click();
		  boolean trouve = driver.findElement(By.xpath(ElementListe)).getText().contains(vTitre);
		  if (trouve == true)
		  {
			  //Revenir sur la page d'accueil
			  driver.findElement(By.id(HeaderHome)).click();
		  }
		//obtenir le titre de la page
		String titre=driver.getTitle();
		//comparer le titre obtenu avec le titre de la page d'accueil
		titre.equalsIgnoreCase("Alfresco » Tableau de bord utilisateur");
		  
	}
}
