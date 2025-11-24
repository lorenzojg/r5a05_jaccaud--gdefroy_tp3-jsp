/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.metier.pattern.fabrique.interfaces;

import fr.devavance.metier.exceptions.InvalidUserException;
import fr.devavance.metier.beans.Users;
import java.io.IOException;

/**
 *
 * @author kauth_18
 */
public interface IUsersFactory {
    
    public Users createUsers() throws InvalidUserException, IOException;
    
}
