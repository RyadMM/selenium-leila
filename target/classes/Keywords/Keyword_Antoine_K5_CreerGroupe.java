package Keywords;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keyword_Antoine_K5_CreerGroupe {
    WebDriver driver;
    Properties accueilLocators;
    Properties outilsAdminLocators;

    public Keyword_Antoine_K5_CreerGroupe(WebDriver driver, Properties accueilLocators, Properties outilsAdminLocators){
        this.driver = driver;
        this.accueilLocators = accueilLocators;
        this.outilsAdminLocators = outilsAdminLocators;
    }

    public void creerGroupe(String groupId, String groupDisplayName) throws IOException {
        //Se rendre dans la page Outils Admin
        driver.findElement(By.xpath(accueilLocators.getProperty("Link_OutilsAdmin"))).click();
        //Cliquer sur la section groupes dans le sous-menu Utilisateurs et Groupes
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Link_Groupes"))).click();
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Btn_ParcourirGroupes"))).click();
        //Rendre le id unique
        String timeStamp = new SimpleDateFormat("yyyymmdd-hhmmss").format(new Date());
        groupId = groupId + "(" + timeStamp + ")";
        driver.findElement(By.className(outilsAdminLocators.getProperty("Btn_CreerGroupe"))).click();
        //Remplir le formulaire
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Txt_NouveauGroupeId"))).sendKeys(groupId);
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Txt_NouveauGroupeNomAffiche"))).sendKeys(groupDisplayName);
        //Creer le groupe
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Btn_CreerNouveauGroupe"))).click();
        //Valider le popup de succès
        String newPath = outilsAdminLocators.getProperty("Txt_GroupeAVerifier").replace("{0}", groupId);
        //Revenir à la page acceuil
        driver.findElement(By.linkText(accueilLocators.getProperty("Link_Accueil"))).click();
    }
}
