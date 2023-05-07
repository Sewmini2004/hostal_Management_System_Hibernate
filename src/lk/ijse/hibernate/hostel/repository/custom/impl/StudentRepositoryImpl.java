package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.StudentRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<Student> getAll(Session session) throws Exception {
        Query from_student = session.createQuery("from Student");
        from_student.setCacheable(true);
        return from_student.getResultList();
    }

    @Override
    public String add(Student obj, Session session) throws Exception {
        String save = (String) session.save(obj);
        return save;
    }

    @Override
    public void delete(String id, Session session) throws Exception {
        Student load = session.load(Student.class, id);
        session.delete(load);
    }

    @Override
    public void update(Student obj, Session session) throws Exception {
        session.saveOrUpdate(obj);
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
