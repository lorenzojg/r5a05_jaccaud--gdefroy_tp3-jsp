<%-- 
    Document   : infos_user
    Created on : 10 oct. 2023, 10:48:43
    Author     : bouchaib.lemaire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%-- Déclaration des des beans qui sont utilisés --%>

<jsp:useBean id="user" scope="request" class="fr.devavance.metier.beans.User" />


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations des utilisateurs</title>
    </head>
    <body>
        
        <div class="credentials">
            <p><b>Nom d'utilisateur</b> : <jsp:getProperty name="user" property="username" /></p>
            <p><b>Mot de passe</b> : <jsp:getProperty name="user" property="password" /></p>
        </div>
        
        <div class="info_user">
            <p><b>Profil </b> : <jsp:getProperty name="user" property="profil" /></p>
            <p><b>Authentification</b> : <jsp:getProperty name="user" property="auth" /></p>
        </div>
     

        
    </body>
</html>
