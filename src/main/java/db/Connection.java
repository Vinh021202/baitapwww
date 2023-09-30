package db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private final EntityManager em;
    private static Connection coonection;

    private Connection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("last_week02");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public static Connection getInstance() {
        if (coonection == null)
            coonection = new Connection();
        return coonection;
    }

}
