package rubricatelefonica;

import rubricatelefonica.domain.ContattoTelefonico;
import rubricatelefonica.persistence.RubricaTelefonicaPersistence;

public class RubricaTelefonica {

    public static void main(String[] args) {
        setDatabase();
        showDatabasePopulation();
    }

    private static void setDatabase() throws IllegalArgumentException {
        RubricaTelefonicaPersistence db = new RubricaTelefonicaPersistence();
        for (int i = 0; i < 10; i++) {
            ContattoTelefonico contattoTelefonico = new ContattoTelefonico(i, "name" + i, "description" + i, "+39 " + i);
            db.create(contattoTelefonico);
        }
    }

    private static void showDatabasePopulation() {
        RubricaTelefonicaPersistence db = new RubricaTelefonicaPersistence();
        db.getAll().forEach((contattoTelefonico) -> {
            System.out.println(contattoTelefonico);
        });
    }
}
