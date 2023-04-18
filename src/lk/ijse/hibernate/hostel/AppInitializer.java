package lk.ijse.hibernate.hostel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        URL resource = this.getClass().getResource("/lk/ijse/hibernate/hostel/view/LoginForm.fxml");
        Parent window = FXMLLoader.load(resource);
        Scene scene = new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    public void changeScene(String fxml) throws IOException {
        URL resource = this.getClass().getResource(fxml);
        Parent window = FXMLLoader.load(resource);
        Scene scene = new Scene(window);
        stg.setScene(scene);
        stg.setTitle("Account");
    }

    public static void main(String[] args) {
        launch(args);
   /*     Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room1 = session.load(Room.class, "isudhfsrijfs");
        System.out.println(room1.getQty());

        System.out.println("Run Success");
       transaction.commit();
        session.close();*/

    }
}

