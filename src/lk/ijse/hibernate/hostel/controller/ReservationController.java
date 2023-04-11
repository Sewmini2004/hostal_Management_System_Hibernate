package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ReservationController {

    public Label lblReservationId;
    public ComboBox cmbStdId;
    public JFXTextField txtAccountNo;
    public Label lblName;
    public Label lblAddress;
    public ComboBox cmbRoomId;
    public Label lblTypeRoom;
    public Label lblStatus;
    public Label lblKeyMoney;
    public JFXTextField txtPayingAmount;
    public TableView tblReservation;
    public TableColumn colResId;
    public TableColumn colStudentId;
    public TableColumn colRoomId;
    public TableColumn colStuName;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colPayAmount;
    public Label lblDate;
    public DatePicker dateFrom;
    public DatePicker dateTo;
    public Label lblBalance;

    public void btnAddOnAction(ActionEvent event) {
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
    }

    public void AccoutntNoOnAction(ActionEvent event) {
    }

    public void btnSearchOnAction(ActionEvent event) {
    }
}
