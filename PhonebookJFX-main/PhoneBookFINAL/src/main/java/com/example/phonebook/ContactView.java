package com.example.phonebook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class ContactView {
    private TableView<Contact> contactTable;
    private Button addButton;
    private Button deleteButton;
    private Button loadButton;
    private Button saveButton;
    private VBox root;
    private TextField nameField;
    private TextField phoneNumberField;
    private TextField emailAddressField;
    private TextField secondaryEmailAddressField;
    private ComboBox<String> styleBox;
    private Map<String, String> styleSheets;

    public ContactView() {

        // Create and configure TableView
        contactTable = new TableView<>();
        contactTable.getStyleClass().add("table-view");
        contactTable.setEditable(true);

        // Create columns and set up event handlers
        TableColumn<Contact, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Contact, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Contact, String> emailColumn = new TableColumn<>("Email");

        TableColumn<Contact, String> primaryEmailColumn = new TableColumn<>("Primary");
        primaryEmailColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        primaryEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TableColumn<Contact, String> secondaryEmailColumn = new TableColumn<>("Secondary");
        secondaryEmailColumn.setCellValueFactory(new PropertyValueFactory<>("secondaryEmailAddress"));
        secondaryEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        //Add columns to table
        contactTable.getColumns().setAll(nameColumn, phoneNumberColumn, emailColumn);
        //Makes all columns editable
        contactTable.setEditable(true);
        //Nested column for primary and secondary email
        emailColumn.getColumns().addAll(primaryEmailColumn, secondaryEmailColumn);
        //Columns will automatically resize fit to the size of the window
        contactTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);



        // Create TextFields for user input
        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.getStyleClass().add("text-field");
        phoneNumberField = new TextField();
        phoneNumberField.setPromptText("Phone Number");
        emailAddressField = new TextField();
        emailAddressField.setPromptText("Email Address");
        secondaryEmailAddressField = new TextField();
        secondaryEmailAddressField.setPromptText("Secondary Email Address");

        // Create buttons
        addButton = new Button("Add");
        addButton.getStyleClass().add("button");
        deleteButton = new Button("Delete");
        deleteButton.getStyleClass().add("button");
        loadButton = new Button("Load");
        saveButton = new Button("Save");

        // Arrange TextFields and buttons in an HBox
        HBox inputBox = new HBox(10, nameField, phoneNumberField, emailAddressField, secondaryEmailAddressField, addButton);
        HBox buttonBox = new HBox(10, deleteButton, loadButton, saveButton);
        inputBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);

        // Arrange TableView, inputBox, and buttonBox in a VBox
        root = new VBox(10, contactTable, inputBox, buttonBox);
        root.setPadding(new Insets(10));

        // Create the style selection ComboBox
        styleBox = new ComboBox<>();
//        ObservableList<String> options = FXCollections.observableArrayList(
//                "Modern.css", "Night Mode.css", "Navy.css"
//        );

        //Add user-friendly options for selecting a theme
        ObservableList<String> options = FXCollections.observableArrayList("Modern", "Nightmode", "Navy");
        styleBox.setItems(options);

        styleSheets = new HashMap<>();
        styleSheets.put("Modern", "/Modern.css");
        styleSheets.put("Nightmode", "/Nightmode.css");
        styleSheets.put("Navy", "/Navy.css");

        styleBox.setPromptText("Select a style");
        styleBox.setItems(options);
        buttonBox.getChildren().add(styleBox);

    }

    // Getters for UI components
    public TableView<Contact> getContactTable() {
        return contactTable;
    }

    public Button getAddButton() {
        return addButton;
    }

    public TextField getNameField() {
        return nameField;
    }
    public TextField getEmailAddressField() {
        return emailAddressField;
    }
    public TextField getSecondaryEmailAddressField() {
        return secondaryEmailAddressField;
    }
    public TextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getLoadButton() {
        return loadButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public VBox getRoot() {
        return root;
    }

    // Getter for the style selection ComboBox
    public ComboBox<String> getStyleBox() {
        return styleBox;
    }

    public Map<String, String> getStyleSheets() {
        return styleSheets;
    }

}

