package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import lk.ijse.hibernate.hostel.dto.ReservationDTO;
import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.service.custom.ReservationBo;
import lk.ijse.hibernate.hostel.service.custom.RoomBo;
import lk.ijse.hibernate.hostel.service.custom.StudentBo;
import lk.ijse.hibernate.hostel.service.util.ServiceFactory;
import lk.ijse.hibernate.hostel.view.tm.ReservationTM;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationController {

    public Label lblReservationId;
    public ComboBox<StudentDTO> cmbStdId;
    public JFXTextField txtAccountNo;
    public Label lblName;
    public Label lblAddress;
    public ComboBox<RoomDTO> cmbRoomId;
    public Label lblTypeRoom;
    public Label lblStatus;
    public Label lblKeyMoney;
    public JFXTextField txtPayingAmount;
    public TableView<ReservationTM> tblReservation;
    public TableColumn<?, ?> colResId;
    public TableColumn<?, ?> colStudentId;
    public TableColumn<?, ?> colRoomId;
    public TableColumn<?, ?> colStuName;
    public TableColumn<?, ?> colType;
    public TableColumn<?, ?> colKeyMoney;
    public TableColumn<?, ?> colPayAmount;
    public Label lblDate;
    public DatePicker dateFrom;
    public DatePicker dateTo;
    public Label lblBalance;


    private ReservationBo reservationBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RESEVATION);
    public ComboBox cmbStatus;
    public Label lblQty;
    private StudentBo studentBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT);
    private RoomBo roomBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOM);

    ObservableList<String> observableList = FXCollections.observableArrayList("Yes", "No");


    public void initialize() {

        try {

            setComboBoxes();
            loadReservationId();
            cmbStatus.setItems(observableList);

            //SetCellValue Factory
            colResId.setCellValueFactory(new PropertyValueFactory<>("ResId"));
            colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
            colStuName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colType.setCellValueFactory(new PropertyValueFactory<>("type"));
            colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
            colPayAmount.setCellValueFactory(new PropertyValueFactory<>("payingAmount"));


            List<ReservationTM> reservationTMS=reservationBo.getAll().stream().map(r -> new ReservationTM(
                    r.getResId(),
                    r.getKeyMoney(),
                    r.getPayingAmount(),
                    r.getStudent().getStudentId(),
                    r.getStudent().getName(),
                    r.getRoom().getRoomTypeId(),
                    r.getStatus()
            )).collect(Collectors.toList());
            tblReservation.setItems(FXCollections.observableArrayList(reservationTMS));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setComboBoxes() throws Exception {
        cmbStdId.setItems(FXCollections.observableArrayList(studentBo.getAll()));
        cmbStdId.setConverter(new StringConverter<StudentDTO>() {
            @Override
            public String toString(StudentDTO object) {
                return object.getStudentId();
            }

            @Override
            public StudentDTO fromString(String string) {
                try {
                    return studentBo.search(string);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        cmbRoomId.setItems(FXCollections.observableArrayList(roomBo.getAll()));
        cmbRoomId.setConverter(new StringConverter<RoomDTO>() {
            @Override
            public String toString(RoomDTO object) {
                return object.getRoomTypeId();
            }

            @Override
            public RoomDTO fromString(String string) {
                try {
                    return roomBo.search(string);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }

    private void loadReservationId() throws Exception {
        lblReservationId.setText(reservationBo.generateNextId());
    }

    public void btnAddOnAction(ActionEvent event) {

        /*Get values from UI*/
        String resId = lblReservationId.getText();
        String status = (String) cmbStatus.getSelectionModel().getSelectedItem();

        double keyMoney = Double.parseDouble(lblKeyMoney.getText());
        double payingAmount = Double.parseDouble(txtPayingAmount.getText());
        double amountBalance = keyMoney - payingAmount;
        lblBalance.setText(String.valueOf(amountBalance));

        LocalDate fromValue = dateFrom.getValue();
        Date from = Date.from(fromValue.atStartOfDay(ZoneId.systemDefault()).toInstant());

        LocalDate toValue = dateTo.getValue();
        Date to = Date.from(toValue.atStartOfDay(ZoneId.systemDefault()).toInstant());

        /* -------------------------------------------*/


        try {
            StudentDTO student = cmbStdId.getSelectionModel().getSelectedItem();
            RoomDTO room = cmbRoomId.getSelectionModel().getSelectedItem();

            ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.orElse(cancel) == ok) {
                boolean isAdded = reservationBo.add(new ReservationDTO(resId, status, keyMoney, payingAmount, amountBalance, student, room, from, to));
                new Alert(Alert.AlertType.CONFIRMATION, "Added Success !").show();

                initialize();
                btnClearOnAction(event);
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Cancelled !").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added Failed !").show();
        }

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

    public void cmbRoomIdOnAction(ActionEvent event) {

        RoomDTO selectedItem = cmbRoomId.getSelectionModel().getSelectedItem();
        setRoomData(selectedItem);
    }

    public void setRoomData(RoomDTO roomDTO) {
        lblAddress.setText(roomDTO.getType());
        lblKeyMoney.setText(String.valueOf(roomDTO.getKeyMoney()));
        lblTypeRoom.setText(roomDTO.getType());
    }

    public void cmbStdIdOnAction(ActionEvent event) {
        StudentDTO selectedItem = cmbStdId.getSelectionModel().getSelectedItem();
        setStudentData(selectedItem);
    }

    public void setStudentData(StudentDTO studentDTO) {
        lblName.setText(studentDTO.getName());
        lblAddress.setText(studentDTO.getAddress());

    }

    public void cmbStatusOnAction(ActionEvent event) {
    }
}
