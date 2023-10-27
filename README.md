# Phone Book Editor

## Introduction
This repository contains the final project for our software development course: a Phone Book Editor. The application offers a multitude of features that allow the user to maintain an organized phone book.

## Features
* **Adding Contacts**: Users can input their full name, phone number, and optionally, their primary and secondary email addresses. After providing the required details, they can click on the "Add" button to store the contact information in the phone book.
* **Deleting Contacts**: If an entry is incorrect, the user can select and delete it from the phone book using the "Delete" button.
* **Editing Contacts**: All columns of the contact information are editable. For instance, users can change the phone number while keeping the name unchanged. After editing, the updated information will be saved into the phone book.
* **Multiple Views**: The project adopts the Model-View-Controller (MVC) Framework to enable multiple views, thus reducing confusion and increasing readability of the codebase.

## Work Schedule
Our team plans to work on the project every Monday, Tuesday, and Thursday until it is due. The testing and development processes will be carried out in parallel, allowing us to make necessary changes on-the-go.

## Structure & Implementation
We've leveraged the MVC Framework, dividing the application into three components: Model, View, and Controller. The Model handles data and logic, the View displays the data and receives user input, while the Controller acts as an intermediary between the Model and the View. 

We've implemented four Java classes for this project: 
1. `Main.java`: Runs the program and combines the model, view, and controller.
2. `ContactView.java`: Sets and displays data, creates tables, columns, etc.
3. `Contact.java`: Defines a Contact object.
4. `ContactController.java`: Manages user interactions such as adding, deleting, loading, and saving contacts.

The `ContactView.java` class also uses JavaFX HBox for horizontal button positioning and allows users to choose from three different style sheets: Night Mode, Navy, and Modern.

## Challenges & Solutions
The development process has not been without challenges, particularly when implementing additional features such as the primary and secondary email columns. Initially, the columns didn't appear as expected in the `ContactView.java` file, but after some troubleshooting and further research, we identified a missing piece of code (`emailColumn.getColumns().addAll(primaryEmailColumn, secondaryEmailColumn)`), which creates nested columns for the email addresses. 

Despite the hurdles, our team was successful in developing a fully functional Phone Book Editor, utilizing the knowledge acquired throughout the semester.

## Conclusion
This project was a fulfilling learning journey. We learned a lot about problem-solving, effective collaboration, and the practical application of the concepts we learned during our course. We believe that this Phone Book Editor is a robust and user-friendly tool that will help users maintain and manage their contacts efficiently.
##
By Kyle Lambert & Rohit Menon
