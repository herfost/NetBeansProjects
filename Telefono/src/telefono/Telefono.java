package telefono;

import telefono.controller.Controller;
import telefono.domain.Contact;
import telefono.persistence.IPersistence;
import telefono.persistence.factory.ContactPersistenceFactory;
import telefono.view.GUIView;
import telefono.view.IView;

public class Telefono {

    public static void main(String[] args) {
        IPersistence<Integer, Contact> persistence = ContactPersistenceFactory.getPersistenceRAM();
        persistence.create(new Contact(0, "Joe", "Biden", "777"));
        persistence.create(new Contact(1, "Vladimir", "Putin", "666"));
        persistence.create(new Contact(2, "Sergio", "Mattarella", "555"));
        persistence.create(new Contact(3, "Kishid", "Fumio", "444"));

        Controller controller = new Controller(null, persistence);
        IView view = new GUIView(controller);
        controller.setView(view);
    }
}
