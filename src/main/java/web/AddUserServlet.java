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

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");
        String email = (String) req.getParameter("email");

        //Sprawdzenie czy nie wpisano pustych pól
        if (login == null || password == null || email == null
                || login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            //redirect na strone z info błęd
            resp.sendRedirect("/wrongAccountRegisterData.html");
            return;
        }

        //Dodawanie nowego usera
        try {
            //Sprawdzamy czy jest taki user
            Repositories repo = new Repositories();
            User newUser = repo.getUserRepository().getUserByName(login);
            if (newUser != null) {
                //Już w bazie user z takim loginem -> redirect nas torne z info błęduž
                resp.sendRedirect("/wrongAccountRegisterData.html");
                return;
            }

            //Wpis do bazy z nowym userem
            UserRepository ur = repo.getUserRepository();
            ur.add(new User(login, password, email));
            repo.saveAndQuit();
            
            //Pobieramy nowo powstałego usera na podstawie lginu
            newUser = ur.getUserByName(login);
            
            
            if (newUser != null) {
                req.getSession().setAttribute("USER", newUser);
                
                //Pobranie drużyny usera - zrobione tutaj bo jakis problem z tranzakcjami i z 
                // account.jsp czasami daje nula
                TeamRepository tr = repo.getTeamRepository();
                
                Team team = tr.getTeamByUserId(newUser.getId());
                if (team != null) {
                    req.getSession().setAttribute("TEAM", team);
                }

            } else {
                //Tutaj jakiś błąd logowania więc redirect
                resp.sendRedirect("/wrongAccountRegisterData.html");
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
