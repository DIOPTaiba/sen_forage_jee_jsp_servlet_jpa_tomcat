package sn.senforage.controller;

import sn.senforage.dao.ClientImpl;
import sn.senforage.dao.IClient;
import sn.senforage.entities.Client;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Client", name = "client")
public class ClientServlet extends HttpServlet {

    private IClient clientdao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        clientdao = new ClientImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("ok");
        req.getRequestDispatcher("client/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomFamille = req.getParameter("nomFamille").toString();
        String village = req.getParameter("village").toString();
        String adresse = req.getParameter("adresse").toString();
        String telephone = req.getParameter("telephone").toString();

        Client client = new Client();
        client.setNomFamille(nomFamille);
        client.setVillage(village);
        client.setAdresse(adresse);
        client.setNumTel(telephone);

        int ok = clientdao.add(client);
        //resp.getWriter().println(ok);
        req.setAttribute("resultat", ok);
        doGet(req, resp);
    }
}
