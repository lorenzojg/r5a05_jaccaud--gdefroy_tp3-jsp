package fr.devavance.metier.beans;

import java.io.Serializable;

/**
 *
 * @author bouchaib.lemaire
 */
public class User implements Serializable {

    // properties
    private String userName = "";  // Nom d'utilisateur
    private String password = "";  // Mot de passe
    private String profil = "";  // Profil de l'utilisateur "admin" ou "user"
    private Boolean auth = false; // Important : déconnecté par défaut

    public User(){}
    
    public String getUserName(){return this.userName;}
    
    public void setUserName(String n_userName){this.userName = n_userName;}
    
    
    


}