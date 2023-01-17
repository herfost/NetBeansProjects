package telefono.persistence.factory;

import telefono.domain.Contact;
import telefono.persistence.IPersistence;
import telefono.persistence.concrete.ContactPersistenceMemory;
import telefono.persistence.concrete.ContactPersistenceRAM;

public class ContactPersistenceFactory {

    public static IPersistence<Integer, Contact> getPersistenceRAM() {
        return new ContactPersistenceRAM();
    }

    public static IPersistence<Integer, Contact> getPersistenceMemory(String path) {
        return new ContactPersistenceMemory(path);
    }
}
