package lk.ijse.hibernate.hostel.service.custom;

import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.service.util.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface RoomBo extends SuperBo {
    public List<RoomDTO> getAll() throws Exception;
    public boolean add(RoomDTO roomDTO) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(RoomDTO roomDTO) throws Exception;
    public RoomDTO search(String id) throws Exception;
    public boolean isExists(String id) throws Exception;
    public String generateNextId() throws Exception;

}
