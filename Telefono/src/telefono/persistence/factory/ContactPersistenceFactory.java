/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
