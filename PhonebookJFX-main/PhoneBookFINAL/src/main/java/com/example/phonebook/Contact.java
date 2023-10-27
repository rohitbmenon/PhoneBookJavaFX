package com.example.phonebook;

import javafx.beans.property.SimpleStringProperty;

// Class that defines a Contact object
public class Contact {
    // Use SimpleStringProperty to allow UI to auto-update when these values change
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty emailAddress;
    private SimpleStringProperty secondaryEmailAddress;

    // Constructor to initialize Contact object
    public Contact(String name, String phoneNumber, String emailAddress, String secondaryEmailAddress) {
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.emailAddress = new SimpleStringProperty(emailAddress);
        this.secondaryEmailAddress = new SimpleStringProperty(secondaryEmailAddress);
    }

    // Getter and setter methods for the properties
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmailAddress() {
        return emailAddress.get();
    }

    public String getSecondaryEmailAddress() {
        return secondaryEmailAddress.get();
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }

    public void setSecondaryEmailAddress(String secondaryEmailAddress) {
        this.secondaryEmailAddress.set(secondaryEmailAddress);
    }

    //Methods to get the SimpleStringProperty objects if needed

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public SimpleStringProperty emailAddressProperty() {
        return emailAddress;
    }

    public SimpleStringProperty secondaryEmailAddressProperty() {
        return secondaryEmailAddress;
    }
}
