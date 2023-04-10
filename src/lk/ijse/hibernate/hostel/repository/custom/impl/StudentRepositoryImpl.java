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

           return session.createQuery("from Student").getResultList();
 }

    @Override
    public String add(Student obj, Session session) throws SQLException, ClassNotFoundException {
        String save = (String) session.save(obj);
        return save;

    }

    @Override
    public boolean delete(String id, Session session) throws SQLException, ClassNotFoundException {
     session.delete(id);
     return true;
    }

    @Override
    public boolean update(Student obj, Session session) throws SQLException, ClassNotFoundException {
    session.update(obj);
    return true;

    }

    @Override
    public Student search(String id, Session session) throws SQLException, ClassNotFoundException {

     try {
          return session.get(Student.class,id);
        }catch (Exception e){
           return null;
            }
    }

    @Override
    public boolean isExists(String id, Session session) throws SQLException, ClassNotFoundException {

     session.get(Student.class,id);
      return true;

    }

}
