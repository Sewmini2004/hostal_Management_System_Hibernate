package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.RoomRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public List<Room> getAll(Session session) throws SQLException, ClassNotFoundException {
        try {
            return session.createQuery("from Room").getResultList();

        }catch (Exception e){
            return null;
        }    }

    @Override
    public boolean add(Room obj, Session session) throws SQLException, ClassNotFoundException {
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
    public boolean update(Room obj, Session session) throws SQLException, ClassNotFoundException {
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
    public Room search(String id, Session session) throws SQLException, ClassNotFoundException {
        try {
            return session.get(Room.class,id);
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean isExists(String id, Session session) throws SQLException, ClassNotFoundException {

        Transaction transaction = session.beginTransaction();
        try {
            session.get(Student.class,id);
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

}
