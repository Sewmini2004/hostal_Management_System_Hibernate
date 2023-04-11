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
    public List<Student> getAll(Session session) throws Exception {
        return session.createQuery("from Student").getResultList();
    }

    @Override
    public String add(Student obj, Session session) throws Exception {
        String save = (String) session.save(obj);
        return save;
    }

    @Override
    public void delete(String id, Session session) throws Exception {
        session.delete(id);
    }

    @Override
    public void update(Student obj, Session session) throws Exception {
        session.update(obj);
    }

    @Override
    public Student search(String id, Session session) throws Exception {
        return session.get(Student.class, id);
    }

    @Override
    public boolean isExists(String id, Session session) throws Exception {
        session.get(Student.class, id);
        return true;
    }

}
