package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.hibernate.hostel.service.custom.UserBo;
import lk.ijse.hibernate.hostel.service.util.ServiceFactory;

public class UserController {

    @FXML
    private Label lblUserId;

    @FXML
    private TableView<?> tblUser;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private JFXTextField txtUserId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private PasswordField txtPass1;

    @FXML
    private PasswordField txtPass2;

    private final UserBo userBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    @FXML
    void btnAddOnAction(ActionEvent event) {
        //mke ui ek bo ek repository okkom hduw pana dn manika mke addd ek krnna hrida haaa hoda lmy ar room ekn argen em pluwnnm krnn pana hdee mn enkota add ek iwrwennona anee pl mn krnnm sadde onna opok akrpiya ummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmaaa aaitin oii add unat arke hrii hrii ynn ha haa;;; ;;krnn pana enm  ha
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserIdOnAction(ActionEvent event) {

    }

}
