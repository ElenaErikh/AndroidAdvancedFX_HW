package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    private double a;
    private double b;

    private char symbol;

    @FXML
    public TextField textField;


    public void addition() {
        a = Double.parseDouble(textField.getText());
        textField.clear();
        symbol = '+';
    }

    public void subtraction() {
        a = Double.parseDouble(textField.getText());
        textField.clear();
        symbol = '-';
    }

    public void multiply() {
        a = Double.parseDouble(textField.getText());
        textField.clear();
        symbol = '*';
    }

    public void division() {
        a = Double.parseDouble(textField.getText());
        textField.clear();
        symbol = '/';
    }

    public void clean() {
        textField.clear();
    }

    public void result() {
        b = Double.parseDouble(textField.getText());
        switch (symbol){
            case '+':
                textField.setText("" + (a + b));
                break;
            case '-':
                textField.setText("" + (a - b));
                break;
            case '*':
                textField.setText("" + (a * b));
                break;
            case '/':
                textField.setText("" + (a / b));
                break;
        }
        symbol = ' ';
    }
}
