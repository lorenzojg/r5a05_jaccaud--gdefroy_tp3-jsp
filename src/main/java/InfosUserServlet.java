
import java.io.IOException;
import fr.devavance.metier.beans.User;
import fr.devavance.metier.beans.Users;
import fr.devavance.metier.exceptions.InvalidUserException;
import fr.devavance.metier.pattern.fabrique.UsersCSVFactory;
import fr.devavance.metier.pattern.fabrique.interfaces.IUsersFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author bouchaib.lemaire
 */
@WebServlet(urlPatterns = {"/infos"})
public class InfosUserServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(InfosUserServlet.class.getName());
     
    public final static String KEY_USER = "user";
    public final static String KEY_USERS = "users";
    public final static String KEY_USER_NAME = "user_name";
    public final static String KEY_PROFIL = "profil";
    public final static String KEY_PASSWORD = "password";
    public final static String KEY_AUTH = "auth";
    
    private static final String KEY_INIT_PARAM_REAL_PATH_SUERS_CSV ="users.csv";
    
    public Users users;
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() throws ServletException {
      LOG.log(Level.INFO, "Initialisation via la fabrique CSV...");

        try {
            // "Fabriquer" les utilisateurs
            
            UsersCSVFactory factory = new UsersCSVFactory(KEY_INIT_PARAM_REAL_PATH_SUERS_CSV);
            factory.createUsers();
            
        } catch (InvalidUserException | IOException ex) {
            Logger.getLogger(InfosUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


     LOG.log(Level.INFO, "Initialisation terminée : {0} utilisateurs chargés.", users.size());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("infos_user.jsp").forward(request,response);
    
    }

  


}
