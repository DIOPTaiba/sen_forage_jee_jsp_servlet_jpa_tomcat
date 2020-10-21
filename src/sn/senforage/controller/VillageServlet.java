package sn.senforage.controller;

import sn.senforage.dao.IUtilisateur;
import sn.senforage.dao.IVillage;
import sn.senforage.dao.UtilisateurImpl;
import sn.senforage.dao.VillageImpl;
import sn.senforage.entities.Utilisateur;
import sn.senforage.entities.Village;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Village", name = "village")
public class VillageServlet extends HttpServlet {

    private IVillage villagedao;
    private IUtilisateur utilisateurdao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        villagedao = new VillageImpl();
        utilisateurdao = new UtilisateurImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("ok");
        req.setAttribute("villages", villagedao.listVillage());
        req.setAttribute("utilisateurs", utilisateurdao.listUtilisateur());
        req.getRequestDispatcher("village/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idVillage = req.getParameter("idVillage").toString();
        String nomVillage = req.getParameter("nomVillage").toString();
        String idUser = req.getParameter("idUser");

        Utilisateur utilisateur = utilisateurdao.getUserById(idUser);

        Village village = new Village();
        village.setIdVillage(idVillage);
        village.setNom(nomVillage);
        village.setUtilisateur(utilisateur);


        int ok = villagedao.add(village);
        //resp.getWriter().println(ok);
        req.setAttribute("resultat", ok);
        doGet(req, resp);
    }
}
