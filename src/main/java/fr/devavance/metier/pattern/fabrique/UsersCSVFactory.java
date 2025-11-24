/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.metier.pattern.fabrique;

import fr.devavance.metier.beans.User;
import fr.devavance.metier.beans.Users;
import fr.devavance.metier.exceptions.InvalidUserException;
import fr.devavance.metier.pattern.fabrique.interfaces.IUsersFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kauth_18
 */
public class UsersCSVFactory implements IUsersFactory {
    
    private static final Logger LOG = Logger.getLogger(UsersCSVFactory.class.getName());
    private static final String CSV_COMMENT_PREFIX = "#";
    private static final String CSV_SEPARATOR = ",";
    private static final int CSV_MIN_FIELDS = 3;
    private static final int CSV_AUTH_INDEX = 3;
    private static final int PASSWORD_MIN_LENGTH = 4;
    
    private String csvPath;
    
    public UsersCSVFactory(String initPath){
        this.csvPath = initPath;
    }
    
    
    @Override
    public Users createUsers() throws InvalidUserException, IOException {
        Users users = new Users();
        LOG.log(Level.INFO, "Chargement des utilisateurs depuis le CSV : {0}", csvPath);

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith(CSV_COMMENT_PREFIX))
                    continue;

                User u = createAUserFromCSV(line);
                checkUser(u);
                users.add(u);
                LOG.log(Level.INFO, "Utilisateur valide : {0}", u.getUserName());

            }
        }

        LOG.log(Level.INFO, "Chargement terminé : {0} utilisateurs", users.size());
        return users;
    }

    private User createAUserFromCSV(String line) {
        String[] userInfos = line.split(CSV_SEPARATOR);
        
        if (userInfos.length < CSV_MIN_FIELDS){
            return new User();
        }
                        
        User newUser = new User();
        newUser.setUsername(userInfos[0]);
        newUser.setProfil(userInfos[1]);
        newUser.setPassword(userInfos[2]);
        
        if (!userInfos[CSV_AUTH_INDEX].isEmpty()){
            if (userInfos[CSV_AUTH_INDEX].compareTo("true") == 0){
                newUser.setAuth(true);
            }
        }
        
        return newUser;
        
    }

    private void checkUser(User u) throws InvalidUserException {
        String password = u.getPassword();
        
        if (password.length() < PASSWORD_MIN_LENGTH){
            throw new InvalidUserException();
        }
    }
}
