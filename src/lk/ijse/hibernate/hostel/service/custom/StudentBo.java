package lk.ijse.hibernate.hostel.service.custom;

import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.service.util.SuperBo;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface StudentBo extends SuperBo {
    public List<StudentDTO> getAll() throws Exception;
    public boolean add(StudentDTO studentDTO) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(StudentDTO studentDTO) throws Exception;
    public StudentDTO search(String id) throws Exception;
    public boolean isExists(String id) throws Exception;
    public String generateNextId() throws Exception;

}
