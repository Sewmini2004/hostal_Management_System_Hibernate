package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

//mewai try-catch ain krla ar wge throw krla itpsse exception ne kyl hthgen code tk ghnn manika exception ne kyla
//hthgena kynne api krnn hdna wde awlak nthuw weno kyla eka hrida em hthm krnn exception wisi kr kr

public class ReservationRepositoryImpl implements ReservationRepository {
    @Override
    public List<Reservation> getAll(Session session) throws SQLException, ClassNotFoundException {
        try {
            Query from_reservation = session.createQuery("from Reservation");
            from_reservation.setCacheable(true);
            return from_reservation.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String add(Reservation obj, Session session) throws Exception {
        String save = (String) session.save(obj);
        return save;
    }

    @Override
    public void delete(String id, Session session) throws Exception {
        session.delete(id);
    }

    @Override
    public void update(Reservation obj, Session session) throws Exception {
        session.update(obj);
    }

    @Override
    public Reservation search(String id, Session session) throws Exception {
        try {
            return session.get(Reservation.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isExists(String id, Session session) throws Exception {

        session.get(Reservation.class, id);
        return true;


    }
}
