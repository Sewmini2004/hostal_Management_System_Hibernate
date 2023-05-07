package lk.ijse.hibernate.hostel.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Route route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();
        window.setResizable(false);

        switch (route) {
            case VIEW_NOT_PAID:
                window.setTitle("Not Paid By..");
                initUI("ViewNotPaidForm.fxml");
                break;

            case USER:
                window.setTitle("User Form");
                initUI("User.fxml");
                break;

            case LOGIN:
                window.setTitle("LOGIN Form");
                initUI("LoginForm.fxml");
                break;


            case DASHBOARD:
                window.setTitle("Dashboard");
                initUI("DashBoard.fxml");
                break;



            case STUDENT:
                window.setTitle("Student Form");
                initUI("Student.fxml");
                break;

            case ROOM:
                window.setTitle("Room Form");
                initUI("Room.fxml");
                break;


            case RESERVATION:
                window.setTitle("Reservation Form");
                initUI("Reservation.fxml");
                break;


            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }





    }

    private static void initUI(String s) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource("/lk/ijse/hibernate/hostel/view/" + s))));


    }
}

