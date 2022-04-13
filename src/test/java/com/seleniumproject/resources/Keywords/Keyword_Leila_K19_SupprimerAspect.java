package com.seleniumproject.resources.Keywords;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Keyword_Leila_K19_SupprimerAspect {

	WebDriver driver;
// declaration des Properties
	private Properties Accueil;
	private Properties OutilsAdmin;

// declaration des variables-CreerAspect
	private String Link_OutilsAdmin;
	private String Link_GestionnaireDeModeles;
	private String localisateurModele1;
	private String localisateurModele2;
	private String CreerAspectK2;
	private String InputNewAspect;
	private String InputNewLibAffichage;
	private String InputNewDescription;
	private String Link_Accueil;

// constructeur de la classe
	public Keyword_Leila_K19_SupprimerAspect (WebDriver driver, Properties Accueil, Properties OutilsAdmin) {	
		this.driver = driver;
		this.Accueil = Accueil;
		this.OutilsAdmin = OutilsAdmin;

	}
}
