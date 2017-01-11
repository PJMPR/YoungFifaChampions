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

@WebServlet("/modifyUserServlet")
public class ModifyUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String password = (String) req.getParameter("password");

        //Sprawdzenie czy wpisane dobre dane
        if (password == null || password.isEmpty()) {

            resp.getWriter().println("podaj nowe hasło");
            resp.sendRedirect("/modifyAcc.html");
            return;
        }

        //Adding new user
        try {
            //Sprawdzamy czy jest taki usre
            Repositories repo = new Repositories();
            User user = (User) req.getSession().getAttribute("USER");

            //Ustawienie hasła w obiekcie
            user.setPassword(password);

            //Ustawienie hasła w bazie
            repo.getUserRepository().update(user);
            repo.saveAndQuit();

        } catch (SQLException e) {
            resp.getWriter().println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            resp.getWriter().println(ex.getMessage());
            ex.printStackTrace();
        }
        //Redirect bo ok
        resp.sendRedirect("account.jsp");

    }

}
