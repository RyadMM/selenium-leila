package Keywords;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Keyword_Antoine_K22_SupprimerGroupe {
    WebDriver driver;
    Properties accueilLocators;
    Properties outilsAdminLocators;
    public Keyword_Antoine_K22_SupprimerGroupe(WebDriver driver, Properties accueilLocators, Properties outilsAdminLocators){
        this.driver = driver;
        this.accueilLocators = accueilLocators;
        this.outilsAdminLocators = outilsAdminLocators;
    }

    public void supprimerUnGroupe(String groupId) {
        //Se rendre dans la page Outils Admin
        driver.findElement(By.xpath(accueilLocators.getProperty("Link_OutilsAdmin"))).click();
        //Cliquer sur la section groupes dans le sous-menu Utilisateurs et Groupes
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Link_Groupes"))).click();
        //Rechercher le groupe
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Txt_RechercheGroupes"))).sendKeys(groupId);
        driver.findElement(By.xpath(outilsAdminLocators.getProperty("Btn_RechercheGroupes"))).click();
        //Rechercher si le groupe existe dans la liste et le cibler
        try {
            String cible = outilsAdminLocators.getProperty("Txt_ResultatGroupeCible").replace("{0}", groupId);
            WebElement id = driver.findElement(By.xpath(cible));
            List<WebElement> rows = driver.findElements(By.xpath(outilsAdminLocators.getProperty("WebElements_ResultatsRangeeId")));
            int rowId = -1;
            for (int i = 0; i < rows.size(); i++) {
                if (id.getText().equals(rows.get(i).getText())) {
                    rowId = i + 1;
                    break;
                }
            }
            //Supprimer le bon groupe
            driver.findElement(By.xpath(outilsAdminLocators.getProperty("WebElements_ResultatsRangee")
                    + "[" + rowId + "]" + outilsAdminLocators.getProperty("Link_SupprimerGroupe"))).click();
            //Valider la suppression
            driver.findElement(By.xpath(outilsAdminLocators.getProperty("Btn_PopupConfirmationSuppression"))).click();
            //Verifier s'il existe après rafraichissement de la page
            driver.navigate().refresh();

        } catch (NoSuchElementException ex) {
            //l'element n'existe pas donc pas besoin de le supprimer
        }
    }
}
