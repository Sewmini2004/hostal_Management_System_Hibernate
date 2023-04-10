package lk.ijse.hibernate.hostel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer extends Application {
    public static void main(String[] args) {
  /*      Student s1 = new Student();
        s1.setStudentId("S001");
        s1.setName("Sewmini");
        s1.setAddress("Mathugama");
        s1.setContactNo("0705254934");
//        s1.setDob();
        s1.setGender("Female");



        Session session = FactoryConfiguration.getInstance().getSession();2
        Transaction transaction = session.beginTransaction();

        session.save(s1);
//        session.save();

        transaction.commit();
        session.close();*/
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/LoginForm.fxml"))));
        primaryStage.show();
    }
}

