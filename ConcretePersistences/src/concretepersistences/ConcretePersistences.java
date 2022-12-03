package concretepersistences;

import concretepersistences.domain.Book;
import concretepersistences.domain.Product;
import concretepersistences.persistence.concrete.BookPersistence;
import concretepersistences.persistence.concrete.BookPersistenceFile;
import concretepersistences.persistence.concrete.ProductPersistence;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConcretePersistences {

    public static final String PATH = "./assets/books.dat";

    public static void filePersistence() throws IOException, FileNotFoundException, ClassNotFoundException {
        BookPersistenceFile booksOnFile = new BookPersistenceFile(PATH);
        try {
            booksOnFile.create(new Book("001", "Aloppio", "Karrera", "Le mele"));
            booksOnFile.create(new Book("002", "Scercio", "Lametta", "Le pere"));
            booksOnFile.create(new Book("003", "Zargobo", "Demella", "I meloni"));
            booksOnFile.create(new Book("004", "Barbbut", "Spodeio", "A banana"));
        } catch (IllegalArgumentException ex) {
            System.out.println("Elementi precedentemente inseriti nel file");
        }
    }

    public static void loadListPersistenceFromFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        BookPersistence booksOnRam = new BookPersistence(PATH);
        String persistenceListOutput = booksOnRam.getAll().toString();
        System.out.println(persistenceListOutput);
    }

    public static void accessoSincronizzatoAllaRisorsa() throws InterruptedException {
        ProductPersistence pp = new ProductPersistence();
        String uid = "007";

        pp.create(new Product(uid, 40));

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (pp) {
                    Product p = pp.read(uid);
                    p.setQuantity(p.getQuantity() - 1);
                    pp.update(p);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (pp) {
                    Product p = pp.read(uid);
                    p.setQuantity(p.getQuantity() - 1);
                    pp.update(p);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Quantità del prodotto: " + pp.read(uid).getQuantity());
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, InterruptedException {
        filePersistence();
        loadListPersistenceFromFile();
        accessoSincronizzatoAllaRisorsa();
    }
}
