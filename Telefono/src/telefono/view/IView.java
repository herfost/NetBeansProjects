package telefono.view;

import java.util.List;
import telefono.controller.Controller;
import telefono.domain.Contact;

public interface IView {

    public void listContacts(List<Contact> contacts);

    public void showContact(Contact contact);

    public void setController(Controller controller);
}
