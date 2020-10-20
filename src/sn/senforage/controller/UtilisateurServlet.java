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

@WebServlet(urlPatterns = "/Utilisateur", name = "utilisateur")
public class UtilisateurServlet extends HttpServlet {

    private IUtilisateur utilisateurdao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        utilisateurdao = new UtilisateurImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("ok");
        req.getRequestDispatcher("utilisateur/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idUser = req.getParameter("idUser").toString();
        String nom = req.getParameter("nom").toString();
        String prenom = req.getParameter("prenom").toString();
        String email = req.getParameter("email").toString();
        String password = req.getParameter("password").toString();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUser(idUser);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(password);

        int ok = utilisateurdao.add(utilisateur);
        //resp.getWriter().println(ok);
        req.setAttribute("resultat", ok);
        doGet(req, resp);
    }
}
