package rubricatelefonica.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import rubricatelefonica.domain.ContattoTelefonico;

public class RubricaTelefonicaPersistence implements IPersistence<Integer, ContattoTelefonico> {

    private static final String persistenceUnitName = "RubricaTelefonicaPU";
    private static final EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();

    @Override
    public void create(ContattoTelefonico value) throws IllegalArgumentException {
        ContattoTelefonico contattoTelefonico = read(value.getKey());
        if (contattoTelefonico != null) {
            throw new IllegalArgumentException();
        }

        entityManager.getTransaction().begin();
        entityManager.persist(value);
        entityManager.getTransaction().commit();
    }

    @Override
    public ContattoTelefonico read(Integer key) throws IllegalArgumentException {
        ContattoTelefonico contattoTelefonico = entityManager.find(ContattoTelefonico.class, key);
        if (contattoTelefonico == null) {
            throw new IllegalArgumentException("Invalid key");
        }
        return contattoTelefonico;
    }

    @Override
    public void update(ContattoTelefonico value) throws IllegalArgumentException {
        entityManager.getTransaction().begin();
        entityManager.merge(value);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Integer key) throws IllegalArgumentException {
        entityManager.getTransaction().begin(); // Inzio transazione
        entityManager.detach(key);
        entityManager.getTransaction().commit(); // Fine transazione
    }

    @Override
    public List<ContattoTelefonico> getAll() {
        return entityManager
                .createQuery("SELECT c FROM ContattoTelefonico AS C ORDER BY c.name ASC")
                .getResultList();

    }
}
