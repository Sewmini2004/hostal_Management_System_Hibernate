package lk.ijse.hibernate.hostel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.test.Customer;
import lk.ijse.hibernate.hostel.entity.test.Orderr;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
//        launch(args);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        /*--------------------------------------------------------------------------*/

        /*  Customer Object   <--Parent */
        Customer customer = new Customer();
        customer.setId(1);
        customer.setCustName("Vidura");

        List<Orderr> list = new ArrayList<>();
        customer.setOrderList(list);

        /*  Order object    <--Child */
        Orderr orderr = new Orderr();
        orderr.setId(1);
        orderr.setOrderName("CreamCracker");
        orderr.setCustomer(customer);

        //cascade.all thyeddi manika data add krddi arent dmmama child w add unane neda?? innoda oo doy mthda ai attata ahuwe pana ow itin mona krnnd enm doygmu mn ht me tk ekin ek kyl dennmp panata hdee aneeoye athi

//        doygmu enm ht me tk kyl dennm hdee ja ha enm doygmu pana haainn 3n ekn ennm mn hdee ha  ha
        /*
        * Cascade.Persist
        * Cascade.Remove
        * Cascade.Merge
        * Cascade.All ( mek ar hama ekema ekathuwak manika )
        */

        /*  dn manika mn parent dala child wla save krnne onna blnna    */
        customer.getOrderList().add(orderr);

        session.save(customer);
        //dkkda ek thrunda oo mn save kre customer wthrai mthnim hdbai hibernate eyge child lawa argena
        //database eke nthi ay tkath database ekt damma me hmdema Casscade.All nis onn api ek ain krla ayeth blmu manika mekm krnn pluwmd kyla

        //onn wteno dn cascade ain krla blmu manika

//
//        Customer customer = session.get(Customer.class, 1);
        //menna database eke thyena id = 1 unu data ek row eka dn api ek dlt krmu mekt child knkuth inno manika eywth dlt weid blmu
//        session.delete(customer);
        //onn parent dlt kra eya child lawa okkomth dlt krgen thmai delete wennne thrunda manika cascade.All dpu nis hrida hri
        //dn pdi wen ekk dno mn




















        /*--------------------------------------------------------------------------*/
        transaction.commit();
        session.close();

        /*
        thrunda cascade gn tkak oo oy wgemai oy add krddine delete krddidth hrid manika

        Hibernate: create table Customer (id integer not null, custName varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table Orderr (id integer not null, orderName varchar(255), customer_id integer, primary key (id)) engine=InnoDB
Hibernate: alter table Orderr add constraint FK5eowwbfhojpd3a5t7xxw2fauq foreign key (customer_id) references Customer (id)

wradda gannepa me 3 table create wen ewa msk data wten ewa nwei hdee thrunda hri

Hibernate: insert into Customer (custName, id) values (?, ?) mken wthrai data wtenne insert kyn tyhyen ewgen
dn wtila thyenne ek table ektai customer ekt wthrai

        */

    }
}

