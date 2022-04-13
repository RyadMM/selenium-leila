package Keywords;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Keyword_Haykel_k30_Supprimet_Liste_donnees {
	WebDriver driver;
	Properties locators = new Properties();
	//creation du constructeur de la classe
	public Keyword_Haykel_k30_Supprimet_Liste_donnees(WebDriver driver, Properties locators) {
		this.driver = driver;
		this.locators = locators;
	}
	//creation de la metthode Supprimer liste des donnees
	public void SupprimerListeDeDonnees(String vSiteName, String vTitre) {
		//locators.getProperty: recupere la valeur de la cle a partir du fichier externe
		//stocker cette valeur dans une variable de type string
		  String Sites_HeaderMenu = locators.getProperty("Div_HeaderMenu");
		  String Lnk_MesSites = locators.getProperty("Lnk_MesSites");
		  String Lnk_SiteRecherchePart1 = locators.getProperty("Lnk_SiteRecherchePart1");
		  String Lnk_SiteRecherchePart2 = locators.getProperty("Lnk_SiteRecherchePart2");
		  String PlusButton = locators.getProperty("Span_PlusBtn");
		  String ListesDesDonnees = locators.getProperty("Link_ListesDesDonnees");
		  String SupprimerElementPart1 = locators.getProperty("Btn_SupprimerElementPart1");
		  String SupprimerElementPart2 = locators.getProperty("Btn_SupprimerElementPart2");
		  String ConfirmerSuppression = locators.getProperty("Btn_ConfirmerSuppression");
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
		  //creation d'une variable de type Action
		  Actions action = new Actions(driver);
		  //stocker l'element dans une variable de type WebElement
		  WebElement suppression=driver.findElement(By.xpath(Lnk_SiteRecherchePart1+vTitre+Lnk_SiteRecherchePart2));
		  //deplacer le pointeur de la souris sur l'element
		  action.moveToElement(suppression).perform();
		  //cliquer sur le bouton de ssuppression
		  driver.findElement(By.xpath(SupprimerElementPart1+vTitre+SupprimerElementPart2)).click();
		  //cliquer sur le bouton de confirmation de la suppression
		  driver.findElement(By.xpath(ConfirmerSuppression)).click();
		  boolean trouve = driver.findElement(By.xpath(ElementListe)).getText().contains(vTitre);
		  if (trouve == false)
		  {
			  //Revenir sur la page d'accueil
			  driver.findElement(By.id(HeaderHome)).click();
		  }
		  //comprer le titre obtenu avec le titre de la page d'accueil
		  driver.getTitle().equalsIgnoreCase("Alfresco » Tableau de bord utilisateur");
	}
}
