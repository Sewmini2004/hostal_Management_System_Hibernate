package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.service.custom.StudentBo;
import lk.ijse.hibernate.hostel.service.util.ServiceFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

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
    private final StudentBo studentBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT);

    @FXML
    public Label stdId;

    public void initialize() {
        try {
            loadStudentId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStudentId() throws Exception {
        lbsId.setText(studentBo.generateNextId());
    }

    public void btnDeleteOnAction(ActionEvent event) {
//        1. repository eken throw kr exception ek
//        2. e exceptoin ekma bo eknuth throw kr
//        anthimtma code krnne mthna api ek mthendi try catch ekkimhndle kra


        String stdId = lbsId.getText();
        try {
            boolean isDelete = studentBo.delete(stdId);
            if (isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student removed!").show();
                btnClearOnAction(new ActionEvent());
                initialize();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Student removal failed!").show();

        }

    }

    public void dateOnAction(ActionEvent event) {

    }

    public void btnUpdateOnAction(ActionEvent event) {
        String studentId = lbsId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        LocalDate value = date.getValue();
        Date dob = Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());

        String gender = null;
        if (rbtnMale.isSelected()) {
            gender = "MALE";
        } else if (rbtnFemale.isSelected()) {
            gender = "FEMALE";
        } else {
            new Alert(Alert.AlertType.WARNING, "Please select Gender !").show();
            return;
        }
        new ArrayList<Reservation>();
        try {
            boolean isUpdated = studentBo.update(new StudentDTO(studentId, name, address, contactNo, dob, gender, new ArrayList<Reservation>()));
            if (isUpdated) {

                ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.orElse(cancel) == ok) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Update Success !").show();
                    initialize();
                    btnClearOnAction(new ActionEvent());
                } else {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnClearOnAction(ActionEvent event) {
        lbsId.setText(null);
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        date.setValue(null);
        rbtnFemale.setSelected(false);
        rbtnMale.setSelected(false);
        txtAccountNo.clear();
        initialize();

    }

    public void btnAddOnAction(ActionEvent event) {
        String studentId = lbsId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        LocalDate value = date.getValue();
        Date dob = Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());

        String gender = null;
        if (rbtnMale.isSelected()) {
            gender = "MALE";
        } else if (rbtnFemale.isSelected()) {
            gender = "FEMALE";
        } else {
            new Alert(Alert.AlertType.WARNING, "Please select Gender !").show();
            return;
        }
        new ArrayList<Reservation>();
        try {
            boolean isAdded = studentBo.add(new StudentDTO(studentId, name, address, contactNo, dob, gender, new ArrayList<Reservation>()));
            if (isAdded) {
                ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.orElse(cancel) == ok) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added Success !").show();
                    initialize();
                    btnClearOnAction(new ActionEvent());
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added Failed !").show();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent event) {

        String studentId = txtAccountNo.getText();
        try {
            boolean isAvailables = studentBo.isExists(studentId);
            if (isAvailables) {
                StudentDTO getStudent = studentBo.search(studentId);
                lbsId.setText(getStudent.getStudentId());
                txtName.setText(getStudent.getName());
                txtAddress.setText(getStudent.getAddress());
                txtContactNo.setText(getStudent.getContactNo());
                Date dob = getStudent.getDob();
                date.setValue(getStudent.getDob().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate());
                String gender = getStudent.getGender();
                if (gender.equals("FEMALE")) {
                    rbtnFemale.setSelected(true);
                } else {
                    rbtnMale.setSelected(true);
                }

            } else {
                new Alert(Alert.AlertType.WARNING, "Student is not found !!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void AccoutntNoOnAction(ActionEvent event) {
    }
}

