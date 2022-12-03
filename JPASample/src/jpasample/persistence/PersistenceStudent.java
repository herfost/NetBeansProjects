package jpasample.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jpasample.domain.Student;

public class PersistenceStudent implements IPersistence<String, Student> {

    private static final String persistenceUnitName = "JPASamplePU";
    private static final EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();

    @Override
    public void create(Student value) throws IllegalArgumentException {
        Student student = read(value.getKey());
        if (student != null) {
            throw new IllegalArgumentException();
        }
        
        entityManager.getTransaction().begin();
        entityManager.persist(value);
        entityManager.getTransaction().commit();
    }

    @Override
    public Student read(String key) throws IllegalArgumentException {
        Student student = entityManager.find(Student.class, key);
        if (student == null) {
            throw new IllegalArgumentException("Invalid key");
        }
        return student;
    }

    @Override
    public void update(Student value) throws IllegalArgumentException {
        entityManager.getTransaction().begin();
        entityManager.merge(value);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(String key) throws IllegalArgumentException {
        entityManager.getTransaction().begin(); // Inzio transazione
        entityManager.detach(key);
        entityManager.getTransaction().commit(); // Fine transazione
    }

    @Override
    public List<Student> getAll() {
        return entityManager
                .createQuery("SELECT s FROM Student AS S ORDER BY s.name ASC")
                .getResultList();
    }
}
