package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.UserDTO;
import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.service.custom.UserBo;
import lk.ijse.hibernate.hostel.service.util.ServiceFactory;
import lk.ijse.hibernate.hostel.view.tm.UserTM;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;

public class UserController {

    public JFXTextField txtAddress;
    @FXML
    private Label lblUserId;

    @FXML
    private TableView<UserTM> tblUser;

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
    private JFXTextField txtContact;

    @FXML
    private PasswordField txtPass1;

    @FXML
    private PasswordField txtPass2;

    private final UserBo userBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public void initialize() {
        try {
            loadUserId();
            tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("userId"));
            tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
            tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
            tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
            tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("username"));

            List<UserTM> userTMList = userBo.getAll().stream().map(user -> new UserTM(
                    user.getUserId(),
                    user.getName(),
                    user.getAddress(),
                    user.getContact(),
                    user.getUsername(),
                    user.getPassword()
            )).collect(Collectors.toList());
            tblUser.setItems(FXCollections.observableArrayList(userTMList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        int userId = Integer.parseInt(lblUserId.getText());
        String Name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String username = txtUsername.getText();
        String password = txtPass1.getText();

        try {
            ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.orElse(cancel) == ok) {
                boolean isAdded = userBo.add(new UserDTO(userId, Name, address, contact, username, password));
                new Alert(Alert.AlertType.CONFIRMATION, "Added Success !").show();
                initialize();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Cancelled !").show();
            }
        } catch (Exception e) {

            new Alert(Alert.AlertType.CONFIRMATION, "Added Failed !").show();
        }


    }

    private void loadUserId() throws Exception {
        lblUserId.setText(String.valueOf(userBo.generateNextId()));
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        lblUserId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContact.setText(null);
        txtUsername.setText(null);
        txtPass1.setText(null);
        initialize();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.orElse(cancel) == ok) {
                boolean isDelete = userBo.delete(Integer.parseInt(txtUserId.getText()));
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted Success !").show();
                initialize();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Cancelled !").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.CONFIRMATION, "Delete Failed !").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String userId = txtUserId.getText();
        try {
            boolean isAvailables = userBo.isExists(Integer.parseInt(userId));
            if (isAvailables) {
                UserDTO search = userBo.search(Integer.parseInt(userId));
                lblUserId.setText(String.valueOf(search.getUserId()));
                txtName.setText(search.getName());
                txtAddress.setText(search.getAddress());
                txtContact.setText(search.getContact());
                txtUsername.setText(search.getUsername());
                txtPass1.setText(search.getPassword());
            } else {
                new Alert(Alert.AlertType.WARNING, "User is not found !!");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "User is not found !!");

        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {


        String userId = lblUserId.getText();
        String name = txtName.getText();
        String username = txtUsername.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        String pass = txtPass1.getText();

        try {
            ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.orElse(cancel) == ok) {
                boolean isUpdate = userBo.update(new UserDTO(Integer.parseInt(userId), name, address, contact, username, pass));
                new Alert(Alert.AlertType.CONFIRMATION, "Updated Success !").show();
                initialize();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Cancelled !").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Failed !").show();
        }
    }

    @FXML
    void txtUserIdOnAction(ActionEvent event) {

    }

}
