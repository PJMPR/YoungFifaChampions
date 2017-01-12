package web;

import com.mycompany.youngfifachampions.Repositories;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.Team;
import db.classes.User;
import db.repositories.TeamRepository;
import db.repositories.UserRepository;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = (String) req.getParameter("name");
        

        //Dodawanie nowej druzyny
        try {
            //Sprawdzamy czy jest taki user
            Repositories repo = new Repositories();
            

            //Wpis do bazy z nowym userem
            TeamRepository ur = repo.getTeamRepository();
            ur.add(new Team(Integer.SIZE, name, ((User)req.getSession().getAttribute("USER")).getId()));
            repo.saveAndQuit();
            
            //Pobieramy nowo powstałego usera na podstawie lginu
            Team newTeam=ur.getTeamByUserId(((User)req.getSession().getAttribute("USER")).getId());
            
            
            if (newTeam != null) {
                req.getSession().setAttribute("TEAM",newTeam);
            } else {
                //Tutaj jakiś błąd logowania więc redirect
                //resp.sendRedirect("/wrongAccountRegisterData.html");
                return;
            }

        } catch (SQLException e) {
            resp.getWriter().println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            resp.getWriter().println(ex.getMessage());
            ex.printStackTrace();
        }

        //redirect
        resp.sendRedirect("/account.jsp");
    }

}
