package jpasample;

import jpasample.domain.Student;
import jpasample.persistence.PersistenceStudent;

public class JPASample {

    public static void dbSetPopulation() throws IllegalArgumentException {
        PersistenceStudent db = new PersistenceStudent();
        for (int i = 0; i < 10; i++) {
            Student student = new Student("0" + i, "user" + i);
            db.create(student);
        }
    }

    public static void dbShowPopulation() {
        PersistenceStudent db = new PersistenceStudent();
        db.getAll().forEach((student) -> {
            System.out.println(student);
        });
    }

    public static void main(String[] args) {
        try {
            dbSetPopulation();
        } catch (Exception ex) {
            System.out.println("db precedentemente popolato");
        }
        dbShowPopulation();
    }

}
