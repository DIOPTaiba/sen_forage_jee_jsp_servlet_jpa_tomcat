package sn.senforage.dao;

import sn.senforage.entities.Village;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VillageImpl implements IVillage {

    private EntityManager em;

    public VillageImpl() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("foragePU");
        em = emf.createEntityManager();
    }

    @Override
    public int add(Village village) {
        try {
            em.getTransaction().begin();
            em.persist(village);
            em.getTransaction().commit();
            return 1;

        }catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Village> listVillage() {
        return em.createQuery("SELECT v FROM Village v").getResultList();
    }

    @Override
    public Village getVillageById(String idVillage) {
        Village village = (Village) em.createQuery("SELECT v FROM Village v WHERE v.idVillage=:n")
                .setParameter("n",idVillage).getSingleResult();

        return village;
    }

}
