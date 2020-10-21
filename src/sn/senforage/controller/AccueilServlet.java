package sn.senforage.controller;


import sn.senforage.dao.IUtilisateur;
import sn.senforage.dao.UtilisateurImpl;
import sn.senforage.entities.Utilisateur;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Accueil", name = "accueil")
public class AccueilServlet extends HttpServlet {

    private IUtilisateur utilisateurdao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        utilisateurdao = new UtilisateurImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("accueil.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String email = req.getParameter("email").toString();
        String password = req.getParameter("password").toString();

        Utilisateur userRecu = utilisateurdao.getUserByLogin(email, password);

        //doGet(req, resp);
        if (userRecu != null){
            resp.sendRedirect("accueil.jsp");
            //doGet(req, resp);
        }
        else {
            resp.sendRedirect("login.jsp");
        }


        //int ok = clientdao.add(client);
        //resp.getWriter().println(ok);
        //req.setAttribute("resultat", ok);
        //doGet(req, resp);
    }
}
