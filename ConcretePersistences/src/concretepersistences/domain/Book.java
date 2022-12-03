package concretepersistences.domain;

import concretepersistences.persistence.IPersistenceObject;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Book implements IPersistenceObject<String> {

    private static final long serialVersionUID = 1L;

    private String ISBN;
    private String name;
    private String author;
    private String description;

    public Book() {
    }

    public Book(String ISBN, String name, String author, String description) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getKey() {
        return ISBN;
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book { " + "ISBN = " + ISBN + ", name = " + name + ", author = " + author + ", description = " + description + " }";
    }

}
