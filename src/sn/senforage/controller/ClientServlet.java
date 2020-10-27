package sn.senforage.controller;

import sn.senforage.dao.*;
import sn.senforage.entities.Client;
import sn.senforage.entities.Utilisateur;
import sn.senforage.entities.Village;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/Client", name = "client")
public class ClientServlet extends HttpServlet {
    //private static final long serialVersionUID = 1L;

    private IClient clientdao;
    private IVillage villagedao;
    private IUtilisateur utilisateurdao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        clientdao = new ClientImpl();
        villagedao = new VillageImpl();
        utilisateurdao = new UtilisateurImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("ok");
        if (req.getSession().getAttribute("user")==null){
            resp.sendRedirect("/SenForage/");
        } else{

            req.setAttribute("clients", clientdao.listClient());
            req.setAttribute("villages", villagedao.listVillage());
            req.getRequestDispatcher("WEB-INF/client/add.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomFamille = req.getParameter("nomFamille").toString();
        String adresse = req.getParameter("adresse").toString();
        String telephone = req.getParameter("telephone").toString();
        String idvillage = req.getParameter("village").toString();
        Village villageRecu = villagedao.getVillageById(idvillage);

        HttpSession session = req.getSession(true);
        String idUser = (String) session.getAttribute("idUser");
        Utilisateur userRecu = utilisateurdao.getUserById(idUser);

        Client client = new Client();
        client.setNomFamille(nomFamille);
        client.setVillage(villageRecu);
        client.setUtilisateur(userRecu);
        client.setAdresse(adresse);
        client.setNumTel(telephone);


        int ok = clientdao.add(client);
        //resp.getWriter().println(ok);
        req.setAttribute("resultat", ok);
        doGet(req, resp);
    }
}
