package concretepersistences.controller;

import concretepersistences.persistence.concrete.BookPersistence;

public class Controller {
    private BookPersistence bookPersistence;

    public Controller(BookPersistence bookPersistence) {
        this.bookPersistence = bookPersistence;
    }
    
    
}
