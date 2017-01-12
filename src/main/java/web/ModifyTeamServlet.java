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

@WebServlet("/modifyTeamServlet")
public class ModifyTeamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Team team = (Team) req.getSession().getAttribute("TEAM");
        String newName = (String) req.getParameter("name");

        //Dodawanie nowej druzyny
        try {
            //Sprawdzamy czy jest taki user
            Repositories repo = new Repositories();
            

            //Wpis do bazy z nowym userem
            TeamRepository ur = repo.getTeamRepository();
            team.setName(newName);
            ur.update(team);
            repo.saveAndQuit();
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
