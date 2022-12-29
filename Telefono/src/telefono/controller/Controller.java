package telefono.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import telefono.domain.Contact;
import telefono.persistence.IPersistence;
import telefono.view.IView;

public class Controller {

    private IView view;
    private IPersistence<Integer, Contact> persistence;

    public Controller(IView view, IPersistence<Integer, Contact> persistence) {
        this.view = view;
        this.persistence = persistence;
    }

    public IView getView() {
        return view;
    }

    public void setView(IView view) {
        this.view = view;
    }

    public IPersistence<Integer, Contact> getPersistence() {
        return persistence;
    }

    public void setPersistence(IPersistence<Integer, Contact> persistence) {
        this.persistence = persistence;
    }

    public List<Contact> filterContacts(String substring) {
        Predicate<Contact> filterBySubstring = contact -> {
            String fullName = contact.getName() + contact.getSurname();
            return fullName.toLowerCase().contains(substring.toLowerCase());
        };

        return persistence.getAll().stream().filter(filterBySubstring).collect(Collectors.toList());
    }

    public void delete(Contact contact) {
        persistence.delete(contact.getKey());
    }

    public List<Contact> getAll() {
        return persistence.getAll();
    }

    public void update(Contact contact) {
        try {
            persistence.update(contact);
        } catch (IllegalArgumentException ex) {
            System.out.println("Come caspita accade una cosa simile?");
        }
    }
}
