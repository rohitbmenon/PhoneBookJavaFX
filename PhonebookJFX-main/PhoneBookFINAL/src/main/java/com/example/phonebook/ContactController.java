package com.example.phonebook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Class to manage (add, delete, load, save) contacts
public class ContactController {

    // ObservableList of contacts to track any changes
    private ObservableList<Contact> contacts;

    // Constructor initializing contacts ObservableList
    public ContactController(ObservableList<Contact> contacts) {
        this.contacts = contacts;
    }

    // Method to add a new contact and save it to file
    public void addContact(String name, String phoneNumber, String emailAddress, String secondaryEmailAddress) {
        contacts.add(new Contact(name, phoneNumber, emailAddress, secondaryEmailAddress));
        System.out.println("addContact"  + name);
        // Save the new contact in file
        saveContacts(new File("contacts.txt"));
        // Reload the updated contacts from file
        loadContacts(new File( "./contacts.txt"));
    }

    // Method to delete a contact and save the updated list to file
    public void deleteContact(Contact contact) {
        contacts.remove(contact);
        saveContacts(new File("contacts.txt"));
    }

    // Method to load contacts from a given file
    public void loadContacts(File file) {
        // If the file does not exist, create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }
        // Read contacts from file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ObservableList<Contact> loadedContacts = FXCollections.observableArrayList();
            String line;
            System.out.println("we made it to loadContacts");
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    loadedContacts.add(new Contact(fields[0], fields[1], fields[2], ""));
                } else if (fields.length == 4) {
                    loadedContacts.add(new Contact(fields[0], fields[1], fields[2], fields[3]));
                }
            }
            // Replace the existing contacts list with the loaded contacts
            contacts.setAll(loadedContacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save the current list of contacts to a file
    public void saveContacts(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Contact contact : contacts) {
                writer.write(String.join(",", contact.getName(), contact.getPhoneNumber(), contact.getEmailAddress(), contact.getSecondaryEmailAddress()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
