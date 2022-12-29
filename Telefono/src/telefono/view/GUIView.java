package telefono.view;

import java.util.List;
import telefono.controller.Controller;
import telefono.domain.Contact;

public class GUIView extends javax.swing.JFrame implements IView {

    private static final long serialVersionUID = 1L;

    public GUIView(Controller controller) {
        initComponents();
        this.controller = controller;
        notificationPanel.setVisible(false);
        contactEditPanel.setVisible(false);
        contactPanel.setVisible(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        listContacts(controller.getAll());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        contactsList = new javax.swing.JList<>();
        searchBoxField = new javax.swing.JTextField();
        contactPanel = new javax.swing.JPanel();
        contactNameLabel = new javax.swing.JLabel();
        contactSurnameLabel = new javax.swing.JLabel();
        contactPhoneNumberLabel = new javax.swing.JLabel();
        contactEditButton = new javax.swing.JButton();
        contactDeleteButton = new javax.swing.JButton();
        notificationPanel = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();
        contactEditPanel = new javax.swing.JPanel();
        updateNameFiled = new javax.swing.JTextField();
        updateSurnameField = new javax.swing.JTextField();
        updatePhoneNumberField = new javax.swing.JTextField();
        updateConfirmButton = new javax.swing.JButton();
        updateCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contactsList.setToolTipText("");
        contactsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(contactsList);

        searchBoxField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchBoxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxFieldActionPerformed(evt);
            }
        });

        contactEditButton.setText("Edit");
        contactEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactEditButtonActionPerformed(evt);
            }
        });

        contactDeleteButton.setText("Delete");
        contactDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contactPanelLayout = new javax.swing.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(contactNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contactSurnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contactPhoneNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addComponent(contactEditButton)
                        .addGap(46, 46, 46)
                        .addComponent(contactDeleteButton)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contactNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contactSurnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contactPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactEditButton)
                    .addComponent(contactDeleteButton))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        notificationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notificationLabel.setToolTipText("");

        javax.swing.GroupLayout notificationPanelLayout = new javax.swing.GroupLayout(notificationPanel);
        notificationPanel.setLayout(notificationPanelLayout);
        notificationPanelLayout.setHorizontalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notificationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );
        notificationPanelLayout.setVerticalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(notificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        updateNameFiled.setText("name");
        updateNameFiled.setToolTipText("");

        updateSurnameField.setText("surname");

        updatePhoneNumberField.setText("phone number");

        updateConfirmButton.setText("Confirm");
        updateConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateConfirmButtonActionPerformed(evt);
            }
        });

        updateCancelButton.setText("Cancel");
        updateCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contactEditPanelLayout = new javax.swing.GroupLayout(contactEditPanel);
        contactEditPanel.setLayout(contactEditPanelLayout);
        contactEditPanelLayout.setHorizontalGroup(
            contactEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactEditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateNameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatePhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contactEditPanelLayout.createSequentialGroup()
                        .addComponent(updateConfirmButton)
                        .addGap(18, 18, 18)
                        .addComponent(updateCancelButton)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        contactEditPanelLayout.setVerticalGroup(
            contactEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactEditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateNameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contactEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contactEditPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(contactEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateConfirmButton)
                            .addComponent(updateCancelButton)))
                    .addGroup(contactEditPanelLayout.createSequentialGroup()
                        .addComponent(updateSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatePhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBoxField)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(notificationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(358, 358, 358))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(contactPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contactEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchBoxField, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(contactEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(notificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1242, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactsListMouseClicked
        Contact contact = contactsList.getSelectedValue();
        if (null != contact) {
            contactEditPanel.setVisible(false);
            showContact(contact);
        }
    }//GEN-LAST:event_contactsListMouseClicked

    private void contactEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactEditButtonActionPerformed
        Contact contact = contactsList.getSelectedValue();
        if (null == contact) {
            return;
        }

        String name = contact.getName();
        String surname = contact.getSurname();
        String phoneNumber = contact.getPhoneNumber();

        contactPanel.setVisible(false);
        contactEditPanel.setVisible(true);

        updateNameFiled.setText(name);
        updateSurnameField.setText(surname);
        updatePhoneNumberField.setText(phoneNumber);
    }//GEN-LAST:event_contactEditButtonActionPerformed

    private void contactDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactDeleteButtonActionPerformed
        Contact contact = contactsList.getSelectedValue();
        int index = contactsList.getSelectedIndex();

        if (index >= 0) {
            controller.delete(contact);
            listContacts(controller.getAll());
        }

        contactPanel.setVisible(false);

        String notification = DELETED_NOTIFICATION_TEXT + " " + contact.toString() + " " + contact.getPhoneNumber();
        notificationPanel.setVisible(true);
        notificationLabel.setText(notification);
    }//GEN-LAST:event_contactDeleteButtonActionPerformed

    private void searchBoxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxFieldActionPerformed
        String search = searchBoxField.getText();
        List<Contact> contacts = controller.filterContacts(search);
        listContacts(contacts);
    }//GEN-LAST:event_searchBoxFieldActionPerformed

    private void updateConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateConfirmButtonActionPerformed
        String notification = EDITED_NOTIFICATION_TEXT + " "
                + contactsList.getSelectedValue() + ": "
                + contactsList.getSelectedValue().getPhoneNumber() + " -> ";

        Contact contact = new Contact(
                contactsList.getSelectedValue().getKey(),
                updateNameFiled.getText(),
                updateSurnameField.getText(),
                updatePhoneNumberField.getText());

        int index = contactsList.getSelectedIndex();
        controller.update(contact);
        contactEditPanel.setVisible(false);
        contactPanel.setVisible(true);
        updateContacts();
        contactsList.setSelectedIndex(index);
        showContact(contact);

        notification += contact + ": " + contact.getPhoneNumber();
        notificationPanel.setVisible(true);
        notificationLabel.setText(notification);
    }//GEN-LAST:event_updateConfirmButtonActionPerformed

    private void updateCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCancelButtonActionPerformed
        contactEditPanel.setVisible(false);
        contactPanel.setVisible(true);
    }//GEN-LAST:event_updateCancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contactDeleteButton;
    private javax.swing.JButton contactEditButton;
    private javax.swing.JPanel contactEditPanel;
    private javax.swing.JLabel contactNameLabel;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JLabel contactPhoneNumberLabel;
    private javax.swing.JLabel contactSurnameLabel;
    private javax.swing.JList<Contact> contactsList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JPanel notificationPanel;
    private javax.swing.JTextField searchBoxField;
    private javax.swing.JButton updateCancelButton;
    private javax.swing.JButton updateConfirmButton;
    private javax.swing.JTextField updateNameFiled;
    private javax.swing.JTextField updatePhoneNumberField;
    private javax.swing.JTextField updateSurnameField;
    // End of variables declaration//GEN-END:variables

    private static final String EDITED_NOTIFICATION_TEXT = "EDITED";
    private static final String DELETED_NOTIFICATION_TEXT = "DELETED";
    private Controller controller;

    public Controller getController() {
        return controller;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void listContacts(List<Contact> contacts) {
        contactsList.setListData(contacts.toArray(new Contact[0]));
    }

    @Override
    public void showContact(Contact contact) {
        String name = contact.getName();
        String surname = contact.getSurname();
        String phoneNumber = contact.getPhoneNumber();
        contactPanel.setVisible(true);
        contactNameLabel.setText(name);
        contactSurnameLabel.setText(surname);
        contactPhoneNumberLabel.setText(phoneNumber);
    }

    private void updateContacts() {
        listContacts(controller.getAll());
    }
}
