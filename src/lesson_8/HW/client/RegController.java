package lesson_8.HW.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegController {
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField nickField;
    @FXML
    public Label registrationMsg;
    @FXML
    Controller controller;

    public void clickOk(ActionEvent actionEvent) {
        controller.tryRegistration(loginField.getText().trim(), passwordField.getText().trim(), nickField.getText().trim());
    }
}
