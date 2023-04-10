package lk.ijse.hibernate.hostel.service.custom;

import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.service.util.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface ResevationBo extends SuperBo {
    public List<StudentDTO> getAll() throws SQLException, ClassNotFoundException;
    public boolean add(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean update(StudentDTO studentDTO) throws SQLException, ClassNotFoundException;
    public StudentDTO search(String id) throws SQLException, ClassNotFoundException;
    public boolean isExists(String id) throws SQLException, ClassNotFoundException;
    public String generateNextId() throws SQLException, ClassNotFoundException;

}
