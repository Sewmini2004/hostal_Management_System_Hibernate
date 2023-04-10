package lk.ijse.hibernate.hostel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.hibernate.hostel.service.custom.StudentBo;
import lk.ijse.hibernate.hostel.service.custom.impl.StudentBoImple;

import java.awt.*;

public class StudentController {
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
}
