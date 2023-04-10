package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {
    @Override
    public List<Reservation> getAll(Session session) throws SQLException, ClassNotFoundException {
        try {
            return session.createQuery("from Reservation").getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String add(Reservation obj, Session session) throws SQLException, ClassNotFoundException {
        String save = (String) session.save(obj);
        return save;

    }

    @Override
    public boolean delete(String id, Session session) throws SQLException, ClassNotFoundException {
        session.delete(id);
        return true;
    }

    @Override
    public boolean update(Reservation obj, Session session) throws SQLException, ClassNotFoundException {
        session.update(obj);
        return true;
    }

    @Override
    public Reservation search(String id, Session session) throws SQLException, ClassNotFoundException {
        try {
            return session.get(Reservation.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isExists(String id, Session session) throws SQLException, ClassNotFoundException {

        session.get(Reservation.class, id);
        return true;


    }
}
