package lk.ijse.hibernate.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.hostel.AppInitializer;

import java.io.IOException;


public class LoginFormController {

    public TextField txt_username;
    public PasswordField txt_password;
    public CheckBox pass_toggle;
    public Label Logins;


    public void initialize(){
        txt_username.requestFocus();
    }


    public void togglevisiblePassword(ActionEvent event) {

    }

    public void btnLoginOnAction(ActionEvent event) throws IOException {
     checkLogin();
    }
    private void checkLogin() throws IOException {
        AppInitializer appInitializer = new AppInitializer();
        if (txt_username.getText().equals("sewmini") && txt_password.getText().equals("1234")
                || txt_username.getText().equals("pramodya") && txt_password.getText().equals("123456")) {
            Logins.setText("Success!");
            appInitializer.changeScene("/lk/ijse/hibernate/hostel/view/DashBoard.fxml");
        } else if (txt_username.getText().isEmpty() && txt_password.getText().isEmpty()) {
            Logins.setText("Please enter your User and Password !");
        } else {
            Logins.setText("Wrong username or password!");
        }
    }
}
