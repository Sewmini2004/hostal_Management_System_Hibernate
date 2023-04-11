package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.hostel.service.custom.StudentBo;
import lk.ijse.hibernate.hostel.service.custom.impl.StudentBoImple;

import java.awt.*;

public class StudentController {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContactNo;
    public DatePicker date;
    public Label lbsId;
    public RadioButton rbtnMale;
    public ToggleGroup Gender;
    public RadioButton rbtnFemale;
    public JFXTextField txtAccountNo;
    public TableView tblStudent;
    public TableColumn colStuId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colGender;
    public TableColumn colBdy;
    StudentBo studentBo =new StudentBoImple();
    @FXML
    public Label stdId;

    public void btnDeleteOnAction(ActionEvent event) {
//        1. repository eken throw kr exception ek
//        2. e exceptoin ekma bo eknuth throw kr
//        anthimtma code krnne mthna api ek mthendi try catch ekkimhndle kra

        String stdId = this.stdId.getText();
        try {
//            Student hriytma dlt unoth wenne mokkd kyl methn dno
            boolean delete = studentBo.delete(stdId);
            new Alert(Alert.AlertType.CONFIRMATION,"Student removed!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Student removal failed!").show();

        }
    }

    public void dateOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
    }

    public void btnAddOnAction(ActionEvent event) {
    }

    public void btnSearchOnAction(ActionEvent event) {
    }

    public void AccoutntNoOnAction(ActionEvent event) {
    }
}
