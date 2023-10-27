package com.example.phonebook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

// Main application class
public class Main extends Application {
    private ContactView view;
    private ContactController controller;
    private ObservableList<Contact> contacts;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Phone Contact Organizer");

        // Initialize an ObservableList of contacts
        contacts = FXCollections.observableArrayList();

        // Create the view and controller
        view = new ContactView();
        controller = new ContactController(contacts);

        // Load the contacts from file
        File contactsFile = new File("./contacts.txt");
        controller.loadContacts(contactsFile);

        // Set the contact list as the TableView items
        view.getContactTable().setItems(contacts);

        // Add event handlers for add, delete, load, save buttons
        view.getAddButton().setOnAction(event -> {
            String name = view.getNameField().getText();
            String phoneNumber = view.getPhoneNumberField().getText();
            String emailAddress = view.getEmailAddressField().getText();
            String secondaryEmailAddress = view.getSecondaryEmailAddressField().getText();
            if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty() && !secondaryEmailAddress.isEmpty()) {
                controller.addContact(name, phoneNumber, emailAddress, secondaryEmailAddress);
                view.getNameField().clear();
                view.getPhoneNumberField().clear();
                view.getEmailAddressField().clear();
                view.getSecondaryEmailAddressField().clear();
            }
        });

        view.getDeleteButton().setOnAction(event -> {
            Contact selectedContact = view.getContactTable().getSelectionModel().getSelectedItem();
            if (selectedContact != null) {
                controller.deleteContact(selectedContact);
            }
        });

        view.getLoadButton().setOnAction(event -> {
            File file = showFileChooser(primaryStage, "Load Contacts");
            if (file != null) {
                controller.loadContacts(file);
                view.getContactTable().setItems(contacts);
            }
        });

        view.getSaveButton().setOnAction(event -> {
            File file = new File("contacts.txt");
            if (file != null) {
                controller.saveContacts(file);
            }
        });

        // Add event handler for style box
        view.getStyleBox().setOnAction(e -> {
            String styleSheet = view.getStyleSheets().get(view.getStyleBox().getValue());
            if(styleSheet != null) {
                primaryStage.getScene().getStylesheets().clear();
                primaryStage.getScene().getStylesheets().add(getClass().getResource(styleSheet).toExternalForm());
            }
        });
        
        // Set the scene and show the stage
        view.getContactTable().setItems(contacts);
        primaryStage.setScene(new Scene(view.getRoot(), 700, 400));
        primaryStage.show();
    }

    // Method to display a file chooser dialog
    private File showFileChooser(Stage primaryStage, String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        if (title.equals("Load Contacts")) {
            return fileChooser.showOpenDialog(primaryStage);
        } else if (title.equals("Save Contacts")) {
            return fileChooser.showSaveDialog(primaryStage);
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
