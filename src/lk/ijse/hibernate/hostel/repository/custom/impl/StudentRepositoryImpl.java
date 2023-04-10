package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.StudentRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<Student> getAll(Session session) throws SQLException, ClassNotFoundException {
       try {
           return session.createQuery("from Student").getResultList();

       }catch (Exception e){
           return null;
       }
    }

    @Override
    public boolean add(Student obj, Session session) throws SQLException, ClassNotFoundException {
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
    public boolean update(Student obj, Session session) throws SQLException, ClassNotFoundException {
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
    public Student search(String id, Session session) throws SQLException, ClassNotFoundException {

     try {
          return session.get(Student.class,id);
        }catch (Exception e){
            session.getTransaction().rollback();
           return null;
            }
    }

    @Override
    public boolean isExists(String id, Session session) throws SQLException, ClassNotFoundException {
        Transaction transaction = session.beginTransaction();
        try {
            session.get(Room.class,id);
            return true;
             }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

}
