package sn.senforage.dao;

import sn.senforage.entities.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UtilisateurImpl implements IUtilisateur {

    private  EntityManager em;
    public UtilisateurImpl() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("foragePU");

        em = emf.createEntityManager();

    }

    @Override
    public int add(Utilisateur utilisateur) {
        try {
            em.getTransaction().begin();
            em.persist(utilisateur);
            em.getTransaction().commit();
            return 1;

        }catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    @Override
    public List<Utilisateur> list() {
        return em.createQuery("SELECT u FROM Utilisateur u").getResultList();
    }
}
