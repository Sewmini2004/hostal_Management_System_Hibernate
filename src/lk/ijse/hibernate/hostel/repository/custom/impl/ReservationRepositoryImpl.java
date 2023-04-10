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

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean add(Reservation obj, Session session) throws SQLException, ClassNotFoundException {
        Transaction transaction = session.beginTransaction();
        try{
            Boolean save = (Boolean) session.save(obj);
            transaction.commit();
            return save;

        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(String id, Session session) throws SQLException, ClassNotFoundException {
        Transaction transaction = session.beginTransaction();
        try{
            Student load = session.load(Student.class, id);
            session.delete(load);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Reservation obj, Session session) throws SQLException, ClassNotFoundException {
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Reservation search(String id, Session session) throws SQLException, ClassNotFoundException {
        try {
            return session.get(Reservation.class,id);
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean isExists(String id, Session session) throws SQLException, ClassNotFoundException {

        Transaction transaction = session.beginTransaction();
        try {
            session.get(Reservation.class,id);
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

}
