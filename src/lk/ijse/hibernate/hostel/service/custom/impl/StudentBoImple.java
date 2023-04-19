package lk.ijse.hibernate.hostel.service.custom.impl;

import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.StudentRepository;
import lk.ijse.hibernate.hostel.repository.RepoFactory;
import lk.ijse.hibernate.hostel.service.custom.StudentBo;
import lk.ijse.hibernate.hostel.service.util.Converter;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImple implements StudentBo {
    private final StudentRepository studentRepository = RepoFactory.getInstance().getRepo(RepoFactory.Repo.STUDENT);

    @Override
    public List<StudentDTO> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        List<Student> all = studentRepository.getAll(session);
        ArrayList<StudentDTO> list = new ArrayList<>();
        for (Student student: all) {
            list.add(Converter.fromStudent(student));
           }
        session.close();
        return list;
    }

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String add = studentRepository.add(Converter.toStudent(studentDTO), session);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        studentRepository.delete(id, session);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        studentRepository.update(Converter.toStudent(studentDTO), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public StudentDTO search(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        StudentDTO studentDTO = Converter.fromStudent(studentRepository.search(id, session));
        transaction.commit();
        session.close();
        return studentDTO;

    }

    @Override
    public boolean isExists(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        studentRepository.search(id, session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNextId() throws Exception {
        List<StudentDTO> all = getAll();
        if (all.size() > 0) {
            String studentId = all.get(all.size() - 1).getStudentId();
            String[] split = studentId.split("[S]");
            int i = Integer.parseInt(split[1]);
            i++;
            return String.format("S%08d", i);
        } else {
            return "S00000001";
        }
    }
}
