package repositories;

import db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;

abstract class CRUDRepository<Id>  {
    protected final EntityManager em;
    protected final EntityTransaction transaction;
    protected Logger logger;

    public CRUDRepository() {
        em = Connection.getInstance().getEntityManager();
        transaction = em.getTransaction();
    }

    /* Thêm  */
    public boolean add(Id id) {
        try {
            transaction.begin();
            em.persist(id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return false;
    }

    public boolean update(Id id) {
        try {
            transaction.begin();
            em.merge(id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }

        return false;
    }

}
