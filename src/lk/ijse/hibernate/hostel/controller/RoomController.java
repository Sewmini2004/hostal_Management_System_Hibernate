package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.service.custom.RoomBo;
import lk.ijse.hibernate.hostel.service.custom.StudentBo;
import lk.ijse.hibernate.hostel.service.custom.impl.StudentBoImple;
import lk.ijse.hibernate.hostel.service.util.ServiceFactory;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoomController {

    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;


    public Label lblRoomId;

    public TableView<Room> tblRoom;
    public TableColumn<?, ?> colRoomId;
    public TableColumn<?, ?> coltype;
    public TableColumn<?, ?> cilKeyMoney;
    public TableColumn<?, ?> colqty;
    public JFXTextField txtRoomId;
    public ComboBox<String> cmbType;

    private final RoomBo roomBo = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOM);
    ObservableList<String> observableList = FXCollections.observableArrayList("Non-AC", "Non-AC/Food", "AC", "AC/Food");

    public void initialize() {
        try {
            loadRoomId();
            cmbType.setItems(observableList);
            tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
            tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
            tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
            tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
            List<Room> roomList = roomBo.getAll().stream().map(room -> new Room(
                    room.getRoomTypeId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()
            )).collect(Collectors.toList());
            tblRoom.setItems(FXCollections.observableArrayList(roomList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadRoomId() throws Exception {
        lblRoomId.setText(roomBo.generateNextId());
    }

    public void btnAddOnAction(ActionEvent event) {
        String roomId = lblRoomId.getText();
        String type = (String) cmbType.getValue();
        String keyMoney = txtKeyMoney.getText();
        String qty = txtQty.getText();
        new ArrayList<Reservation>();

        boolean isAmountMatched = Pattern.compile("^[0-9]+(\\.[0-9][0-9])?$").matcher(txtKeyMoney.getText()).matches();
        boolean isQtyMatched = Pattern.compile("^(([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))$").matcher(txtQty.getText()).matches();

        if (isAmountMatched) {
            if (isQtyMatched) {
                try {
                    ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.orElse(cancel) == ok) {
                        boolean isAdded = roomBo.add(new RoomDTO(roomId, type, Double.parseDouble(keyMoney), Integer.parseInt(qty), new ArrayList<Reservation>()));
                        new Alert(Alert.AlertType.CONFIRMATION, "Added Success !").show();
                        initialize();
                        btnClearOnAction(event);//new ActionEvent denn on ne manika me mthod ekta ena actionEvent ek dunnm hri ah hri hri mem tmai
                    } else {
                        new Alert(Alert.AlertType.CONFIRMATION, "Cancelled !").show();
                    }
                } catch (Exception e) {
//            exception ekk pninwa kynne manika database ekt komth ynne nee mehtndi thmai api error message ek denna ona thrunda blnna manikata hri
                    new Alert(Alert.AlertType.CONFIRMATION, "Added Failed !").show();
                }//mem wdak krnn pluwm onnam manika anthmit mokk unth wenn on deyk thyenonam finally ek athult dnn pluwm meke em ekk nneda ne clear wen wge dewl ekt tinne btn ekk buttn ekk thbunta api ekkknek add krl iwrunma okkom clear wenn dnn e button ek athn cl krnn manika

            } else {
                txtQty.setFocusColor(Paint.valueOf("Red"));
                txtQty.requestFocus();
            }

        } else {
            txtKeyMoney.setFocusColor(Paint.valueOf("Red"));
            txtKeyMoney.requestFocus();
        }

    }


    public void btnDeleteOnAction(ActionEvent event) {

        String rooId = lblRoomId.getText();
        try {
            boolean isDelete = roomBo.delete(rooId);
            if (isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room removed!").show();
                btnClearOnAction(new ActionEvent());
                initialize();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Room removal failed!").show();

        }
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String roomId = lblRoomId.getText();
        String type = (String) cmbType.getValue();
        String keyMoney = txtKeyMoney.getText();
        String qty = txtQty.getText();
        new ArrayList<Reservation>();
        boolean isAmountMatched = Pattern.compile("^[0-9]+(\\.[0-9][0-9])?$").matcher(txtKeyMoney.getText()).matches();
        boolean isQtyMatched = Pattern.compile("^(([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))$").matcher(txtQty.getText()).matches();
        if (isAmountMatched) {
            if (isQtyMatched) {
                try {
                    boolean isUpdated = roomBo.update(new RoomDTO(roomId, type, Double.parseDouble(keyMoney), Integer.parseInt(qty), new ArrayList<Reservation>()));
                    if (isUpdated) {
                        ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        ButtonType cancel = new ButtonType("Cancel ", ButtonBar.ButtonData.CANCEL_CLOSE);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure ? !", ok, cancel);
                        Optional<ButtonType> buttonType = alert.showAndWait();
                        if (buttonType.orElse(cancel) == ok) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Updated Success !").show();
                            initialize();
                            btnClearOnAction(new ActionEvent());
                        } else {
                            new Alert(Alert.AlertType.CONFIRMATION, "Updated Failed !").show();

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                txtKeyMoney.setFocusColor(Paint.valueOf("Red"));
                txtKeyMoney.requestFocus();
            }
        } else {
            txtQty.setFocusColor(Paint.valueOf("Red"));
            txtQty.requestFocus();
        }


    }

    public void btnClearOnAction(ActionEvent event) {
        lblRoomId.setText(null);
        cmbType.setItems(null);
        txtKeyMoney.setText(null);
        txtQty.setText(null);
        initialize();

    }

    public void RoomIdNoOnAction(ActionEvent event) {
    }

    public void btnSearchOnAction(ActionEvent event) {
        String roomId = txtRoomId.getText();
        try {
            boolean isAvailables = roomBo.isExists(roomId);
            if (isAvailables) {
                RoomDTO getRoom = roomBo.search(roomId);
                lblRoomId.setText(getRoom.getRoomTypeId());
                cmbType.setItems(observableList);
                cmbType.getSelectionModel().select(getRoom.getType());
                txtKeyMoney.setText(String.valueOf(getRoom.getKeyMoney()));
                txtQty.setText(String.valueOf(getRoom.getQty()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Room is not found !!");

            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Room is not found !!");

        }

    }

    public void cmbTypeOnAction(ActionEvent event) {

    }

    public void AccoutntNoOnAction(ActionEvent event) {

    }
}
