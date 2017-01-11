package web;

import com.mycompany.youngfifachampions.Repositories;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");

        if ( //Check is data not null
                login == null || password == null
                || //check is dana not empty
                login.isEmpty() || password.isEmpty()) {
            //Redirect na strone z info ze błędne dane
            resp.sendRedirect("/wrongAccountData.html");
        }

        //logowanie
        try {
           //Sprawdzamy czy jest taki usre
            Repositories repo = new Repositories();
            User newUser = repo.getUserRepository().getUserByName(login);
            if (newUser != null) {
                //Ustawiamy w sesji
                req.getSession().setAttribute("USER", newUser);
                req.getSession().setAttribute("TEAM", repo.getTeamRepository().getTeamByUserId(newUser.getId()));
            } else {
                //Redirect bo jakiś błąd
                resp.sendRedirect("/wrongAccountData.html");
            }

        } catch (SQLException e) {
            resp.getWriter().println(e.getMessage());
            e.printStackTrace();
        } catch(ClassNotFoundException ex){
            resp.getWriter().println(ex.getMessage());
            ex.printStackTrace();
        }

        //Redirect 
        resp.sendRedirect("/account.jsp");
    }

}
