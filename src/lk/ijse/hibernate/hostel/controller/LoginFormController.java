package lk.ijse.hibernate.hostel.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.hostel.AppInitializer;
import lk.ijse.hibernate.hostel.dto.UserDTO;
import lk.ijse.hibernate.hostel.service.custom.UserBo;
import lk.ijse.hibernate.hostel.service.util.ServiceFactory;

import java.io.IOException;
import java.util.List;


public class LoginFormController {

    public TextField txt_username;
    //    passwordHidden
    public PasswordField txt_password;
    //checkBox
    public CheckBox pass_toggle;
    public Label Logins;
    //passwordText
    public Label txtPassword;

    private final UserBo userBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public void initialize() {
        txt_username.requestFocus();

    }


    public void togglevisiblePassword(ActionEvent event) {
        if (pass_toggle.isSelected()) {
            txtPassword.setText(txt_password.getText());
            txtPassword.setVisible(true);
            txt_password.clear();
            return;

        }
        txt_password.setText(txtPassword.getText());
        txt_password.setVisible(true);
        txtPassword.setVisible(false);
    }

    public void btnLoginOnAction(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        AppInitializer appInitializer = new AppInitializer();

        try {
            List<UserDTO> all = userBo.getAll();
            for (UserDTO userDTO : all) {
                if (userDTO.getUsername().equals(txt_username.getText())) {
                    if (userDTO.getPassword().equals(txt_password.getText())) {
                        appInitializer.changeScene("/lk/ijse/hibernate/hostel/view/DashBoard.fxml");
                    } else {
                        Logins.setText("Wrong username or password!");
                    }
                } else {
                    Logins.setText("Wrong username or password!");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }






        /*if (txt_username.getText().equals("sewmini") && txt_password.getText().equals("1234")
                || txt_username.getText().equals("pramodya") && txt_password.getText().equals("123456")) {
            Logins.setText("Success!");
            appInitializer.changeScene("/lk/ijse/hibernate/hostel/view/DashBoard.fxml");
        } else if (txt_username.getText().isEmpty() && txt_password.getText().isEmpty()) {
            Logins.setText("Please enter your User and Password !");
        } else {
            Logins.setText("Wrong username or password!");
        }*/
//        appInitializer.changeScene("/lk/ijse/hibernate/hostel/view/DashBoard.fxml");
    }
}
