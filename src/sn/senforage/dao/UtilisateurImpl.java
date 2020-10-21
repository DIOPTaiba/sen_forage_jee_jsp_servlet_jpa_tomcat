package sn.senforage.dao;

import sn.senforage.entities.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    public List<Utilisateur> listUtilisateur() {
        return em.createQuery("SELECT u FROM Utilisateur u").getResultList();
    }

    @Override
    public Utilisateur getUserById(String idUser){

        Utilisateur utilisateur = (Utilisateur) em.createQuery("SELECT u FROM Utilisateur u WHERE u.idUser=:n")
                .setParameter("n",idUser).getSingleResult();
        return utilisateur;
    }

    @Override
    public Utilisateur getUserByLogin(String email, String password) {
        Query query =  em.createQuery("SELECT u FROM Utilisateur u WHERE u.email=:e AND u.password=:p");
                query.setParameter("e",email);
        query.setParameter("p",password);
        try {
            return (Utilisateur) query.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
}
