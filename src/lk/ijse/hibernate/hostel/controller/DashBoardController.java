package lk.ijse.hibernate.hostel.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.hostel.util.Navigation;
import lk.ijse.hibernate.hostel.util.Route;

import java.io.IOException;

public class DashBoardController {
    public AnchorPane dashboardContext;

    public JFXButton btnExitOnAction;

    public AnchorPane pane2;

    public void roomManagementbtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.ROOM,dashboardContext);
    }

    public void roomResetvationbtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.RESERVATION,dashboardContext);
    }

    public void StudentManagementOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.STUDENT,dashboardContext);
    }

    public void btnExitOnAction(ActionEvent event) {

    }
}
