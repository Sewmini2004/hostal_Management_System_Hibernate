package lk.ijse.hibernate.hostel.service.custom;

import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.service.util.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface RoomBo extends SuperBo {
    public List<RoomDTO> getAll() throws SQLException, ClassNotFoundException;
    public boolean add(RoomDTO roomDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean update(RoomDTO roomDTO) throws SQLException, ClassNotFoundException;
    public RoomDTO search(String id) throws SQLException, ClassNotFoundException;
    public boolean isExists(String id) throws SQLException, ClassNotFoundException;
    public String generateNextId() throws SQLException, ClassNotFoundException;

}
