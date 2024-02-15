package com.techexamproject.techexamproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextfied;

    @FXML
    private TextField emailTextfield;

    @FXML
    private DatePicker birthdatepicker;

    @FXML
    private ChoiceBox<String> genderBox;
    private String[] allgender = {"Male", "Female"};

    @FXML
    private Button submitButton;

    @FXML
    private Button clearButton;

    private String firstName;
    private String lastName;
    private String email;
    private String date;
    private String gender;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderBox.getItems().addAll(allgender);
        genderBox.setOnAction(this::choiceBoxClick);
    }

    @FXML
    private void choiceBoxClick(ActionEvent event)
    {
        gender = genderBox.getValue();
    }

    @FXML
    private void submitButtonClicked(ActionEvent event)
    {
          boolean proceedAccountCreatioin = CheckInput();
          if(proceedAccountCreatioin) {
              createAccount(firstName, lastName, email, date, gender);
              showAlert("Message");
          }
          else
          {
              showAlert("Error");
          }

    }

    @FXML
    private void clearButtonClicked(ActionEvent event)
    {
        firstNameTextField.setText("");
        lastNameTextfied.setText("");
        emailTextfield.setText("");
    }


    private void showAlert(String errorType) {
        Alert alert;
        if(errorType.equals("Error"))
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("DETECTED AN ERROR");
            alert.setContentText("DETECTED AN EMPTY FIELD");
            alert.show();
        }
        else
        {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION ACQUIRED");
            alert.setHeaderText("DETAILS:");
            alert.setContentText(firstName + " " + lastName + " " + "("+gender+")" + "\n" + "Born on " + date + "\n" + email);
            alert.show();
        }

    }

    private void createAccount(String firstName, String lastName, String email, String date, String gender) {
        Account account = new Account(firstName, lastName, email, date, gender);
        System.out.println(account.getFirstName() + " " + account.getLastName() + " " + "("+account.getGender()+")" + "\n" + "Born on " + account.getMyDate() + "\n" + account.getEmail());

    }

    private boolean CheckInput() {
        LocalDate dateGet = birthdatepicker.getValue();
        if(dateGet == null)
            return false;

        firstName = firstNameTextField.getText();
        lastName = lastNameTextfied.getText();
        email = emailTextfield.getText();

        date = dateGet.format(DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH));

        return !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !date.isEmpty() && !gender.isEmpty();
    }



}