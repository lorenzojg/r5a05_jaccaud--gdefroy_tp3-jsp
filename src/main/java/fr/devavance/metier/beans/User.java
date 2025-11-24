package fr.devavance.metier.beans;

import java.io.Serializable;

/**
 *
 * @author bouchaib.lemaire
 */
public class User implements Serializable {

    // properties
    private String username = "";  // Nom d'utilisateur
    private String password = "";  // Mot de passe
    private String profil = "";  // Profil de l'utilisateur "admin" ou "user"
    private Boolean auth = false; // Important : déconnecté par défaut

    public User(){}
    
    public String getUserName(){return this.username;}
    
    public String getPassword(){return this.password;}
    
    public String getProfil(){return this.profil;}
    
    public boolean getAuth(){return this.auth;}
    
    public void setUsername(String n_userName){this.username = n_userName;}
    
    public void setPassword(String n_passWord){this.password = n_passWord;}
    
    public void setProfil(String n_profil){this.profil = n_profil;}
    
    public void setAuth(boolean n_auth){this.auth = n_auth;}
}